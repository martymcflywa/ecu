<html>
    <head>
        <title>Northwind Products</title>
    </head>
<body>
    <h1>Northwind Products</h1>

<%

dim totalRecords

'holds database connection object
dim adoCon

'creates a connection to the database with correct path settings and db type
set adoCon = server.createObject("adodb.connection")
adoCon.open = "PROVIDER=MSDASQL;" & _
	"DRIVER={Microsoft Access Driver (*.mdb)};" & _
	"DBQ=E:\Documents\Dropbox\Documents\ecu\year_2\sem_1\CSI2441_applications_development\module_04_designing_and_writing_applications\AccessDatabase\db\Nwind.mdb;" & _
	"UID=admin;PWD=;"

dim searchTerm
searchTerm = request.form("ProductName")

'defines the variables for the query and recordset 
'which will retrieve all products from the products table
dim getProducts, productList
'variable replaces command to return * from products
getProducts = "select * from Products where ProductName like '%" & searchTerm & "%' order by ProductName"
'set ado recordset, stores result from database
set productList = server.createObject("adodb.recordset")

'this code opens the product recordset with search results
'based on the sql query sent to it
productList.open getProducts, adoCon

call totalItem()

if totalRecords = 0 then
    call printError()
    call closeHTML
    response.end
else
    call printResultHead()
    'print total
    response.write("Total records found: " & totalRecords & "</br>")
    'reset productList back to the start
    productList.moveFirst
    call iterateProducts()
    call closeTable()
    call closeHTML()
    call cleanUp()
end if

'sub calculates total items in list
sub totalItem()

    'create a count variable, increment for each loop through productList recordset,
    'starting with the following priming read
    totalRecords = 0

    do while not productList.eof
    	'increment totalRecords
    	totalRecords = totalRecords + 1
    	productList.moveNext
    loop
end sub

sub printResultHead()
    response.write("<p>[ List Products ] </p>")
    response.write("<hr />")
    response.write("<table>")
    response.write("<tr bgcolor=""yellow"">")
    response.write("<td align=""center""><strong>Product name</strong></td>")
    response.write("<td align=""center""><strong>Supplier</strong></td>")
    response.write("<td align=""center""><strong>Category</strong></td>")
    response.write("<td align=""center""><strong>Quantity per unit</strong></td>")
    response.write("<td align=""center""><strong>Unit price</strong></td>")
    response.write("<td align=""center""><strong>Units in stock</strong></td>")
    response.write("<td align=""center""><strong>Units on order</strong></td>")
    response.write("<td align=""center""><strong>Reorder warning</strong></td>")
    response.write("</tr>")
end sub

sub iterateProducts()

    do while not productList.eof

    	'return category name instead of id
    	dim getCategoryName, categoryName
    	getCategoryName = "select CategoryName from Categories where CategoryID = " & productList("CategoryID") & ""
    	set categoryName = server.createObject("adodb.recordset")
    	categoryName.open getCategoryName, adoCon

    	'return supplier name instead of id
    	dim getSupplierName, supplierName
    	getSupplierName = "select CompanyName from Suppliers where SupplierID = " &  productList("SupplierID") & ""
    	set supplierName = server.createObject("adodb.recordset")
    	supplierName.open getSupplierName, adoCon

    	'define the table row within the recordset loop
    	response.write("<tr>")

    	'display the table cells with the database fields in them
    	response.write("<td><strong>")
    	response.write(productList("ProductName"))
    	response.write("</strong></td>")
    	response.write("<td align='center'>")
    	response.write(supplierName("CompanyName"))
    	response.write("</td>")
    	response.write("<td align='center'>")
    	response.write(categoryName("CategoryName"))
    	response.write("</td>")
    	response.write("<td align='center'>")
    	response.write(productList("QuantityPerUnit"))
    	response.write("</td>")
    	response.write("<td align='center'>$")
    	response.write(productList("UnitPrice"))
    	response.write("</td>")
        response.write("<td align='center'>")
        response.write(productList("UnitsInStock"))
        response.write("</td>")
        response.write("<td align='center'>")
        response.write(productList("UnitsOnOrder"))
        response.write("</td>")

        call checkStockOrder(productList("UnitsInStock"), productList("ReorderLevel"))

    	'close the row for each row
    	response.write("</tr>")

    	'move to the next recordset
    	productList.moveNext
    loop
end sub

sub checkStockOrder(inStock, orderLevel)
    if inStock <= orderLevel then
        response.write("<td align='center'>")
        response.write("Y")
        response.write("</td>")
    end if
end sub

sub closeTable()
    response.write("</table>")
    response.write("<p></p>")
end sub

sub closeHTML()
    response.write("</body>")
    response.write("</html>")
end sub

sub cleanUp()
    'reset server objects
    productList.close
    'categoryName.close
    'supplierName.close
    set productList = nothing
    set categoryName = nothing
    set supplierName = nothing
    adoCon.close
    set adoCon = nothing
end sub

'print error subroutine
sub printError()
    response.write("<p>[ Error ]</p><hr />")
    response.write("<p>No results found. Please try again.</p>")
end sub

%>