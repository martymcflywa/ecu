<?php

// suppress "undefined index" error for $salaried,
// appears when unchecked - otherwise comment out for debugging
error_reporting(E_ERROR | E_PARSE);

/************************
 **** MAINLINE LOGIC ****
 ************************/

// define variables and assign them from form input
$employeeID = $_POST["EmployeeID"];
$employeeSurname = $_POST["EmployeeSurname"];
$employeeFirstName = $_POST["EmployeeFirstname"];
$salaried = $_POST["Salaried"];
$rateOfPay = $_POST["RateOfPay"];
$hoursWorked = $_POST["HoursWorked"];


// variables waiting to be initialised
$overtimePay;
$overtimeHours;

// constants
define("WORK_LOAD", 40);
define("OVERTIME_RATE", 1.5);

// priming read
$grossPay = 0;

// validate user input
validate($employeeID, "EmployeeID", "number");
validate($employeeFirstName, "Firstname", "string");
validate($employeeSurname, "Surname", "string");
validate($rateOfPay, "Rate of pay", "number");
validate($hoursWorked, "Hours worked", "number");

// check actual hoursWorked against WORK_LOAD
if($hoursWorked > WORK_LOAD) {
	$overtimeHours = $hoursWorked - WORK_LOAD;
	overtimeModule();
} else {
	$grossPay = $hoursWorked * $rateOfPay;
}

printSummary();

/*******************
 **** FUNCTIONS ****
 *******************/

/**
 * Function validates form fields and prints error if incomplete or incorrect datatype.
 *
 * @param $varName - Variable that stores the form field
 * @param $formField String - The form field name, used for the error message
 * @param $dataType String - Either "number" or "string"
 */
function validate($varName, $formField, $dataType) {

	// check if field is populated
	if(isPopulated($varName)) {

		// do this when dataType is number
		if($dataType == "number") {

			if(!is_numeric($varName)) {
				printError($formField, "numeric");
				exit;

			} else if($varName <= 0) {

				printError($formField, "greater than zero");
				exit;
			}

		// else do this when dataType is string
		} else if($dataType == "string") {

			if(is_numeric($varName)) {

				printError($formField, "string");
				exit;
			}
		}

	// print error message if field is not populated
	} else {

		printError($formField, "provided");
		exit;
	}
}

/**
 * Function checks if field is populated.
 * True if strlen > 0,
 * False if strlen <= 0.
 *
 * @param $varName - The variable to test
 * @return boolean
 */
function isPopulated($varName) {
	return strlen($varName) > 0;
}

/**
 * Function calculates overtime pay.
 */
function overtimeModule() {

	global $salaried;
	global $overtimePay;
	global $hoursWorked;
	global $rateOfPay;
	global $grossPay;

	if($salaried == 1) {
		$overtimePay = 0;
	} else {
		$overtimePay = ($hoursWorked - WORK_LOAD) * (OVERTIME_RATE * $rateOfPay);
	}

	$grossPay = ($hoursWorked * $rateOfPay) + $overtimePay;
}

/**
 * Function prints summary of results.
 * Only prints overtime hours if overtime hours > 0.
 * Checks if salaried is yes/no.
 */
function printSummary() {

	global $employeeID;
	global $employeeFirstName;
	global $employeeSurname;
	global $grossPay;
	global $overtimeHours;
	global $salaried;

	echo("<h2>Details</h2>");
	echo("<hr />");
	echo("<strong>Employee ID: </strong> $employeeID <br />");

	// call properNoun() to correctly case names
	echo("<strong>Employee Name: </strong>" . properNoun($employeeFirstName) . " " . properNoun($employeeSurname) . "<br />");

	echo("<strong>Gross pay: </strong> \$$grossPay <br />");

	// check for overtime
	if($overtimeHours > 0) {
		echo("<strong>Overtime hours: </strong> $overtimeHours <br />");
	}

	echo("<strong>Salaried: </strong>");

	// check for salaried
	if($salaried == 0) {
		echo("No");
	} else {
		echo("Yes");
	}
}

/**
 * Function prints error message.
 * 
 * @param $field String - The form field that has error
 * @param $errorMessage String - The error message to be displayed
 */
function printError($field, $errorMessage) {
	echo("<h2>Error</h2>");
	echo("<hr />");
	echo("<strong> $field </strong> must be");
	echo("<strong> $errorMessage </strong>. Please try again.");
}

/**
 * Function forces proper noun casing for names.
 * Probably not required since it's very easy to do in php compared to asp.
 * ie. Just call ucfirst(string).
 *
 * @param $theString String - The string to manipulate
 * @return String - The manipulated string
 */
function properNoun($theString) {
	return ucfirst($theString);
}
?>