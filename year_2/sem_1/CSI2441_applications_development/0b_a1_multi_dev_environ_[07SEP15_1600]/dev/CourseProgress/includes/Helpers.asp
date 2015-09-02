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
'* @param row int - The partially filled row, use -1 if student details.
'*
sub missingInputError(data, missingValue, row)

	dim message
	message = "is missing."

	select case data
		case "student"
			studentErrorCount = studentErrorCount + 1
			'redim preserve studentErrorMessage(studentErrorCount, ERROR_COLS)
			studentErrorMessage(studentErrorCount - 1, E_ROW) = row
			studentErrorMessage(studentErrorCount - 1, E_FIELD) = missingValue
			studentErrorMessage(studentErrorCount - 1, E_ECODE) = ECODE_MISSING
			studentErrorMessage(studentErrorCount - 1, E_MESSAGE) = message
		case "unit"
			unitErrorCount = unitErrorCount + 1
			'redim preserve unitErrorMessage(unitErrorCount, ERROR_COLS)
			unitErrorMessage(unitErrorCount - 1, E_ROW) = row
			unitErrorMessage(unitErrorCount - 1, E_FIELD) = missingValue
			unitErrorMessage(unitErrorCount - 1, E_ECODE) = ECODE_MISSING	
			unitErrorMessage(unitErrorCount - 1, E_MESSAGE) = message	
	end select

end sub

'**
'* Sub populates errorMessage array with validation error message.
'*
'* @param data String - Either "student" or "unit"
'* @param field String - The field that failed validation.
'* @param row int - The row which failed validation, use -1 if student details.
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

'**
'* Function performs bubble sort on a one-dimensional array.
'* Adapted from: http://www.4guysfromrolla.com/demos/bubblesort.asp
'*
'* @param theArray - The array to sort.
'*
sub bubbleSort(theArray)

    dim originalValue, newValue, swapIndex

    for i = 0 To uBound(theArray) - 1

        originalValue = theArray(i)
        newValue = theArray(i)
        swapIndex = i
	    	
        for j = i + 1 to uBound(theArray)
            if theArray(j) < newValue then
                swapIndex = j
                newValue = theArray(j)
            end if
        next
	    
        if swapIndex <> i then
            theArray(swapIndex) = originalValue
            theArray(i) = newValue
        end if
    next
end sub

'**
'* Function performs bubble sort on a two-dimensional array.
'* Adapted from: http://www.4guysfromrolla.com/webtech/011601-1.shtml
'*
'* @param theArray - The array to sort.
'* @param dimToSort - The dimension to sort the 2d array by. Either 0 or 1.
'*
sub bubbleSort2D(theArray, dimToSort)

    dim originalValue, originalOtherValue
    dim newKey, newOtherKey
    dim swapIndex, otherDim

    const column = 1
    
    'validate dimToSort param
    if dimToSort = 1 then
		otherDim = 0
	elseif dimToSort = 0 then
		otherDim = 1
	else
	    response.write "Invalid dimension for dimToSort: " & "must be value of 1 or 0."
	    'kill exec
	    response.end
	end if
    
    'outer loop
    for i = 0 To uBound(theArray, column) - 1

        originalValue = theArray(i, dimToSort)
        originalOtherValue = theArray(i, otherDim)
        
        newKey = theArray(i, dimToSort)
        newOtherKey = theArray(i, otherDim)
        
        swapIndex = i
		
		'inner loop
        for j = i + 1 to uBound(theArray, column)

        	'lets ignore empty rows here, sort populated rows only
            if theArray(j, dimToSort) < newKey and theArray(j, dimToSort) <> "" then

            	'store lowest value's index
                swapIndex = j
                newKey = theArray(j, dimToSort)
                newOtherKey = theArray(j, otherDim)
            end if
        next
		
        if swapIndex <> i then

        	'swap within array
            theArray(swapIndex, dimToSort) = originalValue
            theArray(swapIndex, otherDim) = originalOtherValue
            
            theArray(i, dimToSort) = newKey
            theArray(i, otherDim) = newOtherKey
            
        end if	
    next
end sub
%>