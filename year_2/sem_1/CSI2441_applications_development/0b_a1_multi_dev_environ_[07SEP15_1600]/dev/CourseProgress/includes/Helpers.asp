<%

'This include contains helper subs and functions.
'
'@author Martin Ponce, 10371381
'@version 20150831

'column index for student/unitErrorMessage
const E_ROW = 0
const E_FIELD = 1
const E_ECODE = 2

'column index for logicErrorMessage
const LE_FIELD = 0
const LE_ECODE = 1
const LE_SEM = 2
const LE_ROW_1 = 3
const LE_ROW_2 = 4

'studentErrorMessage
'| 0   | 1     | 2     |
'| row | field | ecode |

'unitErrorMessage
'| 0   | 1     | 2     |
'| row | field | ecode |

'logicErrorMessage
'| 0     | 1     | 2   | 3    | 4
'| field | ecode | sem | row1 | row2

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
'* Sub populates error array with missing value,
'* when input is missing from the form.
'*
'* @param data String - Either "student" or "unit"
'* @param row int - The partially filled row, use -1 if student details.
'* @param field String - the missing value.
'*
sub missingInputError(data, row, field)

	select case data
		case "student"
			studentErrorCount = studentErrorCount + 1
			'redim preserve studentErrorMessage(studentErrorCount, ERROR_COLS)
			studentErrorMessage(studentErrorCount - 1, E_ROW) = row
			studentErrorMessage(studentErrorCount - 1, E_FIELD) = field
			studentErrorMessage(studentErrorCount - 1, E_ECODE) = 0
		case "unit"
			unitErrorCount = unitErrorCount + 1
			'redim preserve unitErrorMessage(unitErrorCount, ERROR_COLS)
			unitErrorMessage(unitErrorCount - 1, E_ROW) = row
			unitErrorMessage(unitErrorCount - 1, E_FIELD) = field
			unitErrorMessage(unitErrorCount - 1, E_ECODE) = 0
	end select

end sub

'**
'* Sub populates student/unit error message array with validation error message.
'*
'* @param data String - Either "student" or "unit"
'* @param row int - The row which failed validation, use -1 if student details.
'* @param field String - The field that failed validation.
'* @param code int - The error code. See errorCode() array.
'*
'unitErrorMessage
'| 0   | 1     | 2     |
'| row | field | ecode |
sub validateError(data, row, field, code)
	select case data
		case "student"
			studentErrorCount = studentErrorCount + 1
			studentErrorMessage(studentErrorCount - 1, E_ROW) = row
			studentErrorMessage(studentErrorCount - 1, E_FIELD) = field
			studentErrorMessage(studentErrorCount - 1, E_ECODE) = code
		case "unit"
			unitErrorCount = unitErrorCount + 1
			unitErrorMessage(unitErrorCount - 1, E_ROW) = row
			unitErrorMessage(unitErrorCount - 1, E_FIELD) = field
			unitErrorMessage(unitErrorCount - 1, E_ECODE) = code
	end select
end sub

'**
'* Sub populates logicError array with logic error message.
'*
'* @param field String - The field that failed validation.
'* @param code int - The error code. See errorCode() array.
'* @param sem String - The affected semester.
'* @param row1 int - The first row affected.
'* @param row2 int - The second row affected.
'*
sub logicError(field, code, sem, row1, row2)
	logicErrorCount = logicErrorCount + 1
	logicErrorMessage(logicErrorCount - 1, LE_FIELD) = field
	logicErrorMessage(logicErrorCount - 1, LE_ECODE) = code
	logicErrorMessage(logicErrorCount - 1, LE_SEM) = sem
	logicErrorMessage(logicErrorCount - 1, LE_ROW_1) = row1
	logicErrorMessage(logicErrorCount - 1, LE_ROW_2) = row2
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