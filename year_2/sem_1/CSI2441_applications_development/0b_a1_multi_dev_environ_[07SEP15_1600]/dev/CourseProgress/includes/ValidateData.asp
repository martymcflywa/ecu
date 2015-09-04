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
			call validateError("student", -1, "Firstname", 1)
		end if
	end if

	if studentDetails(SN) <> "" then
		if not isRegExMatch(studentDetails(SN), regExDict.item("name")) then
			call validateError("student", -1, "Surname", 1)
		end if
	end if

	'validate student id
	if studentDetails(ID) <> "" then
		if not isRegExMatch(studentDetails(ID), regExDict.item("studentID")) then
			call validateError("student", -1, "Student ID", 2)
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
			call missingInputError("unit", i + 1, "Unit Code")
		else
			call validateUnitCode(i)
		end if

		'*********************
		'*** CREDIT POINTS ***
		'*********************

		'if credit points element is empty
		if unitDetails(i, CP) = "" then
			call missingInputError("unit", i + 1, "Credit Points")
		else
			call validateCreditPoints(i)
		end if

		'******************
		'*** YEAR / SEM ***
		'******************

		'if year/sem element is empty
		if unitDetails(i, YS) = "" then
			call missingInputError("unit", i + 1, "Year / Semester")
		else
			call validateYearSem(i)
		end if

		'*****************
		'*** UNIT MARK ***
		'*****************

		'if unit mark element is empty
		if unitDetails(i, UM) = "" then
			call missingInputError("unit", i + 1, "Unit Mark")
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

			call validateError("unit", index + 1, "Unit Code", 3)

		end if
	'else unit code is not valid
	else
		call validateError("unit", index + 1, "Unit Code", 4)
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
		call validateError("unit", index + 1, "Credit Points", 5)
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
		call validateError("unit", index + 1, "Year / Semester", 6)
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
			call validateError("unit", index + 1, "Unit Mark", 7)
		else
			'cast to int, so we can do math with it
			unitDetails(index, UM) = cInt(unitDetails(index, UM))
		end if
	'regex not testing > 3 digit here, since input is limited to 3 chars anyway
	else
		call validateError("unit", index + 1, "Unit Mark", 8)
	end if
end sub

'**
'* Sub initiates logic validation.
'*
sub validateLogic()
	call getUnitMatches(unitDetails)
end sub

'**
'* Sub searches array for matched Unit Codes, calls appropriate sub when found.
'*
'* @param theArray - The array to search.
'*
sub getUnitMatches(theArray)

	dim currentUnitCode, currentSem

	for i = 0 to filledRows - 1

		if theArray(i, UC) <> "" then

			currentUnitCode = theArray(i, UC)
			currentSem = theArray(i, YS)
		
			for j = i + 1 to filledRows - 1
				call validatePassMatchUnits(currentUnitCode, theArray, i, j)
				'call validateSemMatchUnits(currentUnitCode, currentSem, theArray, i, j)
			next
		end if
	next
end sub

'**
'* Sub implements business rule:
'* A unit cannot appear as Passed more than once.
'*
'* @param currentUnitCode String - The current unit code during iteration.
'* @param theArray - The array with data being validated.
'* @param indexI int - The current index during iteration.
'* @param indexJ int - The current index + 1.
'*
sub validatePassMatchUnits(currentUnitCode, theArray, indexI, indexJ)

	dim isWrite
	isWrite = true

	'main test to validate business rule
	if currentUnitCode = theArray(indexJ, UC) and theArray(J, UM) >= MARK_PASS then

		'if there are more then one entries in logicErrorMessage
		if logicErrorCount > 0 then
			'loop over logic errors to find matches before storing new entry
			for k = 0 to logicErrorCount - 1
				'if a match is found,
				if currentUnitCode = logicErrorMessage(k, LE_FIELD) and _
						logicErrorMessage(k, LE_ECODE) = 9 and _
						logicErrorMessage(k, LE_ROW_1) = indexI + 1 then

					'set isWrite to false
					isWrite = false
				end if
			next

			'only write error if isWrite is true
			if isWrite then
				call logicError(theArray(indexI, UC), 9, theArray(indexI, YS), indexI + 1, indexJ + 1)
			end if
		'else this is the first entry, post it up
		else 
			call logicError(theArray(indexI, UC), 9, theArray(indexI, YS), indexI + 1, indexJ + 1)
		end if
	end if
end sub

'**
'* Sub implements business rule:
'* A unit cannot appear more than once in the same semester.
'*
'* @param currentUnitCode String - The current unit code during iteration.
'* @param theArray - The array with data being validated.
'* @param indexI int - The current index during iteration.
'* @param indexJ int - The current index + 1.
'*
sub validateSemMatchUnits(currentUnitCode, currentSem, theArray, indexI, indexJ)
	if currentUnitCode = theArray(indexJ, UC) and currentSem = theArray(indexJ, YS) then
		call logicError(theArray(indexI, UC), 10, theArray(indexI, YS), indexI + 1, indexJ + 1)
	end if
end sub

%>