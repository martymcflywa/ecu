<%

'This include contains subs and functions
'which either displays the summary or error view.
'
'@author Martin Ponce, 10371381
'@version 20150831

'**
'* Print summary if no errors in data.
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

	if studentDetails(ET) = 1 then
		response.write("Full time")
	else 
		response.write("Part time")
	end if
	
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

	'***************
	'*** TESTING ***
	'***************

	'delete after testing
	'for i = 0 to unitRows - 1
	''	for j = 0 to UNIT_COLS - 1 
	''		response.write(unitDetails(i, j) & " ")
	''	next
	''	response.write("<br />")
	'next
end sub

'**
'* Sub displays error messages, by iterating through every item in errorMessage array.
'*
sub displayErrors()

	response.write("<h1>Course Progression Form Errors</h1>")
	response.write("<hr />")
	response.write("<p>")

	'write out errors
	for each item in errorMessage
		if item <> "" then
			response.write(item & "<br />")
		end if
	next

	response.write("</p>")

	response.write("<p>Please return to the form, resolve the errors and try again.</p>")
end sub

%>