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
'additional grade index, for transcript display
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
	redim studentErrorMessage(STUDENT_DETAILS_COUNT, 3)
	'going for max amount of rows here since can't redim preserve 2d arrays
	redim unitErrorMessage(unitRows * UNIT_COLS, 3)
	redim failedUnits(unitRows, UNIT_COLS) 'delete this
	redim logicErrorMessage(unitRows, 5)
	redim highestMark(UNIT_COLS + 1) '+1 for grade
	'init mark with 0
	highestMark(UM) = 0
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
		call missingInputError("student", -1, "Firstname")
	end if

	if isFieldPopulated("Surname") then
		studentDetails(SN) = request.form("Surname")
		isStudentPopulated = true
	else
		call missingInputError("student", -1, "Surname")
	end if

	'convert definition into literal value
	select case cInt(request.form("EnrolmentType"))
		case 1
			studentDetails(ET) = CP_FULLTIME
		case 2
			studentDetails(ET) = CP_PARTTIME
	end select

	if isFieldPopulated("StudentID") then
		studentDetails(ID) = request.form("StudentID")
		isStudentPopulated = true
	else
		call missingInputError("student", -1, "StudentID")
	end if

	'convert definition into literal value
	select case cInt(request.form("CourseType"))
		case 1
			studentDetails(CT) = CP_UNDERGRAD
		case 2
			studentDetails(CT) = CP_UNDERGRAD_DOUBLE
		case 3
			studentDetails(CT) = CP_GRAD_DIPLOMA
		case 4
			studentDetails(CT) = CP_MASTERS_COURSE
		case 5
			studentDetails(CT) = CP_MASTERS_RESEARCH
	end select
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

			filledRows = filledRows + 1
			isUnitPopulated = true
		end if
	next
end sub

'**
'* Sub sets highest mark.
'* Limitation: Does not display ties.
'* Only first highest will be shown if there are ties.
'*
'* @param unitCode String.
'* @param creditPoints int.
'* @param sem String.
'* @param mark int.
'* @param grade String. 
'*
sub setHighestMark(unitCode, creditPoints, sem, mark, grade)
	highestMark(UC) = unitCode
	highestMark(CP)	= creditPoints
	highestMark(YS)	= sem
	highestMark(UM) = mark
	highestMark(GR) = grade 
end sub

%>