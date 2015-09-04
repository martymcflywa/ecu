<?php

namespace includes;
require 'includes/php/Student.php';
use includes\Student;

/**
 * Class Helpers contains static helper functions to assist
 * validating and summarizing user input.
 *
 * @package includes
 */
class Helpers {

    /**
     * Static class, do not instantiate!
     */
    private function __construct() {
        // don't instantiate me
    }

    /**
     * Function tests if field is populated.
     *
     * @param $field String - The field to test.
     * @return bool
     */
    public static function isPopulated($field) {
        return strlen($_POST[$field]) > 0;
    }

    /**
     * Function populates error arrays when input is missing from the form.
     *
     * @param $data String - Either "student" or "unit".
     * @param $row int - The partially filled row, use -1 if $data == "student".
     * @param $field String - The missing value.
     */
    public static function missingInputError($data, $row, $field) {
        switch($data) {
            case "student":
                Student::incrementStudentErrorCount();
        }
    }
}

?>