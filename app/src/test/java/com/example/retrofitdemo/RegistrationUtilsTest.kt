package com.example.retrofitdemo

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
        assertEquals(result, false)
    }

    @Test
    fun `valid username and correctly repeated password return true`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Ali",
            "123",
            "123"
        )
        assertEquals(result, true)
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "123",
            "123"
        )
        assertEquals(result, false)
    }

    @Test
    fun `if password is empty return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "",
            ""
        )
        assertEquals(result, false)
    }

    @Test
    fun `password repeated incorrectly return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "123",
            "1234"
        )
        assertEquals(result, false)
    }

    @Test
    fun `less that 2 digits password return false`() {
        val result = RegistrationUtils.validateRegistrationInput(
            "Peter",
            "abcd2",
            "abcd2"
        )
        assertEquals(result, false)
    }
}
