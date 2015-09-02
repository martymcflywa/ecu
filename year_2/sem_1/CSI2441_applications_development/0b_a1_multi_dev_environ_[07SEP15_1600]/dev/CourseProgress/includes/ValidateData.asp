<%

'This include contains subs and functions
'associated with validating data retrieved from the form.
'
'@author Martin Ponce, 10371381
'@version 20150831


'**
'* Sub validates student details.
'* Tests if array index is empty before performing validation.
'*
sub validateStudentDetails()

	'validate names
	if studentDetails(FN) <> "" then
		if not isRegExMatch(studentDetails(FN), regExDict.item("name")) then
			call validateError("student", "Firstname", -1, "must be a name.")
		end if
	end if

	if studentDetails(SN) <> "" then
		if not isRegExMatch(studentDetails(SN), regExDict.item("name")) then
			call validateError("student", "Surname", -1, "must be a name.")
		end if
	end if

	'validate student id
	if studentDetails(ID) <> "" then
		if not isRegExMatch(studentDetails(ID), regExDict.item("studentID")) then
			call validateError("student", "Student ID", -1, "must be eight digits.")
		end if
	end if
end sub

'**
'* Sub validates unit details saved in array.
'* Tests if array index is empty before performing validation.
'*
sub validateUnitDetails()

	'loop over unitDetailsArray
	'using filledRows counter to avoid intentionally blank rows
	for i = 0 to filledRows - 1

		'*****************
		'*** UNIT CODE ***
		'*****************

		'if unit code element is empty
		if unitDetails(i, UC) = "" then
			call missingInputError("unit", "Unit Code", i + 1)
		else
			call validateUnitCode(i)
		end if

		'*********************
		'*** CREDIT POINTS ***
		'*********************

		'if credit points element is empty
		if unitDetails(i, CP) = "" then
			call missingInputError("unit", "Credit Points", i + 1)
		else
			call validateCreditPoints(i)
		end if

		'******************
		'*** YEAR / SEM ***
		'******************

		'if year/sem element is empty
		if unitDetails(i, YS) = "" then
			call missingInputError("unit", "Year / Semester", i + 1)
		else
			call validateYearSem(i)
		end if

		'*****************
		'*** UNIT MARK ***
		'*****************

		'if unit mark element is empty
		if unitDetails(i, UM) = "" then
			call missingInputError("unit", "Unit Mark", i + 1)
		else
			call validateUnitMark(i)
		end if
	next
end sub

'**
'* Sub validates Unit Code.
'*
'* @param index int - The current index.
'*
sub validateUnitCode(index)
	'if unit code is valid
	if isRegExMatch(unitDetails(index, UC), regExDict.item("unitCode")) then
		'test course type against unit code
		if (studentDetails(CT) = CT_UNDERGRAD or studentDetails(CT) = CT_UNDERGRAD_DOUBLE) and _
				(getRegExMatch(unitDetails(index, UC), regExDict.item("unitCodeSuffix")) >= 6000) then

			call validateError("unit", "Unit Code", index + 1, "is invalid for undergraduate students. Must be a unit code less than 6000 level.")

		end if
	'else unit code is not valid
	else
		call validateError("unit", "Unit Code", index + 1, "must follow the format: ABC1234.")
	end if
end sub

'**
'* Sub validates Credit Points.
'*
'* @param index int - The current index.
'*
sub validateCreditPoints(index)
	'if credit points is valid
	if isRegExMatch(unitDetails(index, CP), regExDict.item("creditPoints")) then
		'cast to int, so we can do math with it
		unitDetails(index, CP) = cInt(unitDetails(index, CP))
	'else credit points is not valid
	else
		call validateError("unit", "Credit Points", index + 1, "must only be either 15 or 20.")
	end if
end sub

'**
'* Sub validates Year / Sem.
'*
'* @param index int - The current index.
'*
sub validateYearSem(index)
	'if year/sem is not valid
	if not isRegExMatch(unitDetails(index, YS), regExDict.item("yearSem")) then
		call validateError("unit", "Year / Semester", index + 1, "must follow the format:" & _
				"YYS. For example 151. Semester must only be 1 or 2.")
	end if
