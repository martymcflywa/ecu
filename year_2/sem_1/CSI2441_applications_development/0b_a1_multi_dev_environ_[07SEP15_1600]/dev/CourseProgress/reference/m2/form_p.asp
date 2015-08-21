<%@LANGUAGE="VBSCRIPT" CODEPAGE="65001"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Initialising Looping values for Unknown number of repeating rows</title>
</head>

<body>
<h1>Order Form</h1>
<hr />
<%

dim Item, varFieldCount, varProductRowCount, varRequireOrderFieldCount
varFieldCount = 0
varProductRowCount = 0


'this code loops through the entire form, counting all the fields (including the submit button)
For Each Item in Request.Form
 
  varFieldCount = varFieldCount + 1

 Next

response.Write "there were " & varFieldCount & " fields in total (including submit button)" & "<br /><br />"

'now we subtract the three fields we know are not product order fields from the total field count
varFieldCount = varFieldCount - 3

'now, we know there are two fields per row of the product ordering section, so we divide thev total field count as such
varProductRowCount = varFieldCount / 2

response.Write "In order to process the product order fields we now have " & varFieldCount & " fields in total and " & varProductRowCount & " rows to work with<br /><br /><br /><hr />"


'now, we can start processing the form from scratch as we know how man times we have to loop through the product ordering section of the form
If Request.Form("CustomerName") = "" OR Request.Form("CustomerCompany") = "" Then
	Response.Write "Customer name and Customer company fields cannot be left blank <br />Program ending...."
	Response.End()
End If

%>
<table border="1">
<tr>
<td>Produdct ID</td><td>Quantity</td>
</tr>
<%
'this for loop will now go through each row of the input and display any content placed in the fields.  Obviously, before we start doing any actual work on processing this input, we would need to validate which rows are completely empty (and ignore them) and which rows were partially empty (and display error messages)


For i = 1 to varProductRowCount
%>
<tr>
<td>
<%

	Response.Write Request.Form("ProdID_" & i)
%>
</td>
<td>
<%

	Response.Write Request.Form("Qt_" & i)
%>
</td>
</tr>
<%

Next
%>
</table>
</body>
</html>
