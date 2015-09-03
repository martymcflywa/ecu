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
			call getSupUnit(i)
		end if

	next

end sub

'**
'* Sub implements business rule:
'* If a student does more than one unit in a given semester,
'* and fails only one unit with a mark in the rage of 45-49,
'* and is in the first or last semester of their course,
'* then the grade for that unit should read "S?" for possible
'* supplementary assessment.
'*
'* !! ASSUMPTION !!
'* Only considers 15 CP per unit, not 20.
'*
'* @param currentUnitCode String - The current unit code during iteration.
sub getSupUnit(index)

	dim fullTimeUnits, partTimeUnits
	fullTimeUnits = 4
	partTimeUnits = 2

	dim currentSem

	'problem: is looking ahead to the next row if matched, and is reset each iteration
				'so if next unit is in different sem, causes fail 
	for i = index + 1 to filledRows - 1
		if unitDetails(index, YS) = unitDetails(i, YS) then
			isMoreThanOneUnitInSem = true
		end if
		if unitDetails(index, YS) = unitDetails(i, YS) and unitDetails(i, UM) < MARK_PASS then
			isFailedSameSem = true
		elseif unitDetails(index, YS) = unitDetails(i - 2, YS) and unitDetails(i, UM) < MARK_PASS then
			isFailedSameSem = true
		end if
	next

	response.write(isMoreThanOneUnitInSem & " " & isFailedSameSem & " |<br/>")

	'test for failed units in same semester, and if at least one other 
	'if isFailedSameSem = false and isMoreThanOneUnitInSem = true then
	if isMoreThanOneUnitInSem = true and isFailedSameSem = false then
		select case studentDetails(ET)
			case CP_FULLTIME
				'first sem fails, can only have one sup mark
				if supFirstCount < 1 and unitAttemptTotal <= fullTimeUnits then 

					if (unitDetails(index, UM) >= MARK_SUP_MIN and unitDetails(index, UM) <= MARK_SUP_MAX) then
						unitDetails(index, GR) = "S?"
						supFirstCount = supFirstCount + 1
						response.write(supFirstCount & " " & unitAttemptTotal & " " & fullTimeUnits & " fire one<br/>")
					end if
				end if

				'last sem fails, can only have one sup mark
				if (supLastCount < 1 and unitAttemptTotal >= ((semTotal * fullTimeUnits) - fullTimeUnits)) and _
						(unitDetails(index, UM) >= MARK_SUP_MIN and unitDetails(index,UM) <= MARK_SUP_MAX) then
					unitDetails(index, GR) = "S?"
					supFirstCount = supLastCount + 1
					response.write("fire two<br/>")	
				end if

			case CP_PARTTIME
				'first sem fails, can only have one sup mark
				if (supFirstCount < 1 and unitAttemptTotal <= partTimeUnits) and _
						(unitDetails(index, UM) >= MARK_SUP_MIN and unitDetails(index, UM) <= MARK_SUP_MAX) then
					unitDetails(index, GR) = "S?"
					supFirstCount = supFirstCount + 1
					response.write("fire three<br/>")	
				end if

				'last sem fails, can only have one sup mark
				if (supLastCount < 1 and unitAttemptTotal >= ((semTotal * partTimeUnits) - partTimeUnits)) and _
						(unitDetails(index, UM) >= MARK_SUP_MIN and unitDetails(index,UM) <= MARK_SUP_MAX) then
					unitDetails(index, GR) = "S?"
					supFirstCount = supLastCount + 1
					response.write("fire four<br/>")	
				end if
		end select
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
'*
sub setProgressionStatus()

	const MAX_FAILS = 3

	if matchFailedCount >= MAX_FAILS then
		progressionStatus = "<font color=""red"">Excluded</font>"
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
'* Sub calculates remaining semesters based on enrolment type.
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