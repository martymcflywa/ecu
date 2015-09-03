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
'additional index for transcript array
const GR = 4

dim isStudentPopulated, isUnitPopulated
isStudentPopulated = false
isUnitPopulated = false

'keeps track of how many rows in unitDetails is populated
dim filledRows
filledRows = 0

'**
'* Sub sets up the arrays.  
'*
sub setupArrays()
	'count all fields in form
	for each item in request.form
		totalFieldCount = totalFieldCount + 1
	next

	unitFieldCount = totalFieldCount - STUDENT_DETAILS_COUNT + 1 '+1 for submit button
	unitRows = unitFieldCount / UNIT_COLS

	'store all unit details here, adding extra column for grade
	redim unitDetails(unitRows, UNIT_COLS + 1) '+1 for grade

	'init error/fail arrays
	redim studentErrorMessage(STUDENT_DETAILS_COUNT, UNIT_COLS)
	'going for max amount of rows here since can't redim preserve 2d arrays
	redim unitErrorMessage(unitRows * UNIT_COLS, UNIT_COLS)
	redim failedUnits(unitRows, UNIT_COLS)
	redim logicErrorMessage(unitRows, 2)
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

		if isFieldPopulated("UnitCode_" & i + 1) or _
				isFieldPopulated("CP_" & i + 1) or _
				isFieldPopulated("YS_" & i + 1) or _
				isFieldPopulated("UM_" & i + 1) then
			unitDetails(i, UC) = request.form("UnitCode_" & i + 1)
			unitDetails(i, CP) = request.form("CP_" & i + 1)
			unitDetails(i, YS) = request.form("YS_" & i + 1)
			unitDetails(i, UM) = request.form("UM_" & i + 1)
			'get grade
			unitDetails(i, GR) = getGrade(unitDetails(i, UM))
			filledRows = filledRows + 1
			isUnitPopulated = true
		end if
	next
end sub

%>