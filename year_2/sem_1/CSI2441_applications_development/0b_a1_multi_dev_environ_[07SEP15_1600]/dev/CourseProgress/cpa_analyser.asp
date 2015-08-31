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