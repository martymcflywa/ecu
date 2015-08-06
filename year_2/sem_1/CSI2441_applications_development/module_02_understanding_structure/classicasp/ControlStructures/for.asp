<%

'priming read, user input
dim value, userInput
	value = 0
'max constant, made it 20 to so don't have to scroll every time
const MAX = 20

'check user input is numeric before initialising variable
if isNumeric(request.form("userValue")) then
	userInput = request.form("userValue")
else
	response.write "Value must be numeric! <br />"
	response.end
end if

'terminate if max reached
for i = 1 to userInput
	if i <= MAX then
		response.write(i & " of " & userInput & "<br />")
	else
		response.write("<br />Iteration exceeds maximum " & MAX & " iterations. <br />Program terminated...")
		response.end
	end if
next

response.write("<br /> Loop completed after " & userInput & " iterations.")

%>
