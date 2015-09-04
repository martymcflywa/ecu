<?php

namespace includes;

/**
 * Class Helpers contains static helper functions to assist
 * validating and summarizing user input.
 * TODO: Pretty useless now, might delete it.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
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


}

?>