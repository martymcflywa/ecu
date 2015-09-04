<?php

namespace includes;
require 'includes/php/Student.php';
use includes\Student;

class Helpers {

    /**
     * Function tests if field is populated.
     *
     * @param $field
     * @return bool
     */
    public static function isPopulated($field) {
        return strlen($_POST[$field]) > 0;
//        if($_POST[$field] != "") {
//            return true;
//        } else {
//            return false;
//        }
    }

    public static function missingInputError($data, $row, $field) {
        switch($data) {
            case "student":
                Student::incrementStudentErrorCount();
        }
    }
}

?>