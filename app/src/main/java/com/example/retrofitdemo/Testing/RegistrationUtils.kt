package com.example.retrofitdemo.Testing

object RegistrationUtils {

    private val existingUsers = listOf("Peter", "Carl")

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password contains less than 2 digits
     */
    fun validateRegistrationInput(
        username: String,
        password: String,
        confirmedPassword: String
    ): Error {
        if (username.isEmpty() || password.isEmpty()) {
            return Error.USERNAME_OR_PASSWORD_IS_EMPTY
        } else if (username in existingUsers) {
            return Error.USERNAME_IS_ALREADY_TAKEN
        } else if (password != confirmedPassword) {
            return Error.CONFIRMED_PASSWORD_IS_NOT_THE_SAME_AS_THE_REAL_PASSWORD
        } else if (password.count { it.isDigit() } < 2) {
            return Error.PASSWORD_CONTAINS_LESS_THAN_2_DIGITS
        }
        return Error.SUCCESS
    }
}