end sub

'**
'* Sub validates Unit Mark.
'*
'* @param index int - The current index.
'*
sub validateUnitMark(index)

	const MIN_MARK = 0
	const MAX_MARK = 100

	'if unit mark is valid
	if isRegExMatch(unitDetails(index, UM), regExDict.item("mark")) then
		'test unit mark against min/max range
		if cInt(unitDetails(index, UM)) < MIN_MARK or cInt(unitDetails(index, UM)) > MAX_MARK then
			call validateError("unit", "Unit Mark", index + 1, "cannot be less than 0 or greater than 100.")
		else
			'cast to int, so we can do math with it
			unitDetails(index, UM) = cInt(unitDetails(index, UM))
		end if
	'regex not checking if > 3 digit here, since input is limited to 3 chars anyway
	else
		call validateError("unit", "Unit Mark", index + 1, "must be between 1 and 3 digits.")
	end if
end sub

'**
'* Sub initiates logic validation.
'* Creates a copy of unitDetails array and sorts it by Unit Code.
'*
sub validateLogic()

	dim unitDetailsCopy
	unitDetailsCopy = unitDetails

	'sort copy by unit code
	call bubbleSort2D(unitDetailsCopy, 0)

	call getUnitCodeMatches(unitDetailsCopy)
end sub

'**
'* Sub collects any Unit Code matches from an array.
'* Stores those matches in matchedUnits array.
'* matchedUnits array then sent for validation.
'*
'* @parm theArray - The array to look for matches.
'*
sub getUnitCodeMatches(theArray)
	
	dim matchedUnits(15, 4)
	dim matchTally, currentUnitCode

	for i = 0 to filledRows - 1

		'put all matched units in a temp array
		if currentUnitCode = theArray(i, UC) then
			matchTally = matchTally + 1
			matchedUnits(matchTally - 1, UC) = theArray(i, UC)
			matchedUnits(matchTally - 1, CP) = theArray(i, CP)
			matchedUnits(matchTally - 1, YS) = theArray(i, YS)
			matchedUnits(matchTally - 1, UM) = theArray(i, UM)
		else
			currentUnitCode = theArray(i, UC)
		end if
	next

	if matchTally > 0 then
		call validatePassMatchUnits(matchedUnits, matchTally)
		call validateSemMatchUnits(matchedUnits, matchTally)
	end if
end sub

'**
'* Sub implements business rule:
'* A unit cannot appear as passed more than once.
'*
'* @param theArray - The array containing matched Unit Codes
'* @param matchTally int - The number of matches found, used for upper bound.
'*
sub validatePassMatchUnits(theArray, matchTally)

	dim currentUnitCode
	
	for i = 0 to matchTally - 1
		if theArray(i, UC) <> "" and currentUnitCode = theArray(i, UC) and theArray(i, UM) >= MARK_PASS then
			call logicError(theArray(i, UC), "is passed more than once.")
		else
			currentUnitCode = theArray(i, UC)
		end if
	next
end sub

'**
'* Sub implements business rule:
'* A unit cannot appear more than once in the same semester.
'*
'* @param theArray - The array containing matched Unit Codes
'* @param matchTally int - The number of matches found, used for upper bound.
'*
sub validateSemMatchUnits(theArray, matchTally)
	
	dim currentUnitCode, currentSem

	for i = 0 to matchTally - 1
		if theArray(i, UC) <> "" and currentUnitCode = theArray(i, UC) and currentSem = theArray(i, YS) then
			call logicError(theArray(i, UC), "appears more than once in the same semester " & theArray(i, YS) & ".")
		elseif currentUnitCode = theArray(i, UC) and currentSem <> theArray(i, YS) then
			currentSem = theArray(i, YS)
		else
			currentUnitCode = theArray(i, UC)
		end if
	next
end sub
%>