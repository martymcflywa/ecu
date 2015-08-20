<%
    
 'Holds the Database Connection Object
 Dim adoCon

 'Creates a connection to the database with the correct path settings and database type
    Set adoCon = Server.CreateObject("adodb.connection")
  adoCon.open =  "PROVIDER=MSDASQL;" & _
             "DRIVER={Microsoft Access Driver (*.mdb)};" & _
             "DBQ=E:\Documents\Dropbox\Documents\ecu\year_2\sem_1\CSI2441_applications_development\module_04_designing_and_writing_applications\AccessDatabase\db\Nwind.mdb;" & _
             "UID=admin;PWD=;"

        'Defines he variables for the query and recordset which will retrieve all products from the Products table
        Dim sqlGetProducts,rsProductList
        sqlGetProducts = "Select * from Products"
        Set rsProductList = Server.CreateObject("ADODB.Recordset")

        'This code opens the product recordset with the search results based on the sql query sent to it
        rsProductList.open sqlGetProducts, adoCon
%>
<html>
<head>
<title>Northwind Products</title>
</head>
<body>
<h1>Northwind Products</h1>
<p>[ List Products ] </p>
<hr />
<table>
<tr bgcolor="yellow">
<td align="center"><strong>Product name</strong></td>
<td align="center"><strong>Supplier</strong></td>
<td align="center"><strong>Category</strong></td>
<td align="center"><strong>Quantity per unit</strong></td>
<td align="center"><strong>Unit price</strong></td>
</tr>

<%
Do While not rsProductList.EOF
 
    'define the table row within the recordset loop
 response.write("<tr>")
 
 'display the table cells with the database fields in them
 Response.Write ("<td><strong>")
 Response.Write (rsProductList("ProductName"))
 Response.Write ("</strong></td>")
 Response.Write ("<td align='center'>")
 Response.Write (rsProductList("SupplierID"))
 Response.Write ("</td>")
 Response.Write ("<td align='center'>")
 Response.Write (rsProductList("CategoryID"))
 Response.Write ("</td>")
 Response.Write ("<td align='center'>")
 Response.Write (rsProductList("QuantityPerUnit"))
 Response.Write ("</td>")
 Response.Write ("<td align='center'>$")
 Response.Write (rsProductList("UnitPrice"))
 Response.Write ("</td>")
    
 'close the row for each row in the recordset before the next iteration of the loop
 response.write("</tr>")


 'Move to the next record in the recordset
 rsProductList.MoveNext

Loop

'Reset server objects
rsProductList.Close
Set rsProductList = Nothing
Set adoCon = Nothing
%>

<p>   </p>
</body>
</html>