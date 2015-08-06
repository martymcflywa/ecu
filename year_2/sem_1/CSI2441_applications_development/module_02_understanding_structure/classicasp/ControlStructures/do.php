<?php

// priming read and user input
$value = 0;
$userInput;

// check user input is numeric before initialising variable
if(is_numeric($_POST["userValue"])) {
	$userInput = $_POST["userValue"];
} else {
	echo("Value must be numeric! <br />");
	return;
}

// check user input is in range before performing action
if($userInput != 1 && $userInput != 2 && $userInput != 5) {
	echo("Input is outside of allowed range, please try again");
} else {
	do {
		echo("$value <br />");
		$value = $value + $userInput;
	} while($value < 10);
}
?>
