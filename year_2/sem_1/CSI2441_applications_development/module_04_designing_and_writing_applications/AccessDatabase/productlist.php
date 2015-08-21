<html>
    <head>
        <title>Northwind Products</title>
    </head>
<body>
    <h1>Northwind Products</h1>

<?php

$dbPath = realpath("db/Northwind.mdb");
$conn = new COM("ADODB.Connection") or exit("Cannot start ADO.");
$conn->open("Provider=Microsoft.Jet.OLEDB.4.0; Data Source=$dbPath; UID=admin;PWD=;") or exit("Cannot open with Jet.");

//$conn->open("DRIVER={Microsoft Access Driver (*.mdb)}; DBQ=$db; UID=admin;PWD=;") or exit("Cannot open with driver.");

$totalRecords = 0;
$searchTerm = $_POST["ProductName"];

$productsQuery = 
	"select * from Products
	where ProductName
	like '%$searchTerm%'
	order by ProductName";

$productsList = $conn->execute($productsQuery);

totalItem();

if($totalRecords == 0) {
	printError();
	closeHTML();
	exit;
} else {
	printResultHead();
	echo("Total records found: $totalRecords </br>");
	$productsList->moveFirst();
	iterateProducts();
	closeTable();
	closeHTML();
	cleanUp();
}

function totalItem() {

	global $totalRecords;
	global $productsList;

	while(!$productsList->EOF) {
		$totalRecords++;
		$productsList->moveNext();
	}
}

function printResultHead() {

	echo("<p>[ List Products ] </p>");
    echo("<hr />");
    echo("<table>");
    echo("<tr bgcolor=\"yellow\">");
    echo("<td align=\"center\"><strong>Product name</strong></td>");
    echo("<td align=\"center\"><strong>Supplier</strong></td>");
    echo("<td align=\"center\"><strong>Category</strong></td>");
    echo("<td align=\"center\"><strong>Quantity per unit</strong></td>");
    echo("<td align=\"center\"><strong>Unit price</strong></td>");
    echo("<td align=\"center\"><strong>Units in stock</strong></td>");
    echo("<td align=\"center\"><strong>Units on order</strong></td>");
    echo("<td align=\"center\"><strong>Reorder warning</strong></td>");
    echo("</tr>");
}

function iterateProducts() {

	global $productsList;

	while(!$productsList->EOF) {

		$categoryQuery = 
		"select CategoryName
		from Categories
		where CategoryID = " . $productsList->fields("CategoryID");

		$categoryNames = $conn->execute($categoryQuery);

		$supplierQuery =
			"select CompanyName
			from Suppliers
			where SupplierID = " . $productsList->fields("SupplierID");

		$supplierNames = $conn->execute($supplierQuery);

	    // define the table row within the recordset loop
		echo("<tr>");

		// display the table cells with the database fields in them
		echo("<td><strong>");
		echo($productsList>fields("ProductName"));
		echo("</strong></td>");
		echo("<td align='center'>");
		echo($supplierNames->fields("CompanyName"));
		echo("</td>");
		echo("<td align='center'>");
		echo($categoryNames->fields("CategoryName"));
		echo("</td>");
		echo("<td align='center'>");
		echo($productsList->fields("QuantityPerUnit"));
		echo("</td>");
		echo("<td align='center'>$");
		echo($productsList->fields("UnitPrice"));
		echo("</td>");
	    echo("<td align='center'>");
	    echo($productsList->fields("UnitsInStock"));
	    echo("</td>");
	    echo("<td align='center'>");
	    echo($productsList->fields("UnitsOnOrder"));
	    echo("</td>");

	    checkStockOrder($productsList->fields("UnitsInStock"), $productsList->fields("ReorderLevel"));

	    // close the row
	    echo("</tr>");

	    // next recordset
	    $productsList->moveNext();
	}
}

function checkStockOrder($inStock, $orderLevel) {
	if($inStock <= $orderLevel) {
		echo("<td align=\"center\">");
        echo("Y");
        echo("</td>");
	}
}

function closeTable() {
	echo("</table>");
    echo("<p></p>");
}

function closeHTML() {
    echo("</body>");
    echo("</html>");
}

function cleanUp() {
	global $productsList;
	global $conn;

	$productsList->close();
	$conn->close();
}

function printError() {
    echo("<p>[ Error ]</p><hr />");
    echo("<p>No results found. Please try again.</p>");
}

?>