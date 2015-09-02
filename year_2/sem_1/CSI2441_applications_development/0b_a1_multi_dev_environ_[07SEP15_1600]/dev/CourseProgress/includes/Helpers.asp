<%

'This include contains helper subs and functions.
'
'@author Martin Ponce, 10371381
'@version 20150831

'column index definitions for student/unitErrorMessage(x,y)
const ERROR_COLS = 4

const E_ROW = 0
const E_FIELD = 1
const E_ECODE = 2
const E_MESSAGE = 3

const ECODE_MISSING = 0
const ECODE_VALIDATE = 1

'**
'* Function checks if field is populated.
'* Returns boolean.
'*
'* @return boolean.
'*
function isFieldPopulated(field)
	dim b
	if request.form(field) <> "" then
		b = true
	else
		b = false
	end if
	isFieldPopulated = b
end function

'**
'* Sub populates errorMessage array with missing value,
'* when input is missing from the form.
'*
'* @param data String - Either "student" or "unit"
'* @param field String - the missing value.
'* @param row int - The partially filled row, use -1 if student details.
'*
sub missingInputError(data, field, row)

	dim message
	message = "is missing."

	select case data
		case "student"
			studentErrorCount = studentErrorCount + 1
			'redim preserve studentErrorMessage(studentErrorCount, ERROR_COLS)
			studentErrorMessage(studentErrorCount - 1, E_ROW) = row
			studentErrorMessage(studentErrorCount - 1, E_FIELD) = field
			studentErrorMessage(studentErrorCount - 1, E_ECODE) = ECODE_MISSING
			studentErrorMessage(studentErrorCount - 1, E_MESSAGE) = message
		case "unit"
			unitErrorCount = unitErrorCount + 1
			'redim preserve unitErrorMessage(unitErrorCount, ERROR_COLS)
			unitErrorMessage(unitErrorCount - 1, E_ROW) = row
			unitErrorMessage(unitErrorCount - 1, E_FIELD) = field
			unitErrorMessage(unitErrorCount - 1, E_ECODE) = ECODE_MISSING	
			unitErrorMessage(unitErrorCount - 1, E_MESSAGE) = message	
	end select

end sub

'**
'* Sub populates student/unit error message array with validation error message.
'*
'* @param data String - Either "student" or "unit"
'* @param field String - The field that failed validation.
'* @param row int - The row which failed validation, use -1 if student details.
'* @param message String - The error message.
'*
sub validateError(data, field, row, message)
	select case data
		case "student"
			studentErrorCount = studentErrorCount + 1
			'redim preserve studentErrorMessage(studentErrorCount, ERROR_COLS)
			studentErrorMessage(studentErrorCount - 1, E_ROW) = row
			studentErrorMessage(studentErrorCount - 1, E_FIELD) = field
			studentErrorMessage(studentErrorCount - 1, E_ECODE) = ECODE_VALIDATE
			studentErrorMessage(studentErrorCount - 1, E_MESSAGE) = message
		case "unit"
			unitErrorCount = unitErrorCount + 1
			'redim preserve unitErrorMessage(unitErrorCount, ERROR_COLS)
			unitErrorMessage(unitErrorCount - 1, E_ROW) = row
			unitErrorMessage(unitErrorCount - 1, E_FIELD) = field
			unitErrorMessage(unitErrorCount - 1, E_ECODE) = ECODE_VALIDATE
			unitErrorMessage(unitErrorCount - 1, E_MESSAGE) = message
	end select
end sub

'**
'* Sub populates logicError array with logic error message.
'*
'* @param field String - The field that failed validation.
'* @param message String - The error message.
'* @param rows String - The rows affected.
'*
sub logicError(field, message, rows)
	logicErrorCount = logicErrorCount + 1
	logicErrorMessage(logicErrorCount - 1, 0) = field
	logicErrorMessage(logicErrorCount - 1, 1) = message
	logicErrorMessage(logicErrorCount - 1, 2) = rows
end sub

'**
'* Function performs regex match between target and pattern. Returns boolean.
'* Adapted from: http://www.mikesdotnetting.com/article/24/regular-expressions-and-vbscript
'* 
'* @param strTarget String - The target to match.
'* @param strPattern String - The regex pattern.
'* @return boolean.
'*
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
'*
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