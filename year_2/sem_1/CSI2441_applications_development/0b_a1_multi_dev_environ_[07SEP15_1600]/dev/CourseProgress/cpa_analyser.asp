<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>CPA 2015</title>
</head>

<body>

<h1>Course progression summary</h1>
<hr />

<%

'constants
const UNDERGRAD = 360
const UNDERGRAD_DOUBLE = 480
const GRAD_DIPLOMA = 120
const MASTER_COURSE = 180
const MASTER_RESEARCH = 240

'variables to work out input array dimensions
const UNIT_COLS = 4
const DETAILS_FIELD_COUNT = 6

dim item, totalFieldCount, unitFieldCount, unitRows
totalFieldCount = 0
unitFieldCount = 0
unitRows = 0

'the input array
dim unitInput()

'index for unit attributes
dim uc, cp, ys, um
uc = 0
cp = 1
ys = 2
um = 3

dim errorMessage, badItem

call setupInputArray()
call getUnitValues()

'*
'* Sub sets up the input array.  
'*
sub setupInputArray()
	'count all fields in form
	for each item in request.form
		totalFieldCount = totalFieldCount + 1
	next

	unitFieldCount = totalFieldCount - DETAILS_FIELD_COUNT
	unitRows = unitFieldCount / UNIT_COLS

	redim unitInput(unitRows, UNIT_COLS)
end sub

'*
'* Sub gets all unit values from form,
'* enters them into input array.
'*
sub getUnitValues()

	for i = 0 to unitRows

		'ignore entire row if one field is empty
		if isPopulated("UnitCode_" & i) and _
				isPopulated("CP_" & i) and _
				isPopulated("YS_" & i) and _
				isPopulated("UM_" & i) then
			unitInput(i - 1, uc) = request.form("UnitCode_" & i)
			unitInput(i - 1, cp) = request.form("CP_" & i)
			unitInput(i - 1, ys) = request.form("YS_" & i)
			unitInput(i - 1, um) = request.form("UM_" & i)
		end if
	next

	for i = 0 to unitRows
		for j = 0 to UNIT_COLS
			response.write(unitInput(i, j) & " ")
		next
		response.write("<br />")
	next

end sub


sub validate()

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