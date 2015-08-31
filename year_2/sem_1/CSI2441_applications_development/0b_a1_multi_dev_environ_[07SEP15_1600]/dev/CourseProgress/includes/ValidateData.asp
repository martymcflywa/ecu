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
			call validateError("Firstname", "must be a name")
		end if
	end if

	if studentDetails(SN) <> "" then
		if not isRegExMatch(studentDetails(SN), regExDict.item("name")) then
			call validateError("Surname", "must be a name")
		end if
	end if

	'validate student id
	if studentDetails(ID) <> "" then
		if not isRegExMatch(studentDetails(ID), regExDict.item("studentID")) then
			call validateError("Student ID", "must be numeric")
		end if

		if len(studentDetails(ID)) < 8 then
			call validateError("Student ID", "must be at least 8 numbers")
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

	for i = 0 to unitRows - 1

		'only testing for unit code, since if that is empty, the whole row in array is empty
		if unitDetails(i, UC) <> "" then

			'**************************
			'*** validate unit code ***
			'**************************

			'test validity of unit code
			if isRegExMatch(unitDetails(i, UC), regExDict.item("unitCode")) then

				'check course type against unit code
				if (studentDetails(CT) = CT_UNDERGRAD or studentDetails(CT) = CT_UNDERGRAD_DOUBLE) and _
						(getRegExMatch(unitDetails(i, UC), regExDict.item("unitCodeSuffix")) >= 6000) then

					call validateError("Unit Code " & unitDetails(i, UC) & " at row " & (i + 1), _
							"is invalid for undergraduate students. Must be a unit code less than 6000 level.")

				end if

			else

				call validateError("Unit Code: " & unitDetails(i, UC) & " at row " & (i + 1), "must follow the format: ABC1234")

			end if

			'******************************
			'*** validate credit points ***
			'******************************

			if isRegExMatch(unitDetails(i, CP), regExDict.item("creditPoints")) then

				'cast to int, so we can do math with it
				unitDetails(i, CP) = cInt(unitDetails(i, CP))

			else

				call validateError("Credit Points: " & unitDetails(i, CP) & " at row " & (i + 1), "must only be either 15 or 20")

			end if

			'*************************
			'*** validate year/sem ***
			'*************************

			if not isRegExMatch(unitDetails(i, YS), regExDict.item("yearSem")) then

				call validateError("Year / Semester: " & unitDetails(i, YS) & " at row " & (i + 1), "must follow the format: " & _
						"YYS, ie 151 or 152. Semester must only be 1 or 2")

			end if

			'*********************
			'*** validate mark ***
			'*********************


			if isRegExMatch(unitDetails(i, UM), regExDict.item("mark")) then

				if cInt(unitDetails(i, UM)) < MIN_MARK or cInt(unitDetails(i, UM)) > MAX_MARK then

					call validateError("Mark: " & unitDetails(i, UM) & " at row " & (i + 1), _
							"must not be less than 0, or greater than 100")

				else

					'cast to int, so we can do math with it
					unitDetails(i, UM) = cInt(unitDetails(i, UM))

				end if

			'regex not checking if > 3 digit here, since input is limited to 3 chars anyway
			else

				call validateError("Mark: " & unitDetails(i, UM) & " at row " & (i + 1), "must be between 1 and 3 digits")

			end if

		end if
	next
	
end sub

%>