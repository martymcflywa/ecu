<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title>CPA 2015</title>
</head>

<body>

<?php

require_once 'includes/php/Student.php';
use includes\Student;
require_once 'includes/php/Units.php';
use includes\Units;
require_once 'includes/php/BusinessRules.php';
use includes\BusinessRules;
require_once 'includes/php/Validator.php';
use includes\Validator;
require_once 'includes/php/Controller.php';
use includes\Controller;
require_once 'includes/php/View.php';
require_once 'includes/php/ViewSummary.php';
require_once 'includes/php/ViewError.php';

/**
 * This php script accepts student and unit input data and presents
 * a course progression summary to the user, if input passes validation.
 * If not, it displays a view of the errors, indicating to the user
 * the action they need to take to correct their input.
 *
 * It is designed and written in an object oriented style, attempting to implement MVC.
 * Student, Units represent the Model,
 * Validator, BusinessRules as sub controllers,
 * Controller as the Controller,
 * and the View (and its subclasses) as the View.
 *
 * Basic and advanced validation/criteria/business rules,
 * per the assignment brief have been implemented.
 *
 * @author Martin Ponce, 10371381
 * @version 20150906
 */

// comment this out to see notices too
// notices are generated for Validator->validatePassMatchUnits() and Validator->validateSemMatchUnits(),
// even though testing isset($theArray) before calling them
error_reporting(E_ALL & ~E_NOTICE);

// create the models
$theStudent = new Student();
$theUnits = new Units();
// pass student and units to theValidator and theRules, so they can validate their data
$theValidator = new Validator($theStudent, $theUnits);
$theRules = new BusinessRules($theStudent, $theUnits);

// create the controller, pass all the objects to it
// rest of mainline logic happens in theController constructor
$theController = new Controller(
    $theStudent,
    $theUnits,
    $theRules,
    $theValidator
);


/**
 * BEGIN DEBUG
 */
//echo(var_dump($theUnits->getUnitDetails()[0][Units::UM]));
//echo(var_dump($theValidator->getStudentErrorTally()) . " " . var_dump($theValidator->getUnitErrorTally()) . " " . var_dump($theValidator->getLogicErrorTally()));
//echo(var_dump($theUnits->getUnitDetails()));
//echo(var_dump(!isset($theUnits->getUnitDetails()[0][Units::UM])));
//echo(var_dump(preg_match($this->regExDict["unitCodeSuffix"], $this->theUnits->getUnitDetails()[0][Units::UC]))) // >= 6000
//echo("<br />");
//echo(var_dump(array_key_exists(1, $theUnits->getUnitDetails())) . "<br />");
//echo(var_dump(isset($theUnits->getUnitDetails()[1][Units::UC])) . "<br />");
//echo(var_dump($theUnits->getUnitDetails()));
//echo(var_dump($theValidator->getStudentErrorTally()) . " " . var_dump($theValidator->getUnitErrorTally()) . "<br/>");
/**
 * END DEBUG
 */

?>

</body>
</html>
