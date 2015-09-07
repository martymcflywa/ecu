<%

'This include contains subs and functions
'associated with processing data according to business rules.
'
'@author Martin Ponce, 10371381
'@version 20150831

'constants
const CT_UNDERGRAD = 1
const CT_UNDERGRAD_DOUBLE = 2
const CT_GRAD_DIPLOMA = 3
const CT_MASTERS_COURSE = 4
const CT_MASTERS_RESEARCH = 5

const CP_UNDERGRAD = 360
const CP_UNDERGRAD_DOUBLE = 480
const CP_GRAD_DIPLOMA = 120
const CP_MASTERS_COURSE = 180
const CP_MASTERS_RESEARCH = 240

const CP_FULLTIME = 60
const CP_PARTTIME = 30

const MARK_PASS = 50
const MARK_SUP_MIN = 45
const MARK_SUP_MAX = 49

'failed units
dim failedUnitsCount, matchFailedCount, supFirstCount, supLastCount
'to assist calculating remaining semesters
dim failedUnitsCP

'**
'* Sub kicks off the logic for calculating the course progress summary.
'*
sub calculateSummary()

	call getSemTotal()
	call iterateUnitDetails()
	call getCPDelta()
	call getCompleteStatus()
	call getMarkAverage()
	call setProgressionStatus()
	call getSemRemaining()
	call getSupUnit()

end sub

'**
'* Sub iterates through unitDetails array, calling other subs when appropriate.
'*
sub iterateUnitDetails()
	
	for i = 0 to filledRows - 1

		call getUnitAttemptTotal()
		'do this if student passed unit
		if unitDetails(i, UM) >= MARK_PASS then
			call getPassedCP(i)
			call getUnitAttemptPass()
			call getMarkTotal(i)
		'else do this if failed
		else
			call getProgressionStatus(i)
		end if

	next

end sub

'**
'* Sub implements business rule:
'* If a student does more than one unit in a given semester,
'* and fails only one unit with a mark in the range of 45-49,
'* and is in the first or last semester of their course,
'* then the grade for that unit should read "S?" for possible
'* supplementary assessment.
'*
'* !! ASSUMPTIONS/LIMITATIONS !!
'* 1. Only considers 15 CP per unit, not 20.
'* 2. User input must be in correct order according to semester!
'* 3. See *POST S? DETERMINATION*, in function below
'*
sub getSupUnit()
	
	dim isSup, firstSem, lastSem, fullTimeUnits, partTimeUnits
	dim isMultiFirstSem, isMultiLastSem, firstSemFails, lastSemFails

	isSup = false
	isMultiFirstSem = false
	isMultiLastSem = false

	'assuming that user will enter their first sem FIRST!
	firstSem = unitDetails(0, YS)
	fullTimeUnits = 4
	partTimeUnits = 2
	
	dim unitsPerSem, lastSemStart

	'work out what lastSem and unitsPerSem will be,
	'saves conditional code for full/parttime students
	if studentDetails(ET) = CP_FULLTIME then
		lastSemStart = (semTotal * fullTimeUnits) - fullTimeUnits
		unitsPerSem = fullTimeUnits
	else
		lastSemStart = (semTotal * partTimeUnits) - partTimeUnits
		unitsPerSem = partTimeUnits
	end if

	'*****************
	'*** FIRST SEM ***
	'*****************

	'if student has attempted a unit during first sem,
	if unitAttemptTotal > 0 then
		'first loop sets the flags used for testing
		for i = 0 to unitsPerSem - 1
			'test for more than one units attempted during first sem
			if firstSem = unitDetails(i, YS) then
				isMultiFirstSem = true
			end if
			'test for more than one fails during first semester
			if unitDetails(i, UM) < MARK_PASS then
				firstSemFails = firstSemFails + 1
			end if
		next
		'second loop uses flags to determine if eligible for "S?" grade
		for i = 0 to unitsPerSem - 1
			if isMultiFirstSem and firstSemFails < 2 and _
					unitDetails(i, UM) >= MARK_SUP_MIN and _
					unitDetails(i, UM) <= MARK_SUP_MAX then

				unitDetails(i, GR) = "S?"
				isSup = true
			end if
		next
	end if

	'****************
	'*** LAST SEM ***
	'****************

	'if student has attempted a unit during last sem,
	if unitAttemptTotal >= lastSemStart then
		'set the last sem as the last input from the user
		lastSem = unitDetails(unitAttemptTotal - 1, YS)

		'first loop sets the flags used for testing
		for i = lastSemStart + 1 to filledRows - 1
			'test for more than one units attempted during last semester
			if lastSem = unitDetails(i - 1, YS) then
				isMultiLastSem = true
			end if
			'test for more than one fails during last semester
			if unitDetails(i, UM) < MARK_PASS then
				lastSemFails = lastSemFails + 1
			end if
		next
		'second loop uses flags to determine if eligible for "S?" grade
		for i = lastSemStart to filledRows - 1
			if isMultiLastSem and lastSemFails < 2 and _
					unitDetails(i, UM) >= MARK_SUP_MIN and _
					unitDetails(i, UM) <= MARK_SUP_MAX then

				unitDetails(i, GR) = "S?"
				isSup = true
			end if
		next
	end if

	'*****************************
	'*** POST S? DETERMINATION ***
	'*****************************

	'problem with this if statement:
	'if student has S?, N, S? for one unit, and also fails a different unit three times during course,
	'the if statement below will negate exclusion.

	'implementing rule:
	'if same unit x3 fails but supp, then still good standing
	if isSup and progressionStatus = "Excluded" then
		progressionStatus = "Good standing, pending supp"
	end if

