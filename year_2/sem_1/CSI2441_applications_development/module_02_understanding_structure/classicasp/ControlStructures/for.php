<?php

// priming read, user input
$value = 0;
$userInput;
// max constant, made it 20 so don't have to scroll every time
define("MAX", 20);

// check user input is numeric before initialising variable
if(is_numeric($_POST["userValue"])) {
	$userInput = $_POST["userValue"];
} else {
	echo "Value must be numeric! <br />";
	return;
}

for($i = 1; $i <= $userInput; $i++) {
	if($i <= MAX) {
		echo("$i of $userInput <br />");
	} else {
		echo("<br />Iteration exceeds maximum " . MAX . " iterations. <br />Program terminated...");
		return;
	}
}

echo("<br />Loop completed after $userInput iterations.");

?>
