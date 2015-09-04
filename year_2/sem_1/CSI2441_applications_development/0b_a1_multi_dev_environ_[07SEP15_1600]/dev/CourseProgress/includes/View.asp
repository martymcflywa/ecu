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

	'test
	'response.write(logicErrorCount)
	response.write("<h2>TEST TRANSCRIPT ONLY!</h2>")
	for i = 0 to filledRows - 1
		for j = 0 to 4
			response.write(unitDetails(i, j) & " | ")
		next
		response.write("<br/>")
	next
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
sub displayUnitErrorsT()

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

sub displayLogicErrorsD()

	dim currentRow, currentCode

	response.write(logicErrorTitle)
	response.write("<ul>")

	for i = 0 to logicErrorCount - 1

		if currentRow <> logicErrorMessage(i, LE_ROW_1) and currentCode <> logicErrorMessage(i, LE_ECODE) then

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
		else 
			currentRow = logicErrorMessage(i, LE_ROW_1)
			currentCode = logicErrorMessage(i, LE_ECODE)
		end if
	next

	response.write("</ul>")
end sub

sub displayLogicErrorsNewModel()

	dim i, j

	response.write(logicErrorTitle)
	response.write("<ul>")

	for i = 0 to logicErrorCount - 1
		j = logicErrorCount - 1
		do while j > i

			response.write(j & "<br />")

			if logicErrorMessage(i, LE_FIELD) <> logicErrorMessage(j, LE_FIELD) and _
					logicErrorMessage(i, LE_ECODE) <> logicErrorMessage(j, LE_ECODE) and _
					logicErrorMessage(i, LE_ROW_1) <> logicErrorMessage(j, LE_ROW_1) then

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

				'response.write("</ul>")

			end if
			j = j - 1
		loop
	next

	response.write("</ul>")

end sub

sub displayLogicErrorsOldModel()

	dim currentRow, currentMessage

	response.write(logicErrorTitle)

	response.write("<ul>")

	for i = 0 to logicErrorCount - 1

		if currentRow <> logicErrorMessage(i, 0) and currentMessage <> logicErrorMessage(i, 1) then
			response.write("<li><strong>" & logicErrorMessage(i, 0) & "</strong> " & logicErrorMessage(i, 1) & logicErrorMessage(i, 2))
		else 
			currentRow = logicErrorMessage(i, 0)
			currentMessage = logicErrorMessage(i, 1)
		end if
	next

	response.write("</ul>")
end sub

sub displayLogicErrors()

	dim j
	dim ignoreRow(), ignoreCount', matchSem()
	ignoreCount = 0

	response.write(logicErrorTitle)
	response.write("<ul>")

	'scan logicErrorMessage for any repeated entries
	for i = 0 to logicErrorCount - 1
		
		j = logicErrorCount - 1

		do while j > i
			if logicErrorMessage(i, LE_ECODE) = logicErrorMessage(j, LE_ECODE) then
				if logicErrorMessage(i, LE_ROW_1) = logicErrorMessage(j, LE_ROW_1) then
					'record index for repeated entry
					ignoreCount = ignoreCount + 1
					redim preserve ignoreRow(ignoreCount)
					ignoreRow(ignoreCount - 1) = j - 1
				end if
			end if

			j = j - 1
		loop
	next

	response.write(ignoreCount)

	if ignoreCount > 0 then
		for k = 0 to logicErrorCount - 1
			for m = 0 to ignoreCount - 1
				if k <> ignoreRow(m) then

					response.write("<li><strong>")
					response.write(logicErrorMessage(k, LE_FIELD))
					response.write("</strong> ")
					response.write(selectErrorMessage(logicErrorMessage(k, LE_ECODE)))

					select case logicErrorMessage(k, LE_ECODE)
						case 9
							response.write(logicErrorMessage(k, LE_ROW_1))
							response.write(" and ")
							response.write(logicErrorMessage(k, LE_ROW_2))
						case 10
							response.write(logicErrorMessage(k, LE_SEM))
							response.write(" at rows ")
							response.write(logicErrorMessage(k, LE_ROW_1))
							response.write(" and ")
							response.write(logicErrorMessage(k, LE_ROW_2))
					end select
				end if
			next
		next
	else

		response.write("<li><strong>")
		response.write(logicErrorMessage(k, LE_FIELD))
		response.write("</strong> ")
		response.write(selectErrorMessage(logicErrorMessage(k, LE_ECODE)))

		select case logicErrorMessage(k, LE_ECODE)
			case 9
				response.write(logicErrorMessage(k, LE_ROW_1))
				response.write(" and ")
				response.write(logicErrorMessage(k, LE_ROW_2))
			case 10
				response.write(logicErrorMessage(k, LE_SEM))
				response.write(" at rows ")
				response.write(logicErrorMessage(k, LE_ROW_1))
				response.write(" and ")
				response.write(logicErrorMessage(k, LE_ROW_2))
		end select
	end if

	response.write("</ul>")

end sub
%>
