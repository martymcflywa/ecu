<%

'define variables
dim employeeID, employeeSurname, employeeFirstname
dim rateOfPay, salaried, grossPay, overtimePay
dim hoursWorked

'assign values to variables
employeeID = request.form("EmployeeID")
employeeSurname = request.form("EmployeeSurname")
employeeFirstname = request.form("EmployeeFirstname")
salaried = request.form("Salaried")
rateOfPay = request.form("RateOfPay")
hoursWorked = request.form("HoursWorked")
hoursWorked = hoursWorked + 0
rateOfPay = rateOfPay + 0

'constants defined internally as set values
const workload = 40
const overtimeRate = 1.5

'priming read
grossPay = 0

'check actual hoursWorked against workload
if hoursWorked > workload then
	overtimeModule()
else
	grossPay = hoursWorked * rateOfPay
end if

'calculates overtime, if required
sub overtimeModule()
	if salaried = 1 then
		overtimePay = 0
	else
		overtimePay = (hoursWorked - workload) * (overtimeRate * rateOfPay)
	end if
	grossPay = (hoursWorked * rateOfPay) + overtimePay
end sub

%>

<h2>Details</h2>
<hr />
<strong>Employee name: </strong><% =employeeSurname %>, <% =employeeFirstname %><br />
<strong>Gross pay: </strong><% =grossPay %><br />