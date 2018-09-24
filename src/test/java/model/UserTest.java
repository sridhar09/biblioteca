package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @DisplayName("should return true for correct login Credentials")
    @Test
    void TestIsAuthenticTrue(){
        LoginCredential loginCredential = new LoginCredential("1","1");
        User user = new User(loginCredential);
        assertTrue(user.isAuthentic(new LoginCredential("1","1")));
    }

    @DisplayName("should return false for incorrect login Credentials")
    @Test
    void TestIsAuthenticFalse(){
        LoginCredential loginCredential = new LoginCredential("1","1");
        User user = new User(loginCredential);
        assertFalse(user.isAuthentic(new LoginCredential("2","2")));
    }
}