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

'student details
dim studentFullName
dim studentID

'unit details
dim unitArray(3, 29)

dim Item
dim fieldName, fieldValue
dim unitDictionary
dim key, value

'trying to store items to dictionary here
Set unitDictionary = server.createObject("scripting.dictionary")

for each Item in request.form
	if Item <> "Firstname" or Item <> "Surname" or Item <> "StudentID" then
		fieldName = Item
		fieldValue = request.form(Item)
		unitDictionary.add fieldName, fieldValue
	end if
next

key = unitDictionary.keys
value = unitDictionary.items

for i = 0 to unitDictionary.count - 1
	response.write(key(i) & " = " & value(i))
	response.write("<br />")
next


'check Firstname and Surname provided
if isPopulated("Firstname") and isPopulated("Surname") then
	studentFullName = request.form("Firstname")
	studentFullName = studentFullName & " " & request.form("Surname")
else
	exceptionMessage("Form must include both Firstname and Surname.")
	response.end
end if

'check StudentID provided
if isPopulated("StudentID") then
	studentID = request.form("StudentID")
else
	exceptionMessage("Form must include StudentID.")
	response.end
end if

for i = 0 to 3
	for j = 0 to 29

	next
next

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