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

'array for student/unit details
dim studentDetails()
'set up with known length
redim studentDetails(STUDENT_DETAILS_COUNT)
dim unitDetails()

'error/failed units arrays
dim studentErrorMessage(), studentErrorCount
dim unitErrorMessage(), unitErrorCount
dim logicErrorMessage(), logicErrorCount

'column index for student/unitErrorMessage
const E_ROW = 0
const E_FIELD = 1
const E_ECODE = 2

'student/unitErrorMessage
'| 0   | 1     | 2     |
'| row | field | ecode |

'column index for logicErrorMessage
const LE_FIELD = 0
const LE_ECODE = 1
const LE_SEM = 2
const LE_ROW_1 = 3
const LE_ROW_2 = 4

'logicErrorMessage
'| 0     | 1     | 2   | 3    | 4
'| field | ecode | sem | row1 | row2

'error codes/messages
dim errorCode(11)
'names
errorCode(0) = "is missing."
errorCode(1) = "must be a name."
'studentid
errorCode(2) = "must be eight digits."
'unitcode
errorCode(3) = "is invalid for undergraduate students. Must be a unit code less than 6000 level."
errorCode(4) = "must follow the format: ABC1234."
'creditpoints
errorCode(5) = "must only be either 15 or 20."
'year/sem
errorCode(6) = "must follow the format ""YYS"". For example, 151. Semester must only be 1 or 2."
'unitmark
errorCode(7) = "can't be less than 0 or greater than 100."
errorCode(8) = "must be between 1 and 3 digits."
'passMatchUnits
errorCode(9) = "is passed more than once at rows " 'then state the rows
'semMatchUnits
errorCode(10) = "appears more than once in semester " 'then state sem and rows

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
dim markTotal, markAverage, gradeAverage, semTotal
dim progressionStatus, completeStatus

'some title strings for error view
dim studentErrorTitle, unitErrorTitle, logicErrorTitle
studentErrorTitle = "<h2>Student details errors</h2>"
unitErrorTitle = "<h2>Unit details errors</h2>"
logicErrorTitle = "<h2>Logical errors</h2>"

'****************************
'*** START MAINLINE LOGIC ***
'****************************

call setupArrays()
call getStudentDetails()
call getUnitDetails()

call validateStudentDetails()
call validateUnitDetails()
call validateLogic()

if studentErrorCount = 0 and unitErrorCount = 0 and logicErrorCount = 0 then
	call calculateSummary()
	call displaySummary()
else
	call displayErrors()
end if

%>

<!-- BEGIN INCLUDES -->

<!-- #include file = "includes/GetData.asp" -->
<!-- #include file = "includes/ValidateData.asp" -->
<!-- #include file = "includes/BusinessLogic.asp" -->
<!-- #include file = "includes/View.asp" -->
<!-- #include file = "includes/Helpers.asp" -->

<p>&nbsp;</p>
</body>
</html>