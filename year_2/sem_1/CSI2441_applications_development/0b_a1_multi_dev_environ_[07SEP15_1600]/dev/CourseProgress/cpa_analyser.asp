<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>CPA 2015</title>
</head>

<body>

<%

'@author Martin Ponce, 10371381
'@version 20150831

'****************************
'*** SETTING UP VARIABLES ***
'****************************

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

'variables to generate error messages
dim errorMessage(), errorCount

'replacing errorMessage() and errorCount with unit/student specific arrays
dim studentErrorMessage(), studentErrorCount
dim unitErrorMessage(), unitErrorCount
'init arrays with single row each
redim studentErrorMessage(STUDENT_DETAILS_COUNT, 4)
redim unitErrorMessage(30, 4)

'define regex dictionary
dim regExDict
set regExDict = server.createObject("scripting.dictionary")
regExDict.add "name", "(^[a-zA-Z]+$)"
regExDict.add "studentID", "(^[0-9]{8}$)"
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

%>

<%

'****************************
'*** START MAINLINE LOGIC ***
'****************************

call setupUnitDetailsArray()
call getStudentDetails()
call getUnitDetails()

call validateStudentDetails()
call validateUnitDetails()

if studentErrorCount = 0 and unitErrorCount = 0 then
	call calculateSummary()
	call displaySummary()
else
	call displayErrors()
end if

%>

<!-- BEGIN INCLUDES -->

<!-- #include file ="includes/GetData.asp" -->
<!-- #include file ="includes/ValidateData.asp" -->
<!-- #include file ="includes/BusinessLogic.asp" -->
<!-- #include file ="includes/View.asp" -->
<!-- #include file ="includes/Helpers.asp" -->

<p>&nbsp;</p>
</body>
</html>