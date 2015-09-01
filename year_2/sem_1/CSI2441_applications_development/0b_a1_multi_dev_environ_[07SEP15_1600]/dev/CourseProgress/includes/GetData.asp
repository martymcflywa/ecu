<%

'This include contains subs and functions
'associated with retrieving data from the form.
'
'@author Martin Ponce, 10371381
'@version 20150831

'index for student details array
const FN = 0
const SN = 1
const ET = 2
const ID = 3
const CT = 4

'index for unit details array
const UC = 0
const CP = 1
const YS = 2
const UM = 3

dim isStudentPopulated, isUnitPopulated
isStudentPopulated = false
isUnitPopulated = false

'**
'* Sub sets up the input array.  
'*
sub setupUnitDetailsArray()
	'count all fields in form
	for each item in request.form
		totalFieldCount = totalFieldCount + 1
	next

	unitFieldCount = totalFieldCount - STUDENT_DETAILS_COUNT + 1 '+1 for submit button
	unitRows = unitFieldCount / UNIT_COLS

	redim unitDetails(unitRows, UNIT_COLS)

	'reinit errorMessage array with max size
	'redim errorMessage(STUDENT_DETAILS_COUNT + unitRows)
end sub

'**
'* Sub gets all student details from form, enters them into student details array.
'* Generates errors if any values are missing.
'*
sub getStudentDetails()
	if isFieldPopulated("Firstname") then
		studentDetails(FN) = request.form("Firstname")
		isStudentPopulated = true
	else
		call missingInputError("student", "Firstname", -1)
	end if

	if isFieldPopulated("Surname") then
		studentDetails(SN) = request.form("Surname")
		isStudentPopulated = true
	else
		call missingInputError("student", "Surname", -1)
	end if

	'not testing this for population since it has default value
	studentDetails(ET) = cInt(request.form("EnrolmentType"))

	if isFieldPopulated("StudentID") then
		studentDetails(ID) = request.form("StudentID")
		isStudentPopulated = true
	else
		call missingInputError("student", "StudentID", -1)
	end if

	'not testing this for population since it has default value
	studentDetails(CT) = cInt(request.form("CourseType"))

end sub

'**
'* Sub gets all unit values from form, enters them into input array.
'* Generates errors if any values are missing from partially filled row.
'*
sub getUnitDetails()

	for i = 0 to unitRows - 1

		'add all completely populated rows to array, ignore completely empty rows
		if isFieldPopulated("UnitCode_" & i + 1) and _
				isFieldPopulated("CP_" & i + 1) and _
				isFieldPopulated("YS_" & i + 1) and _
				isFieldPopulated("UM_" & i + 1) then
			unitDetails(i, UC) = request.form("UnitCode_" & i + 1)
			unitDetails(i, CP) = request.form("CP_" & i + 1)
			unitDetails(i, YS) = request.form("YS_" & i + 1)
			unitDetails(i, UM) = request.form("UM_" & i + 1)
			isUnitPopulated = true

		'else generate errors for partially completed rows
		else
			if not isFieldPopulated("UnitCode_" & i + 1) and _
					(isFieldPopulated("CP_" & i + 1) or _
					isFieldPopulated("YS_" & i + 1) or _
					isFieldPopulated("UM_" & i + 1)) then
				call missingInputError("unit", "Unit Code", i + 1)
				isUnitPopulated = true
			end if

			if not isFieldPopulated("CP_" & i + 1) and _
					(isFieldPopulated("UnitCode_" & i + 1) or _
					isFieldPopulated("YS_" & i + 1) or _
					isFieldPopulated("UM_" & i + 1)) then
				call missingInputError("unit", "Credit Points", i + 1)
				isUnitPopulated = true
			end if

			if not isFieldPopulated("YS_" & i + 1) and _
					(isFieldPopulated("UnitCode_" & i + 1) or _
					isFieldPopulated("CP_" & i + 1) or _
					isFieldPopulated("UM_" & i + 1)) then
				call missingInputError("unit", "Year / Semester", i + 1)
				isUnitPopulated = true
			end if

			if not isFieldPopulated("UM_" & i + 1) and _
					(isFieldPopulated("UnitCode_" & i + 1) or _
					isFieldPopulated("CP_" & i + 1) or _
					isFieldPopulated("YS_" & i + 1)) then
				call missingInputError("unit", "Unit Mark", i + 1)
				isUnitPopulated = true
			end if
		end if

	next

end sub

%>