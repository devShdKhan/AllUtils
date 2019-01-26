package com.sdhkhan.everyutils

import java.util.regex.Pattern

class SHDValidation {

    companion object {
        private val EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                    + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                    + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                    + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                    + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$"
        )

        private val PASSWORD_PATTERN = Pattern
            .compile("^[a-zA-Z0-9+_.]*\${4,16}")

        private val MobilePattern = Pattern
            .compile("^[0-9+]{7,13}$")

        private val NumberPattern = Pattern
            .compile("^[0-9]*$")

        private val NAME_PATTERN = Pattern.compile("^[a-zA-Z ]*$")


        fun checkEmail(email: String): Boolean {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
        }

        fun checkName(name: String): Boolean {
            return NAME_PATTERN.matcher(name).matches()
        }

        fun checkPassword(password: String): Boolean {
            return PASSWORD_PATTERN.matcher(password).matches()
        }

        fun checkMobile(mobile: String): Boolean {
            return MobilePattern.matcher(mobile).matches()
        }

        fun checkNumber(number: String): Boolean {
            return NumberPattern.matcher(number).matches()
        }
    }


}
