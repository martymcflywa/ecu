<%

'priming read and user input
dim value, userInput
	value = 0

'check user input is numeric before initialising variable
if isNumeric(request.form("userValue")) then
	userInput = request.form("userValue")
else
	response.write "Value must be numeric! <br />"
	response.end
end if

'check user input is in range before performing action
if userInput <> 1 and userInput <> 2 and userInput <> 5 then
	response.write "Input is outside of allowed range, please try again"
else
	do until value = 10
		response.write(value & "<br />")
		value = value + userInput
	loop
end if

%>
