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
	
	const MIN_MARK = 0
	const MAX_MARK = 100

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
			'if unit code is valid
			if isRegExMatch(unitDetails(i, UC), regExDict.item("unitCode")) then
				'test course type against unit code
				if (studentDetails(CT) = CT_UNDERGRAD or studentDetails(CT) = CT_UNDERGRAD_DOUBLE) and _
						(getRegExMatch(unitDetails(i, UC), regExDict.item("unitCodeSuffix")) >= 6000) then

					call validateError("unit", "Unit Code", i + 1, "is invalid for undergraduate students. Must be a unit code less than 6000 level.")

				end if
			'else unit code is not valid
			else
				call validateError("unit", "Unit Code", i + 1, "must follow the format: ABC1234.")
			end if
		end if

		'*********************
		'*** CREDIT POINTS ***
		'*********************

		'if credit points element is empty
		if unitDetails(i, CP) = "" then
			call missingInputError("unit", "Credit Points", i + 1)
		else
			'if credit points is valid
			if isRegExMatch(unitDetails(i, CP), regExDict.item("creditPoints")) then
				'cast to int, so we can do math with it
				unitDetails(i, CP) = cInt(unitDetails(i, CP))
			'else credit points is not valid
			else
				call validateError("unit", "Credit Points", i + 1, "must only be either 15 or 20.")
			end if
		end if

		'******************
		'*** YEAR / SEM ***
		'******************

		'if year/sem element is empty
		if unitDetails(i, YS) = "" then
			call missingInputError("unit", "Year / Semester", i + 1)
		else
			'if year/sem is not valid
			if not isRegExMatch(unitDetails(i, YS), regExDict.item("yearSem")) then
				call validateError("unit", "Year / Semester", i + 1, "must follow the format:" & _
						"YYS. For example 151. Semester must only be 1 or 2.")
			end if
		end if

		'*****************
		'*** UNIT MARK ***
		'*****************

		'if unit mark element is empty
		if unitDetails(i, UM) = "" then
			call missingInputError("unit", "Unit Mark", i + 1)
		else
			'if unit mark is valid
			if isRegExMatch(unitDetails(i, UM), regExDict.item("mark")) then
				'test unit mark against min/max range
				if cInt(unitDetails(i, UM)) < MIN_MARK or cInt(unitDetails(i, UM)) > MAX_MARK then
					call validateError("unit", "Unit Mark", i + 1, "cannot be less than 0 or greater than 100.")
				else
					'cast to int, so we can do math with it
					unitDetails(i, UM) = cInt(unitDetails(i, UM))
				end if
			'regex not checking if > 3 digit here, since input is limited to 3 chars anyway
			else
				call validateError("unit", "Unit Mark", i + 1, "must be between 1 and 3 digits.")
			end if
		end if
	next
end sub

%>