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

	dim currentSem, semUnits, semFails
	
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
'*
'* TODO: 	Operation is expensive, multiple consecutive loops.
'* 			Needs simplifying. But at least it works.
'*			Not DRY, to add more subs.
'*
sub getSupUnit()
	
	dim isSup, firstSem, lastSem, fullTimeUnits, partTimeUnits
	dim isMultiFirstSem, isMultiLastSem, firstSemFails, lastSemFails
	dim markSupMin, markSupMax
	'range of marks elegible for "S?"
	markSupMin = 45
	markSupMax = 49
	isSup = false

	'assuming that user will enter their first sem FIRST!
	firstSem = unitDetails(0, YS)
	fullTimeUnits = 4
	partTimeUnits = 2

	'work out what is "last semester",
	'again assuming that user enters units by order of year/sem
	dim lastSemStartFT, lastSemStartPT
	lastSemStartFT = (semTotal * fullTimeUnits) - fullTimeUnits
	lastSemStartPT = (semTotal * partTimeUnits) - partTimeUnits

	select case studentDetails(ET)

		'****************
		'*** FULLTIME ***
		'****************

		case CP_FULLTIME

			'*****************
			'*** FIRST SEM ***
			'*****************

			if unitAttemptTotal > 1 then
				'set the flags used for testing
				for i = 0 to fullTimeUnits - 1
					if firstSem = unitDetails(i, YS) then
						isMultiFirstSem = true
					end if
					if unitDetails(i, UM) < MARK_PASS then
						firstSemFails = firstSemFails + 1
					end if
				next
				'test flags for "S?", only until fullTimeUnits, no point checking the rest
				for i = 0 to fullTimeUnits - 1
					if isMultiFirstSem and firstSemFails < 2 and _
							unitDetails(i, UM) >= markSupMin and unitDetails(i, UM) <= markSupMax then
						unitDetails(i, GR) = "S?"
						isSup = true
					end if
				next
			end if

			'****************
			'*** LAST SEM ***
			'****************

			if unitAttemptTotal >= lastSemStartFT then
				'set lastSem as the last input from user
				lastSem = unitDetails(unitAttemptTotal - 1, YS)
				'set the flags used for testing
				for i = lastSemStartFT to filledRows - 1
					if lastSem = unitDetails(i, YS) then
						isMultiLastSem = true
					end if
					if unitDetails(i, UM) < MARK_PASS then
						lastSemFails = lastSemFails + 1
					end if
				next
				'test flags for "S?", let's go to the end of the array this time
				for i = lastSemStartFT to filledRows - 1
					if isMultiLastSem and lastSemFails < 2 and _
							unitDetails(i, UM) >= markSupMin and unitDetails(i, UM) <= markSupMax then
						unitDetails(i, GR) = "S?"
						isSup = true
					end if
				next
			end if

		'****************
		'*** PARTTIME ***
		'****************

		case CP_PARTTIME

			'*****************
			'*** FIRST SEM ***
			'*****************

			if unitAttemptTotal > 1 then
				'set the flags used for testing
				for i = 0 to partTimeUnits - 1
					if firstSem = unitDetails(i, YS) then
						isMultiFirstSem = true
					end if
					if unitDetails(i, UM) < MARK_PASS then
						firstSemFails = firstSemFails + 1
					end if
				next
				'test flags for "S?", only until partTimeUnits, no point checking the rest
				for i = 0 to partTimeUnits - 1
					if isMultiFirstSem and firstSemFails < 2 and _
							unitDetails(i, UM) >= markSupMin and unitDetails(i, UM) <= markSupMax then
						unitDetails(i, GR) = "S?"
						isSup = true
					end if
				next
			end if

			'****************
			'*** LAST SEM ***
			'****************

			if unitAttemptTotal >= lastSemStartPT then
				'set lastSem as the last input from user
				lastSem = unitDetails(unitAttemptTotal - 1, YS)
				'set the flags used for testing
				for i = lastSemStartPT to filledRows - 1
					if lastSem = unitDetails(i, YS) then
						isMultiLastSem = true
					end if
					if unitDetails(i, UM) < MARK_PASS then
						lastSemFails = lastSemFails + 1
					end if
				next
				'test flags for "S?", let's go to the end of the array this time
				for i = lastSemStartPT to filledRows - 1
					if isMultiLastSem and lastSemFails < 2 and _
							unitDetails(i, UM) >= markSupMin and unitDetails(i, UM) <= markSupMax then
						unitDetails(i, GR) = "S?"
						isSup = true
					end if
				next
			end if
	end select

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
	
	select case studentDetails(CT)
		case CP_UNDERGRAD
			if passedCPTotal >= CP_UNDERGRAD then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case CP_UNDERGRAD_DOUBLE
			if passedCPTotal >= CP_UNDERGRAD_DOUBLE then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case CP_GRAD_DIPLOMA
			if passedCPTotal >= CP_GRAD_DIPLOMA then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case CP_MASTERS_COURSE
			if passedCPTotal >= CP_MASTERS_COURSE then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case CP_MASTERS_RESEARCH
			if passedCPTotal >= CP_MASTERS_RESEARCH then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
	end select
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
	
	select case studentDetails(CT)
		case CP_UNDERGRAD
			cpDelta = CP_UNDERGRAD - passedCPTotal
		case CP_UNDERGRAD_DOUBLE
			cpDelta = CP_UNDERGRAD_DOUBLE - passedCPTotal
		case CP_GRAD_DIPLOMA
			cpDelta = CP_GRAD_DIPLOMA - passedCPTotal
		case CP_MASTERS_COURSE
			cpDelta = CP_MASTERS_COURSE - passedCPTotal
		case CP_MASTERS_RESEARCH
			cpDelta = CP_MASTERS_RESEARCH - passedCPTotal
	end select

end sub

'**
'* Function sets the number of semesters remaining for a student.
'* If student has no failed units: Divide remaining CP required by student's enrolment type value.
'* Else student has failed a unit: Add remaining CP to failedUnitsCP, then divide by student's enrolment type value.
'*
sub getSemRemaining()
	select case studentDetails(ET)
		case CP_FULLTIME
			if failedUnitsCount = 0 then
				semRemaining = cpDelta / CP_FULLTIME
			else
				semRemaining = (cpDelta + failedUnitsCP) / CP_FULLTIME
			end if
		case CP_PARTTIME
			if failedUnitsCount = 0 then
				semRemaining = cpDelta / CP_PARTTIME
			else
				semRemaining = (cpDelta + failedUnitsCP) / CP_PARTTIME
			end if
	end select
end sub

sub getSemTotal()
	semTotal = studentDetails(CT) / studentDetails(ET)
end sub
%>