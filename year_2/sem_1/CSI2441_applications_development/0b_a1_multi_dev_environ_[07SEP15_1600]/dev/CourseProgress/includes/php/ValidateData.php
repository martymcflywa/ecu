<?php

namespace includes;

class ValidateData {

    private $firstName;
    private $surname;
    private $enrolmentType;
    private $studentID;
    private $courseType;

    function __construct($firstName, $surname, $enrolmentType, $studentID, $courseType) {
        $this->firstName = $firstName;
        $this->surname = $surname;
    }

    public static function validateStudentDetails() {

    }

}

?>