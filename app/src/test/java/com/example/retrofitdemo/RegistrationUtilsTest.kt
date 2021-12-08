package com.example.retrofitdemo

import com.example.retrofitdemo.Testing.Error
import com.example.retrofitdemo.Testing.RegistrationUtils
import org.junit.Assert.assertEquals
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertEquals(result, Error.USERNAME_OR_PASSWORD_IS_EMPTY)
    }

    @Test
    fun `valid username and correctly repeated password return true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Ali",
            "123",
            "123"
        )
        assertEquals(result, Error.SUCCESS)
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "123",
            "123"
        )
        assertEquals(result, Error.USERNAME_IS_ALREADY_TAKEN)
    }

    @Test
    fun `if password is empty return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "",
            ""
        )
        assertEquals(result, Error.USERNAME_OR_PASSWORD_IS_EMPTY)
    }

    @Test
    fun `password repeated incorrectly return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Ali",
            "123",
            "1234"
        )
        assertEquals(result, Error.CONFIRMED_PASSWORD_IS_NOT_THE_SAME_AS_THE_REAL_PASSWORD)
    }

    @Test
    fun `less that 2 digits password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Ali",
            "abcd2",
            "abcd2"
        )
        assertEquals(result, Error.PASSWORD_CONTAINS_LESS_THAN_2_DIGITS)
    }
}
