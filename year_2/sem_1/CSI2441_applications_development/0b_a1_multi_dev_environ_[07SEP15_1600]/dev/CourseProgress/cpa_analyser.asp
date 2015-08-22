<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>CPA 2015</title>
</head>

<body>

<h1>Course Progression Summary</h1>
<hr />

<%

'****************************
'*** SETTING UP VARIABLES ***
'****************************

'constants
const UNDERGRAD = 360
const UNDERGRAD_DOUBLE = 480
const GRAD_DIPLOMA = 120
const MASTER_COURSE = 180
const MASTER_RESEARCH = 240

'constants to work out unit details array dimensions
const UNIT_COLS = 4
const STUDENT_DETAILS_COUNT = 5

dim item, totalFieldCount, unitFieldCount, unitRows
totalFieldCount = 0
unitFieldCount = 0
unitRows = 0

'array for student details
dim studentDetails()
redim studentDetails(STUDENT_DETAILS_COUNT)

'array for unit details
dim unitDetails()

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

'variables to generate error messages
dim errorMessage(), errorCount


'****************************
'*** START MAINLINE LOGIC ***
'****************************

call setupUnitDetailsArray()
call getStudentDetails()
call getUnitDetails()


'delete after testing
for each item in studentDetails
	response.write(item & "<br />")
next

'**************************
'*** SUBS AND FUNCTIONS ***
'**************************

'*
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
	redim errorMessage(STUDENT_DETAILS_COUNT + unitRows)
end sub

'*
'* Sub gets all student details from form, enters them into student details array.
'* Generates errors if any values are missing.
'*
sub getStudentDetails()
	if isPopulated("Firstname") then
		studentDetails(FN) = request.form("Firstname")
	else
		call missingStudentDetailsError("Firstname")
	end if

	if isPopulated("Surname") then
		studentDetails(SN) = request.form("Surname")
	else
		call missingStudentDetailsError("Surname")
	end if

	'not testing this for population since it has default value
	studentDetails(ET) = request.form("EnrolmentType")

	if isPopulated("StudentID") then
		studentDetails(ID) = request.form("StudentID")
	else
		call missingStudentDetailsError("StudentID")
	end if

	'not testing this for population since it has default value
	studentDetails(CT) = request.form("CourseType")

end sub

sub missingStudentDetailsError(missingValue)
	errorCount = errorCount + 1
	errorMessage(errorCount) = "<strong>" & missingValue & "</strong> must be provided."
end sub

'*
'* Sub gets all unit values from form, enters them into input array.
'* Generates errors if any values are missing from partially filled row.
'*
sub getUnitDetails()

	for i = 0 to unitRows

		'add all completely populated rows to array, ignore completely empty rows
		if isPopulated("UnitCode_" & i) and _
				isPopulated("CP_" & i) and _
				isPopulated("YS_" & i) and _
				isPopulated("UM_" & i) then
			unitDetails(i - 1, UC) = request.form("UnitCode_" & i)
			unitDetails(i - 1, CP) = request.form("CP_" & i)
			unitDetails(i - 1, YS) = request.form("YS_" & i)
			unitDetails(i - 1, UM) = request.form("UM_" & i)

		'else generate errors for partially completed rows
		else
			if not isPopulated("UnitCode_" & i) and _
					(isPopulated("CP_" & i) or _
					isPopulated("YS_" & i) or _
					isPopulated("UM_" & i)) then
				call missingUnitDetailsError("Unit Code")
			end if

			if not isPopulated("CP_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("YS_" & i) or _
					isPopulated("UM_" & i)) then
				call missingUnitDetailsError("Credit Points")
			end if

			if not isPopulated("YS_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("CP_" & i) or _
					isPopulated("UM_" & i)) then
				call missingUnitDetailsError("Year / Semester")
			end if

			if not isPopulated("UM_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("CP_" & i) or _
					isPopulated("YS_" & i)) then
				call missingUnitDetailsError("Unit Mark")
			end if
		end if

	next

	'delete after testing
	for i = 0 to unitRows
		for j = 0 to UNIT_COLS
			response.write(unitDetails(i, j) & " ")
		next
		response.write("<br />")
	next

end sub

'*
'* Sub populates errorMessage array with missing value
'* @param i int - the index count.
'* @param missingValue String - the missing value
'*
sub missingUnitDetailsError(missingValue)
	errorCount = errorCount + 1
	errorMessage(errorCount) = "<strong>" & missingValue & "</strong> is missing from a partially filled row."
end sub

sub validateUnitDetails()

end sub

'function checks if field is populated
'@return isPopulated boolean
private function isPopulated(field)
	dim b
	if request.form(field) <> "" then
		b = true
	else
		b = false
	end if
	isPopulated = b
end function

'sub-routine displays js popup error message
'@param message String - The message you want to display
private sub exceptionMessage(message)
	response.write("<script language=""javascript"">alert('" + message + " Please try again.');</script>")
end sub

%>

<p>&nbsp;</p>
</body>
</html>