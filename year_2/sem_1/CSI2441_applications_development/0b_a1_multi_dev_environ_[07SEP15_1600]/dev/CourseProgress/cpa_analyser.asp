<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>CPA 2015</title>
</head>

<body>

<%

'****************************
'*** SETTING UP VARIABLES ***
'****************************

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

'define regex dictionary
dim regExDict
set regExDict = server.createObject("scripting.dictionary")
regExDict.add "name", "(^[a-zA-Z]+$)"
regExDict.add "studentID", "(^[0-9]+$)"
regExDict.add "unitCode", "([A-Z]{3}[0-9]{4})"
regExDict.add "unitCodeSuffix", "([0-9]{4})"
regExDict.add "creditPoints", "(15|20)"
regExDict.add "yearSem", "([0-9]{2}[1|2])"
regExDict.add "mark", "(^[0-9]+$)"

'variables for calculating summary
dim passedCPTotal, cpDelta, unitAttemptTotal, unitsPassed, semRemaining
dim markTotal, markAverage, grade
dim progressionStatus, completeStatus

markTotal = 0

'****************************
'*** START MAINLINE LOGIC ***
'****************************

call setupUnitDetailsArray()
call getStudentDetails()
call getUnitDetails()

call validateStudentDetails()
call validateUnitDetails()

if errorCount > 0 then
	call displayErrors()
else
	call calculateSummary()
	call displaySummary()
end if


'**************************
'*** SUBS AND FUNCTIONS ***
'**************************

'*********************
'*** RETRIEVE DATA ***
'*********************

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
	redim errorMessage(STUDENT_DETAILS_COUNT + unitRows)
end sub

'**
'* Sub gets all student details from form, enters them into student details array.
'* Generates errors if any values are missing.
'*
sub getStudentDetails()
	if isPopulated("Firstname") then
		studentDetails(FN) = request.form("Firstname")
	else
		call missingInputError("student", "Firstname", -1)
	end if

	if isPopulated("Surname") then
		studentDetails(SN) = request.form("Surname")
	else
		call missingInputError("student", "Surname", -1)
	end if

	'not testing this for population since it has default value
	studentDetails(ET) = cInt(request.form("EnrolmentType"))

	if isPopulated("StudentID") then
		studentDetails(ID) = request.form("StudentID")
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
				call missingInputError("unit", "Unit Code", i)
			end if

			if not isPopulated("CP_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("YS_" & i) or _
					isPopulated("UM_" & i)) then
				call missingInputError("unit", "Credit Points", i)
			end if

			if not isPopulated("YS_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("CP_" & i) or _
					isPopulated("UM_" & i)) then
				call missingInputError("unit", "Year / Semester", i)
			end if

			if not isPopulated("UM_" & i) and _
					(isPopulated("UnitCode_" & i) or _
					isPopulated("CP_" & i) or _
					isPopulated("YS_" & i)) then
				call missingInputError("unit", "Unit Mark", i)
			end if
		end if

	next

end sub

'*********************
'*** VALIDATE DATA ***
'*********************

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

'**********************
'*** BUSINESS LOGIC ***
'**********************

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
				call getMarkTotal(i) '<-- getting weird off-by-one error calling this here, investigate why
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

'**********************
'*** VIEW FUNCTIONS ***
'**********************

