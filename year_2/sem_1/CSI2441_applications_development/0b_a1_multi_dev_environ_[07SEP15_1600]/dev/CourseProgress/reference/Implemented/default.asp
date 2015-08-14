<%@LANGUAGE="VBSCRIPT"%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Implemented Form Validation</title>
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
<!--Settings-->
<%
'=================================
'All fields are acted as required
' except those the NAME of which
' is in this string variable:
'=================================
exceptions = Array("address")

'=================================
'NAME of the e-mail field is 
' stored in this string variable:
'=================================
emailField = "email"

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
		isException = False
		IF inputArray(i,2)="" THEN
			FOR j = 0 to UBound(exceptions)
				IF inputArray(i,1) = exceptions(j) THEN isException = TRUE
			NEXT
			IF NOT isException THEN
				badItem = i
				errorMessage = "At least one of the required fields is left empty."
				EXIT SUB
			END IF
		END IF
		isException = False
	NEXT
	'=================================
	'Check email address for basic
	' errors
	'=================================
	FOR i = 1 TO numberOfFields
		IF emailField=inputArray(i,1) THEN
			validationResult = validateEmail(inputArray(i,2))
			IF validationResult <> "" THEN
				errorMessage = validationResult
				badItem = i
			END IF
		END IF
	NEXT
END SUB

FUNCTION validateEmail(strAddress)
	IF InStr(strAddress,"@") < 2 THEN
		validateEmail = "Email address must contain ""@"" sign."
	ELSEIF InStr(Right(strAddress,Len(strAddress)-InStr(strAddress,"@")),".") < 2 OR InStr(Right(strAddress,Len(strAddress)-InStr(strAddress,"@")),".") = Len(strAddress)-InStr(strAddress,"@") THEN
		validateEmail = "Email address must contain ""."" sign."
	ELSE
		host = Right(strAddress,Len(strAddress)-InStr(strAddress,"@"))
		IF NOT MXLookUp(host) THEN validateEmail = "Bad email address."
	END IF
END FUNCTION

FUNCTION MXLookUp(host)
	MXLookUp = False
	Dim objXMLHTTP,strResult
	Set objXMLHTTP = Server.CreateObject("Microsoft.XMLHTTP")
	objXMLHTTP.Open "Get", _
		"http://examples.softwaremodules.com/IntraDns.asp?domainname=" & host & "&Submit=Submit&t_mx=1", False
	objXMLHTTP.Send
	strResult = objXMLHTTP.ResponseText
	strResult = Mid(strResult,InStr(strResult,"(MX) for <strong>"),100)
	strResult = Mid(strResult,Instr(strResult,"</strong>. Items Returned: <strong>")+35,1)
	IF CInt(strResult) > 0 THEN 
		MXLookUp = TRUE
	ELSE
		MXLookUp = FALSE
	END IF
END FUNCTION 
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
	response.End
END IF
%>

<form action="default.asp" method="post">

<p>Name: <font color="#FF0000">*</font>
<input name="name" type="text" id="name" value="<%=inputArray(1,2)%>" <%IF badItem=1 THEN response.write "class=""errorItem"""%>/>
</p>

<p>Address: 
<input name="address" type="text" id="address" value="<%=inputArray(2,2)%>" <%IF badItem=2 THEN response.write "class=""errorItem"""%>/>
</p>

<p>Email: <font color="#FF0000">*</font>
<input name="email" type="text" id="email" value="<%=inputArray(3,2)%>" <%IF badItem=3 THEN response.write "class=""errorItem"""%>/>
</p>

<p> 
<input type="submit" value="Submit" />
</p>

</form>

</body>
</html>
