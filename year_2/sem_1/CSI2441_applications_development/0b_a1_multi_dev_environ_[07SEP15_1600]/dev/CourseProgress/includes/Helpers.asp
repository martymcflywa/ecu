<%

'This include contains helper subs and functions.
'
'@author Martin Ponce, 10371381
'@version 20150831


'**
'* Function checks if field is populated.
'* Returns boolean.
'*
'* @return boolean.
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