'**
'* Print summary if no errors in data.
'*
sub displaySummary()

	response.write("<h1>Course Progression Summary</h1>")
	response.write("<hr />")

	response.write("<p>")

	'***********************
	'*** STUDENT DETAILS ***
	'***********************

	response.write("<h2>Student details</h2>")

	response.write("<p>")

	response.write("<strong>Name:</strong> " & studentDetails(FN) & " " & studentDetails(SN) & "<br />")
	response.write("<strong>Student ID: </strong>" & studentDetails(ID) & "<br />")

	response.write("<strong>Enrolment type:</strong> ")
	if studentDetails(ET) = 1 then
		response.write("Full time")
	else 
		response.write("Part time")
	end if
	response.write("<br />")

	response.write("<strong>Course type:</strong> ")
	select case studentDetails(CT)
		case 1
			response.write("Undergraduate degree (" & CP_UNDERGRAD & " CP) <br />")
		case 2
			response.write("Undergraduate degree (" & CP_UNDERGRAD_DOUBLE & " CP) <br />")
		case 3
			response.write("Graduate diploma (" & CP_GRAD_DIPLOMA & " CP) <br />")
		case 4
			response.write("Masters by coursework (" & CP_MASTERS_COURSE & " CP) <br />")
		case 5
			response.write("Masters by research (" & CP_MASTERS_RESEARCH & " CP) <br />")
	end select

	response.write("</p>")

	'********************
	'*** UNIT DETAILS ***
	'********************

	response.write("<h2>Progression summary</h2>")

	response.write("<p>")
	response.write("<strong>Progression Status:</strong> " & progressionStatus & "<br />")
	response.write("<strong>Course requirements complete:</strong> " & completeStatus & "<br />")
	response.write("</p>")

	response.write("<h2>Credit point summary</h2>")

	response.write("<strong>Total achieved credit points:</strong> " & passedCPTotal & "<br />")
	response.write("<strong>Additional credit points required for completion: </strong>" & cpDelta & "<br />")
	response.write("<strong>Units attempted: </strong>" & unitAttemptTotal & "<br />")
	response.write("<strong>Units passed: </strong>" & unitsPassed & "<br />")
	response.write("<strong>Semesters remaining: </strong>" & semRemaining & "<br />")
	response.write("<strong>Average mark: </strong>" & markAverage & " " & grade & "<br />")

	response.write("</p>")

	'***************
	'*** TESTING ***
	'***************

	'delete after testing
	'for i = 0 to unitRows - 1
	''	for j = 0 to UNIT_COLS - 1 
	''		response.write(unitDetails(i, j) & " ")
	''	next
	''	response.write("<br />")
	'next
end sub

'**
'* Sub displays error messages, by iterating through every item in errorMessage array.
'*
sub displayErrors()

	response.write("<h1>Course Progression Form Errors</h1>")
	response.write("<hr />")
	response.write("<p>")

	'write out errors
	for each item in errorMessage
		if item <> "" then
			response.write(item & "<br />")
		end if
	next

	response.write("</p>")

	response.write("<p>Please return to the form, resolve the errors and try again.</p>")
end sub

'************************
'*** HELPER FUNCTIONS ***
'************************

'**
'* Function checks if field is populated.
'* Returns boolean.
'*
'* @return boolean.
function isPopulated(field)
	dim b
	if request.form(field) <> "" then
		b = true
	else
		b = false
	end if
	isPopulated = b
end function

'**
'* Sub populates errorMessage array with missing value,
'* when input is missing from the form.
'*
'* @param data String - Either "student" or "unit"
'* @param missingValue String - the missing value.
'* @param row int - The partially filled row, use -1 if not required.
'*
sub missingInputError(data, missingValue, row)

	errorCount = errorCount + 1

	if data = "student" then
		errorMessage(errorCount) = "<strong>" & missingValue & "</strong> must be provided."
	elseif data = "unit" then
		errorMessage(errorCount) = "<strong>" & missingValue & "</strong> is missing from partially filled <strong>row " & row & "</strong>."
	end if
end sub

'**
'* Sub populates errorMessage array with validation error message.
'*
'* @param field String - The field that failed validation.
'* @param message String - The error message.
'*
sub validateError(field, message)
	errorCount = errorCount + 1
	errorMessage(errorCount) = "<strong>" & field & " </strong> " & message & "."
end sub

'**
'* Function performs regex match between target and pattern. Returns boolean.
'* Adapted from: http://www.mikesdotnetting.com/article/24/regular-expressions-and-vbscript
'* 
'* @param strTarget - The target to match.
'* @param strPattern - The regex pattern.
'* @return boolean.
function isRegExMatch(strTarget, strPattern)
	set regEx = new RegExp
	regEx.pattern = strPattern
	regEx.global = true
	regEx.ignoreCase = false
	isRegExMatch = regEx.test(strTarget)
end function

'**
'* Function performs regex match between target and pattern. Returns matched string.
'* Adapted from: http://www.mikesdotnetting.com/article/24/regular-expressions-and-vbscript
'* 
'* @param strTarget - The target to match.
'* @param strPattern - The regex pattern.
'* @return String.
function getRegExMatch(strTarget, strPattern)

	dim matchString, returnString

	set regEx = new RegExp
	regEx.pattern = strPattern
	regEx.global = true
	regEx.ignoreCase = false
	set matchString = regEx.execute(strTarget)

	for each i in matchString
		returnString = returnString + i
	next

	getRegExMatch = returnString
end function


%>

<p>&nbsp;</p>
</body>
</html>