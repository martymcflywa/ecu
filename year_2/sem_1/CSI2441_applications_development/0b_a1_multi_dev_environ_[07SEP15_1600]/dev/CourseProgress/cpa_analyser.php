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
require_once 'includes/php/View.php';
use includes\View;
require_once 'includes/php/ViewSummary.php';
use includes\ViewSummary;
require_once 'includes/php/ViewError.php';
use includes\ViewError;

/**
 * This php script accepts student and unit input data and presents
 * a course progression summary to the user, if input passes validation.
 *
 * It is designed and written in an object oriented style, attempting to implement MVC.
 * Student, Units, BusinessRules represent the Model,
 * Validator (and $this::cpa_analyser.php) as the Controller,
 * and the View (and its subclasses) as the View.
 *
 * Basic and advanced validation/criteria/business rules,
 * per the assignment brief have been implemented.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
 */

// create the models, they shouldn't know each other
$theStudent = new Student();
$theUnits = new Units();
$theRules = new BusinessRules();
// create the controller, knows about everyone
$theValidator = new Validator($theStudent, $theUnits, $theRules);

// import the controller, would do at construction, but having "chicken or the egg" issues
// theStudent also shouldn't refer the controller, but it needs Validator->missingInputError()
// which proves that a separate controller class should be defined, but... running out of time
$theStudent->setController($theValidator);
$theRules->setController($theValidator);

// start theStudent and theUnits, these calls initiate the retrieval and storage of user input into arrays
$theStudent->startStudent();
$theUnits->startUnits();
// start theValidator, only do this after theStudent/Unit has retrieved their data
$theValidator->startValidator();

// if no errors,
if($theValidator->getStudentErrorTally() == 0 &&
        $theValidator->getUnitErrorTally() == 0 &&
        $theValidator->getLogicErrorTally() == 0) {
    
    // calculate the summary
    $theRules->calculateSummary();
    // then show me the summary
        // note:   view probably shouldn't know about these objects for mvc,
        //         could route inter-class get/setters through theValidator or theRules if time permits
    $theSummaryView = new ViewSummary("Course Progression Summary", $theValidator);

} else {
    // else there are errors, go to the error view immediately
    $theErrorView = new ViewError("Course Progression Form Errors", $theValidator);
}

/**
 * BEGIN TEST
 */
//echo(var_dump($theUnits->getUnitDetails()[0][Units::UM]));
//echo(var_dump($theValidator->getStudentErrorTally()) . " " . var_dump($theValidator->getUnitErrorTally()) . " " . var_dump($theValidator->getLogicErrorTally()));
//echo(var_dump($theUnits->getUnitDetails()));
echo(var_dump(!isset($theUnits->getUnitDetails()[0][Units::UM])));
/**
 * END TEST
 */

?>

<p>&nbsp;</p>
</body>
</html>
