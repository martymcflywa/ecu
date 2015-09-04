<%

'This include contains subs and functions
'which either displays the summary or error view.
'
'@author Martin Ponce, 10371381
'@version 20150831

'**
'* Sub initiates the summary view.
'*
sub displaySummary()

	'summary header
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
		case CP_FULLTIME
			response.write("Full time")
		case CP_PARTTIME
			response.write("Part time")
	end select

	response.write("<br />")

	response.write("<strong>Course type:</strong> ")

	select case studentDetails(CT)
		case CP_UNDERGRAD
			response.write("Undergraduate degree (" & CP_UNDERGRAD & " CP) <br />")
		case CP_UNDERGRAD_DOUBLE
			response.write("Undergraduate degree (" & CP_UNDERGRAD_DOUBLE & " CP) <br />")
		case CP_GRAD_DIPLOMA
			response.write("Graduate diploma (" & CP_GRAD_DIPLOMA & " CP) <br />")
		case CP_MASTERS_COURSE
			response.write("Masters by coursework (" & CP_MASTERS_COURSE & " CP) <br />")
		case CP_MASTERS_RESEARCH
			response.write("Masters by research (" & CP_MASTERS_RESEARCH & " CP) <br />")
	end select

	response.write("</p>")

	'********************
	'*** UNIT DETAILS ***
	'********************

	response.write("<h2>Progression summary</h2>")

	response.write("<p>")
	response.write("<strong>Progression Status:</strong> ")

	'add red font if excluded
	select case progressionStatus
		case "Good standing"
			response.write(progressionStatus)
		case "Excluded"
			response.write("<font color=""red"">")
			response.write(progressionStatus)
			response.write("</font>")
		case "Good standing, pending supp"
			response.write("<font color=""red"">")
			response.write(progressionStatus)
			response.write("</font>")
	end select

	response.write("<br />")

	response.write("<strong>Course requirements complete:</strong> " & completeStatus & "<br />")
	response.write("</p>")

	response.write("<h2>Credit point summary</h2>")

	response.write("<strong>Total achieved credit points:</strong> " & passedCPTotal & "<br />")
	response.write("<strong>Additional credit points required for completion: </strong>" & cpDelta & "<br />")
	response.write("<strong>Units attempted: </strong>" & unitAttemptTotal & "<br />")
	response.write("<strong>Units passed: </strong>" & unitsPassed & "<br />")
	response.write("<strong>Semesters remaining: </strong>" & semRemaining & "<br />")
	response.write("<strong>Average mark: </strong>" & markAverage & " " & gradeAverage & "<br />")
	response.write("</p>")

	response.write("<p>")
	response.write("<h3>Highest mark:</h3>")
	response.write("<ul>")
	response.write("<li><strong>Unit Code: </strong>" & highestMark(UC) & "</li>")
	response.write("<li><strong>Credit Points: </strong>" & highestMark(CP) & "</li>")
	response.write("<li><strong>Year / Sem: </strong>" & highestMark(YS) & "</li>")
	response.write("<li><strong>Mark: </strong>" & highestMark(UM) & " " & highestMark(GR) & "</li>")
	response.write("</ul>")
	response.write("</p>")

	response.write("<h2>Transcript</h2>")

	'would be nicer in css, rather than inline
	response.write("<table border=""1"" cellpadding=""10"" style=""border-collapse:collapse;"">")
	response.write("<tr>")
	response.write("<th>UnitCode</th>")
	response.write("<th>CreditPoints</th>")
	response.write("<th>Year/Sem</th>")
	response.write("<th>Mark</th>")
	response.write("<th>Grade</th>")
	response.write("</tr>")

	for i = 0 to filledRows - 1
		response.write("<tr>")
		response.write("<td>")
		response.write(unitDetails(i, UC))
		response.write("</td>")
		response.write("<td align=""center"">")
		response.write(unitDetails(i, CP))
		response.write("</td>")
		response.write("<td align=""center"">")
		response.write(unitDetails(i, YS))
		response.write("</td>")
		response.write("<td align=""right"">")

		'lets show any mark less than pass show up as red
		if unitDetails(i, UM) < MARK_PASS then
			response.write("<font color=""red"">")
			response.write(unitDetails(i, UM))
			response.write("</font>")
			response.write("</td>")
			response.write("<td>")
			response.write("<font color=""red"">")
			response.write(unitDetails(i, GR))
			response.write("</font>")
			response.write("</td>")
			response.write("</tr>")
		else
			response.write(unitDetails(i, UM))
			response.write("</td>")
			response.write("<td>")
			response.write(unitDetails(i, GR))
			response.write("</td>")
			response.write("</tr>")
		end if


	next

	response.write("</table>")
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
		'do this if there are logic errors
		if logicErrorCount > 0 then
			call displayLogicErrors()
		end if

	elseif isStudentPopulated = false and isUnitPopulated = true then
		response.write(studentErrorTitle)
		response.write("<strong>Student details</strong> empty.")
		'do this if there are unit details errors
		if unitErrorCount > 0 then
			call displayUnitErrors()
		end if
		'do this if there are logic errors
		if logicErrorCount > 0 then
			call displayLogicErrors()
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
		response.write("<li><strong>")
		response.write(studentErrorMessage(i, E_FIELD))
		response.write("</strong> ")
		response.write(selectErrorMessage(studentErrorMessage(i, E_ECODE)))
		response.write("</li>")
	next
	response.write("</ul>")