end sub

'**
'* Function determines the grade of a mark.
'*
'* @param mark int - The mark to grade.
'* @return grade String - The grade.
'*
function getGrade(mark)

	dim grade

	if mark >= 80 then
		grade = "HD"
	elseif mark >= 70 then
		grade = "D"
	elseif mark >= 60 then
		grade = "CR"
	elseif mark >= 50 then
		grade = "C"
	elseif mark >= 0 then
		grade = "N"
	end if

	getGrade = grade

end function

'**
'* Sub sums mark total.
'*
'* @param index int - Current array index.
'*
sub getMarkTotal(index)
	markTotal = markTotal + unitDetails(index, UM)
end sub

'**
'* Sub calculates average mark over total units attempted.
'* Also sets grade for average.
'*
sub getMarkAverage()
	markAverage = markTotal / unitAttemptTotal
	gradeAverage = getGrade(markAverage)
end sub

'**
'* Sub determines progression status.
'*
'* @param index int - The current array index.
'*
sub getProgressionStatus(index)

	dim currentUnitCode

	currentUnitCode = unitDetails(index, UC)

	failedUnitsCount = failedUnitsCount + 1

	for i = index + 1 to filledRows - 1
		if currentUnitCode = unitDetails(i, UC) and unitDetails(i, UM) < MARK_PASS then
			matchFailedCount = matchFailedCount + 1
		end if
	next
end sub

'**
'* Sub sets progression status.
'* If student fails same unit 3 times or more,
'* status is "Excluded".
'*
sub setProgressionStatus()

	const MAX_FAILS = 3

	if matchFailedCount >= MAX_FAILS then
		progressionStatus = "Excluded"
	else
		progressionStatus = "Good standing"
	end if
end sub

'**
'* Sub compares student's course type and passed credit points total.
'* If greater than, student has completed course, else not complete.
'*
sub getCompleteStatus()

	if passedCPTotal >= studentDetails(CT) then
		completeStatus = "Yes"
	else
		completeStatus = "No"
	end if
end sub

'**
'* Sub sums passed CP total.
'*
'* @param index int - Current array index.
'*
sub getPassedCP(index)
	passedCPTotal = passedCPTotal + unitDetails(index, CP)
end sub

'**
'* Sub sums number of units attempted.
'*
sub getUnitAttemptTotal()
	unitAttemptTotal = unitAttemptTotal + 1
end sub

'**
'* Sub sums number of units passed.
'*
sub getUnitAttemptPass()
	unitsPassed = unitsPassed + 1
end sub

'**
'* Sub calculates CP required to complete course.
'*
sub getCPDelta()

	cpDelta = studentDetails(CT) - passedCPTotal

	'limit cpDelta to >= 0, to avoid showing negative int when student has passed more than required units for their course
	'also implies semRemaining >= 0

	'couldn't find a max() function for asp, use if instead
	if cpDelta < 0 then
		cpDelta = 0
	end if

end sub

'**
'* Function sets the number of semesters remaining for a student.
'* If student has no failed units: Divide cpDelta by student's enrolment type value.
'* Else student has failed a unit: Sum cpDelta and failedUnitsCP, then divide by student's enrolment type value.
'*
sub getSemRemaining()

	if failedUnitsCount = 0 then
		semRemaining = cpDelta / studentDetails(ET)
	else
		semRemaining = (cpDelta + failedUnitsCP) / studentDetails(ET)
	end if
end sub

'**
'* Sub calculates total required semesters for student.
'*
sub getSemTotal()
	semTotal = studentDetails(CT) / studentDetails(ET)
end sub
%>