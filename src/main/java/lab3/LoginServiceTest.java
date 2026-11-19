package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginServiceTest {

    private LoginService loginService;

    @BeforeEach
    void setUp() {
        loginService = new LoginService();
    }

    // null/empty test cases

    @Test
    void testEmptyUsername() {
        assertEquals("empty input", loginService.login("", "ValidPass1"));
    }

    @Test
    void testEmptyPassword() {
        assertEquals("empty input", loginService.login("admin1", ""));
    }

    @Test
    void testNullUsername() {
        assertEquals("empty input", loginService.login(null, "ValidPass1"));
    }

    @Test
    void testNullPassword() {
        assertEquals("empty input", loginService.login("admin1", null));
    }

    // boundary value analysis for username

    @Test
    void testUsernameBelowMinBoundary_3Chars() {
        assertEquals("invalid format", loginService.login("usr", "ValidPass1"));
    }

    @Test
    void testUsernameAtMinBoundary_4Chars() {
        assertEquals("Login successful", loginService.login("user", "Pass12"));
    }

    @Test
    void testUsernameAboveMinBoundary_5Chars() {
        assertEquals("Login successful", loginService.login("user1", "ValidPass1"));
    }

    @Test
    void testUsernameBelowMaxBoundary_19Chars() {
        assertEquals("Login successful", loginService.login("user123456789012345", "ValidPass1"));
    }

    @Test
    void testUsernameAtMaxBoundary_20Chars() {
        assertEquals("Login successful", loginService.login("user1234567890123456", "ValidPass1"));
    }

    @Test
    void testUsernameAboveMaxBoundary_21Chars() {
        assertEquals("invalid format", loginService.login("user12345678901234567", "ValidPass1"));
    }

    @Test
    void testUsernameWithSpecialCharacters() {
        assertEquals("invalid format", loginService.login("user_123", "ValidPass1"));
    }

    // boundary value analysis for password

    @Test
    void testPasswordBelowMinBoundary_5Chars() {
        assertEquals("invalid format", loginService.login("admin1", "Secr1"));
    }

    @Test
    void testPasswordAtMinBoundary_6Chars() {
        assertEquals("Login successful", loginService.login("admin1", "Secre1"));
    }

    @Test
    void testPasswordMissingUppercase() {
        assertEquals("invalid format", loginService.login("admin1", "secret1"));
    }

    @Test
    void testPasswordMissingDigit() {
        assertEquals("invalid format", loginService.login("admin1", "SecretPass"));
    }

    // testing authentication against stored records

    @Test
    void testUnregisteredUsername() {
        assertEquals("wrong credentials", loginService.login("unknownUser", "ValidPass1"));
    }

    @Test
    void testIncorrectPasswordForValidUser() {
        assertEquals("wrong credentials", loginService.login("admin1", "WrongPass1"));
    }

    @Test
    void testValidNominalLogin() {
        assertEquals("Login successful", loginService.login("admin1", "Secre1"));
    }
}