end sub

'**
'* Function selects the appropriate error message to print,
'* according to predefined messages in errorCode array.
'*
'* @param code int - The error code.
'* @return String - The error message.
'*
function selectErrorMessage(code)

	dim errorMessage

	select case code
		case 0
			errorMessage = errorCode(0)
		case 1
			errorMessage = errorCode(1)
		case 2
			errorMessage = errorCode(2)
		case 3
			errorMessage = errorCode(3)
		case 4
			errorMessage = errorCode(4)
		case 5
			errorMessage = errorCode(5)
		case 6
			errorMessage = errorCode(6)
		case 7
			errorMessage = errorCode(7)
		case 8
			errorMessage = errorCode(8)
		case 9
			errorMessage = errorCode(9)
		case 10
			errorMessage = errorCode(10)
	end select

	selectErrorMessage = errorMessage

end function

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
			response.write("<li><strong>")
			response.write(unitErrorMessage(i, E_FIELD))
			response.write("</strong> ")
			response.write(selectErrorMessage(unitErrorMessage(i, E_ECODE)))
			response.write("</li>")

		else
			currentRow = unitErrorMessage(i, E_ROW)
			response.write("</ul>")
			response.write("Error/s on <strong>Row ") 
			response.write(unitErrorMessage(i, E_ROW))
			response.write(":</strong>")
			response.write("<ul>")
			response.write("<li><strong>")
			response.write(unitErrorMessage(i, E_FIELD))
			response.write("</strong> ")
			response.write(selectErrorMessage(unitErrorMessage(i, E_ECODE)))
			response.write("</li>")
		end if
	next

	response.write("</ul>")
end sub

'**
'* Sub displays logic errors.
'*
sub displayLogicErrors()

	response.write(logicErrorTitle)

	for i = 0 to logicErrorCount - 1
		response.write("<li><strong>")
		response.write(logicErrorMessage(i, LE_FIELD))
		response.write("</strong> ")
		response.write(selectErrorMessage(logicErrorMessage(i, LE_ECODE)))

		select case logicErrorMessage(i, LE_ECODE)
			case 9
				response.write(logicErrorMessage(i, LE_ROW_1))
				response.write(" and ")
				response.write(logicErrorMessage(i, LE_ROW_2))
			case 10
				response.write(logicErrorMessage(i, LE_SEM))
				response.write(" at rows ")
				response.write(logicErrorMessage(i, LE_ROW_1))
				response.write(" and ")
				response.write(logicErrorMessage(i, LE_ROW_2))
		end select
	next

end sub

%>

