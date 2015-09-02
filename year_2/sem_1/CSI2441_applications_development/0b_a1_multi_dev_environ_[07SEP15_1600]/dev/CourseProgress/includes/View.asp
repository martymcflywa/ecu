<%

'This include contains subs and functions
'which either displays the summary or error view.
'
'@author Martin Ponce, 10371381
'@version 20150831

dim studentErrorTitle
studentErrorTitle = "<h2>Student details errors</h2>"
dim unitErrorTitle
unitErrorTitle = "<h2>Unit details errors</h2>"
dim logicErrorTitle
logicErrorTitle = "<h2>Logical errors</h2>"

'**
'* Sub initiates the summary view.
'*
sub displaySummary()

	response.write("<h1>Course Progression Summary</h1>")
	response.write("<hr />")

	response.write("<p>")

	'***********************
	'*** STUDENT DETAILS ***
	'***********************

	response.write("<h2>Student details</h2>")

	response.write("<p>")

	response.write("<strong>Name:</strong> " & studentDetails(FN) & " " & studentDetails(SN) & "<br />")
	response.write("<strong>Student ID: </strong>" & studentDetails(ID) & "<br />")

	response.write("<strong>Enrolment type:</strong> ")

	select case studentDetails(ET)
		case 1
			response.write("Full time")
		case 2
			response.write("Part time")
	end select

	response.write("<br />")

	response.write("<strong>Course type:</strong> ")

	select case studentDetails(CT)
		case 1
			response.write("Undergraduate degree (" & CP_UNDERGRAD & " CP) <br />")
		case 2
			response.write("Undergraduate degree (" & CP_UNDERGRAD_DOUBLE & " CP) <br />")
		case 3
			response.write("Graduate diploma (" & CP_GRAD_DIPLOMA & " CP) <br />")
		case 4
			response.write("Masters by coursework (" & CP_MASTERS_COURSE & " CP) <br />")
		case 5
			response.write("Masters by research (" & CP_MASTERS_RESEARCH & " CP) <br />")
	end select

	response.write("</p>")

	'********************
	'*** UNIT DETAILS ***
	'********************

	response.write("<h2>Progression summary</h2>")

	response.write("<p>")
	response.write("<strong>Progression Status:</strong> " & progressionStatus & "<br />")
	response.write("<strong>Course requirements complete:</strong> " & completeStatus & "<br />")
	response.write("</p>")

	response.write("<h2>Credit point summary</h2>")

	response.write("<strong>Total achieved credit points:</strong> " & passedCPTotal & "<br />")
	response.write("<strong>Additional credit points required for completion: </strong>" & cpDelta & "<br />")
	response.write("<strong>Units attempted: </strong>" & unitAttemptTotal & "<br />")
	response.write("<strong>Units passed: </strong>" & unitsPassed & "<br />")
	response.write("<strong>Semesters remaining: </strong>" & semRemaining & "<br />")
	response.write("<strong>Average mark: </strong>" & markAverage & " " & grade & "<br />")

	response.write("</p>")

	'test
	'response.write(logicErrorCount)
	'for i = 0 to uBound(failedUnits)
	''	for j = 0 to lBound(failedUnits)
	''		response.write(failedUnits(i, j) & " | <br/>")
	''	next 
	'next
end sub

'**
'* Sub initiates the error view.
'*
sub displayErrors()

	response.write("<h1>Course Progression Form Errors</h1>")
	response.write("<hr />")
	response.write("<p>")

	'if form is empty
	if isStudentPopulated = false and isUnitPopulated = false then
		response.write("Form is empty. Please provide student and unit details.<br />")
	elseif isStudentPopulated = true and isUnitPopulated = false then
		'do this if there are student details errors
		if studentErrorCount > 0 then
			call displayStudentErrors()
		end if
		response.write(unitErrorTitle)
		response.write("<strong>Unit details</strong> empty.")

	elseif isStudentPopulated = false and isUnitPopulated = true then
		response.write(studentErrorTitle)
		response.write("<strong>Student details</strong> empty.")
		'do this if there are unit details errors
		if unitErrorCount > 0 then
			call displayUnitErrors()
		end if

	else

		'do this if there are student details errors
		if studentErrorCount > 0 then
			call displayStudentErrors()
		end if

		'do this if there are unit details errors
		if unitErrorCount > 0 then
			call displayUnitErrors()
		end if

		'do this if there are logic errors
		if logicErrorCount > 0 then
			call displayLogicErrors()
		end if

	end if

	'error view footer
	response.write("</p>")
	response.write("<p>Please return to the form, resolve the errors and try again.</p>")
	'back button adapted from: http://www.computerhope.com/issues/ch000317.htm
	response.write("<input type=""button"" name=""Back"" value=""Back"" onClick=""history.go(-1);return true;"">")

end sub

'**
'* Sub displays student errors.
'*
sub displayStudentErrors()

	response.write(studentErrorTitle)

	response.write("<ul>")
	for i = 0 to studentErrorCount - 1
		response.write("<li><strong>" & studentErrorMessage(i, E_FIELD) & "</strong> " & studentErrorMessage(i, E_MESSAGE) & "</li>")
	next
	response.write("</ul>")
end sub

'**
'* Sub displays unit errors.
'*
sub displayUnitErrors()

	dim currentRow
	currentRow = 0

	response.write(unitErrorTitle)

	'loop over unitErrorMessage
	for i = 0 to unitErrorCount - 1

		if currentRow = unitErrorMessage(i, E_ROW) then
			response.write("<li><strong>" & unitErrorMessage(i, E_FIELD) & "</strong> " & unitErrorMessage(i, E_MESSAGE) & "</li>")
		else
			currentRow = unitErrorMessage(i, E_ROW)
			response.write("</ul>")
			response.write("Error/s on <strong>Row " & unitErrorMessage(i, E_ROW) & ":</strong>")
			response.write("<ul>")
			response.write("<li><strong>" & unitErrorMessage(i, E_FIELD) & "</strong> " & unitErrorMessage(i, E_MESSAGE) & "</li>")
		end if
	next

	response.write("</ul>")
end sub

'**
'* Sub displays logic errors.
'*
sub displayLogicErrors()

	response.write(logicErrorTitle)

	response.write("<ul>")

	for i = 0 to logicErrorCount - 1
		response.write("<li><strong>" & logicErrorMessage(i, 0) & "</strong> " & logicErrorMessage(i, 1))
	next

	response.write("</ul>")

	'test
	for i = 0 to logicErrorCount - 1
		response.write(logicErrorMessage(i, 0) & " " & logicErrorMessage(i, 1) & "<br/>")
	next
end sub
%>