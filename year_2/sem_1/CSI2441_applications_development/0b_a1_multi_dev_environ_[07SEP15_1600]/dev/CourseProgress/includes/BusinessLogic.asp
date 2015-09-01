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

'failed units
dim failedUnitsCount
failedUnitsCount = 0

'dim failedUnits()
'redim failedUnits(10)
'set failedUnits = server.createObject("system.collections.arrayList")

'**
'* Sub kicks off the logic for calculating the course progress summary.
'*
sub calculateSummary()

	call iterateUnitDetails()
	call getCPDelta()
	call getSemRemaining()
	call getCompleteStatus()
	call getMarkAverage()
	call getProgressionStatus()

end sub

'**
'* Sub iterates through unitDetails array, calling other subs when appropriate.
'*
sub iterateUnitDetails()
	
	for i = 0 to unitRows - 1
		if unitDetails(i, UC) <> "" then
			call getUnitAttemptTotal()
			'do this if student passed unit
			if unitDetails(i, UM) >= MARK_PASS then
				call getPassedCP(i)
				call getUnitAttemptPass()
				call getMarkTotal(i)
			'else do this if failed
			else
				call getFailedUnits(i)
			end if
		end if
	next

end sub

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
'* Also determines grade based on markAverage.
'*
sub getMarkAverage()
	markAverage = markTotal / unitAttemptTotal

	if markAverage >= 80 then
		grade = "HD"
	elseif markAverage >= 70 then
		grade = "D"
	elseif markAverage >= 60 then
		grade = "CR"
	elseif markAverage >= 50 then
		grade = "C"
	elseif markAverage >= 0 then
		grade = "N"
	end if
end sub

'**
'* Sub determines progression status of student.
'* If student fails same unit 3 times, progressionStatus == "Excluded"
'*
sub getProgressionStatus()
	
	dim matchTally, currentUnitCode
	matchTally = 0
	currentUnitCode = ""

	if failedUnitsCount > 0 then

		call bubbleSort(failedUnits)

		for i = 0 to failedUnitsCount - 1
			if currentUnitCode = failedUnits(i) then
				matchTally = matchTally + 1
			else
				currentUnitCode = failedUnits(i)
			end if
		next

		if matchTally >= 3 then
			progressionStatus = "Excluded"
		else
			progressionStatus = "Good standing"
		end if
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
		case 1
			if passedCPTotal >= CP_UNDERGRAD then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case 2
			if passedCPTotal >= CP_UNDERGRAD_DOUBLE then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case 3
			if passedCPTotal >= CP_GRAD_DIPLOMA then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case 4
			if passedCPTotal >= CP_MASTERS_COURSE then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
		case 5
			if passedCPTotal >= CP_MASTERS_RESEARCH then
				completeStatus = "Yes"
			else
				completeStatus = "No"
			end if
	end select
end sub

'**
'* Sub sums passed cp total.
'*
'* @param index int - Current array index.
'*
sub getPassedCP(index)
	passedCPTotal = passedCPTotal + unitDetails(index, CP)
end sub

'**
'* Sub totals number of units attempted.
'*
sub getUnitAttemptTotal()
	unitAttemptTotal = unitAttemptTotal + 1
end sub

'**
'* Sub totals number of units passed.
'*
sub getUnitAttemptPass()
	unitsPassed = unitsPassed + 1
end sub

'**
'* Sub calculates cp required to complete course.
'*
sub getCPDelta()
	
	select case studentDetails(CT)
		case 1
			cpDelta = CP_UNDERGRAD - passedCPTotal
		case 2
			cpDelta = CP_UNDERGRAD_DOUBLE - passedCPTotal
		case 3
			cpDelta = CP_GRAD_DIPLOMA - passedCPTotal
		case 4
			cpDelta = CP_MASTERS_COURSE - passedCPTotal
		case 5
			cpDelta = CP_MASTERS_RESEARCH - passedCPTotal
	end select

end sub

'**
'* Sub calculates remaining semesters based on enrolment type.
'*
sub getSemRemaining()
	select case studentDetails(ET)
		case 1
			semRemaining = cpDelta / CP_FULLTIME
		case 2
			semRemaining = cpDelta / CP_PARTTIME
	end select
end sub

'**
'* Sub records failed units into array.
'*
'* @param index int - Current array index.
'*
sub getFailedUnits(index)
	failedUnitsCount = failedUnitsCount + 1
	redim preserve failedUnits(failedUnitsCount)
	failedUnits(failedUnitsCount) = unitDetails(index, UC)
end sub

%>