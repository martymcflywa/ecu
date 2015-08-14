<%@LANGUAGE="VBSCRIPT"%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Simple Form Validation</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<style>
	.errorMessage {
		color : #F00;
	}
	.errorItem {
		background : #F99;
	}
</style>
<body>
<%
'=================================
'Variables
'=================================
dim errorMessage, badItem, inputArray() : badItem=-1
redim inputArray(50,2)

'=================================
'Get all what is submitted
'=================================
IF request.Form.Count > 0 THEN
	execute("const numberOfFields =" & request.Form.Count)
	execute("redim inputArray("&numberOfFields&",2)")
	FOR i = 1 TO request.Form.Count
		inputArray(i,1) = request.Form.Key(i)
		inputArray(i,2) = request.Form.Item(i)
	NEXT
	validate
ELSEIF request.QueryString.Count > 0 THEN
	execute("const numberOfFields =" & request.QueryString.Count)
	execute("redim inputArray("&numberOfFields&",2)")
	FOR i = 1 TO request.QueryString.Count
		inputArray(i,1) = request.QueryString.Key(i)
		inputArray(i,2) = request.QueryString.Item(i)
	NEXT
	validate
END IF

SUB validate
	'=================================
	'Check for empty fields
	'=================================
	FOR i = 1 TO numberOfFields
		IF inputArray(i,2)="" THEN
			badItem = i
			errorMessage = "At least one of the required fields is left empty."
			EXIT SUB
		END IF
	NEXT
END SUB
%>
<h2>Form Validator</h2>
<%
IF errorMessage<>"" THEN
	%>
	<p class="errorMessage">There was an error with your form: <b><%=errorMessage%></b></p>
	<%
ELSEIF request.form.count = 0 AND request.form.count = 0 THEN
	%>
	<h3>Please fill in the form:</h3>
	<%
ELSE
	%>
	<h3>Thank you!</h3>
	</body>
	</html>
	<%
	Response.End
END IF
%>

<form action="default.asp" method="post">

<p>
Name: <font color="#FF0000">*</font>
<input name="name" type="text" id="name" value="<%=inputArray(1,2)%>" <%IF badItem=1 THEN response.write "class=""errorItem"""%>/>
</p>

<p> 
<input type="submit" value="Submit" />
</p>

</form>

</body>
</html>