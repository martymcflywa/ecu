<%

'This include contains subs and functions
'associated with processing data according to business rules.
'
'@author Martin Ponce, 10371381
'@version 20150831

'**
'* Sub kicks off the logic for calculating the course progress summary.
'*
sub calculateSummary()

	call iterateUnitDetails()
	call getCPDelta()
	call getSemRemaining()
	call getProgressionStatus()
	call getCompleteStatus()
	call getMarkAverage()

end sub

'**
'* Sub iterates through unitDetails array, calling other subs when appropriate.
'*
sub iterateUnitDetails()
	
	for i = 0 to unitRows - 1
		if unitDetails(i, UC) <> "" then
			call getUnitAttemptTotal()
			if unitDetails(i, UM) >= MARK_PASS then
				call getPassedCP(i)
				call getUnitAttemptPass()
				call getMarkTotal(i)
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
'* Sub calculates average mark over units passed.
'* Also determines grade based on markAverage.
'*
'* Confirm if correct, or if need to include failed units as well.
'*
sub getMarkAverage()
	markAverage = markTotal / unitsPassed

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
'* TODO: Implement this!
'* If student fails same unit 3 times, progressionStatus = "Excluded from course"
'*
sub getProgressionStatus()
	'dummy status at the moment
	progressionStatus = "Good standing"
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

%>