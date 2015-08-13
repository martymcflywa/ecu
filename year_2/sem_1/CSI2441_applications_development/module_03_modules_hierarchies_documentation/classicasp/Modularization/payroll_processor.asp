<%

'************************'
'**** MAINLINE LOGIC ****'
'************************'

'define variables
dim employeeID, employeeSurname, employeeFirstname
dim rateOfPay, salaried, grossPay, overtimePay
dim hoursWorked, overtimeHours

'assign form values to variables
employeeID = request.form("EmployeeID")
employeeSurname = request.form("EmployeeSurname")
employeeFirstname = request.form("EmployeeFirstname")
salaried = request.form("Salaried")
rateOfPay = request.form("RateOfPay")
hoursWorked = request.form("HoursWorked")

'constants defined internally as set values
const WORK_LOAD = 40
const OVERTIME_RATE = 1.5

'priming read
grossPay = 0

'finding out what typeName returns here
'response.write(typeName(rateOfPay) & " " & typeName(employeeFirstname))

'validate user input
call validate(employeeID, "EmployeeID", "number")
call validate(employeeFirstname, "Firstname", "string")
call validate(employeeSurname, "Surname", "string")
call validate(rateOfPay, "Rate of pay", "number")
call validate(hoursWorked, "Hours worked", "number")

'check actual hoursWorked against WORK_LOAD
if hoursWorked > WORK_LOAD then
	overtimeHours = hoursWorked - WORK_LOAD
	call overtimeModule()
else
	grossPay = hoursWorked * rateOfPay
end if

call printSummary()

'****************************'
'**** SUBS AND FUNCTIONS ****'
'****************************'

'sub validates form fields and prints error if incomplete or wrong data type
'@param varName - Variable that stores the form field
'@param formField String - The form field name, used for the error message
'@param dataType String - either "number" or "string"
sub validate(varName, formField, dataType)
	'check if field is populated
	if isPopulated(varName) then
		'do this when dataType is number
		if dataType = "number" then
			if isNumeric(varName) <> true then
				call printError(formField, "numeric")
				response.end
			elseif varName <= 0 then
				call printError(formField, "greater than zero")
				response.end
			end if
		'do this when dataType is string
		elseif dataType = "string" then
			if isNumeric(varName) then
				call printError(formField, "string")
				response.end
			end if
		end if
	'print error message if field is not populated
	else
		call printError(formField, "provided")
		response.end
	end if
end sub

'function checks if field is populated
'@param varName - The variable to check
'@return isPopulated boolean
function isPopulated(varName)
	dim b
	if len(varName) > 0 then
		b = true
	else
		b = false
	end if
	isPopulated = b
end function

'sub calculates overtime, if required
sub overtimeModule()
	if salaried = 1 then
		overtimePay = 0
	else
		overtimePay = (hoursWorked - WORK_LOAD) * (OVERTIME_RATE * rateOfPay)
	end if
	grossPay = (hoursWorked * rateOfPay) + overtimePay
end sub

'sub print summary, call only after data validation
sub printSummary()
	response.write("<h2>Details</h2>")
	response.write("<hr />")
	response.write("<strong>Employee ID: </strong>" & employeeID & "<br />")

	'call properNoun() to correctly case names
	response.write("<strong>Employee Name: </strong>" & properNoun(employeeFirstname) & " " & properNoun(employeeSurname) & "<br />")
	response.write("<strong>Gross pay: </strong> $" & grossPay & "<br />")

	'check for overtime
	if overtimeHours > 0 then
		response.write("<strong>Overtime hours: </strong>" & overtimeHours & "<br />")
	end if

	response.write("<strong>Salaried: </strong>")

	'check for salaried
	if salaried = 0 then
		response.write("No")
	else
		response.write("Yes")
	end if
end sub

'sub print error message
'@param field String - The form field that has error
'@param errorMessage String - The error message to be displayed
sub printError(field, errorMessage)
	response.write("<h2>Error</h2>")
	response.write("<hr />")
	response.write("<strong>" & field & "</strong> must be <strong>")
	response.write(errorMessage & "</strong>. Please try again.")
end sub

'function forces proper noun casing for names
'@param theString String - The string to manipulate
'@return properNoun String - The manipulated string
function properNoun(theString)
	theString = uCase(left(theString, 1)) & lCase(right(theString, len(theString) - 1))
	properNoun = theString
end function

%>