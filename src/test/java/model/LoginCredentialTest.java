package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginCredentialTest {

    @DisplayName("Should return true for same objects")
    @Test
    void returnTrueForSameObject(){
        LoginCredential loginCredential = new LoginCredential("1234-123","password");
        assertTrue(loginCredential.equals(loginCredential));
    }

    @DisplayName("Should return false for null")
    @Test
    void returnFalseForNull(){
        LoginCredential loginCredential = new LoginCredential("1234-124","password");
        assertFalse(loginCredential.equals(null));
    }

    @DisplayName("Should return false for any other Object")
    @Test
    void returnFalseForOtherClasses(){
        LoginCredential loginCredential = new LoginCredential("1234-124","password");
        Object object = new Object();
        assertFalse(loginCredential.equals(object));
    }

    @DisplayName("Should return true for same id & password")
    @Test
    void returnTrueForEquals(){
        LoginCredential loginCredential = new LoginCredential("1234-123","password");
        Object object = new Object();
        assertTrue(loginCredential.equals(new LoginCredential("1234-123","password")));
    }

    @DisplayName("Should return false for different ids")
    @Test
    void returnFalseForDifferentIDs(){
        LoginCredential loginCredential = new LoginCredential("1234-124","password");
        assertFalse(loginCredential.equals(new LoginCredential("1234-123","password")));
    }

    @DisplayName("Should return false for different passwords")
    @Test
    void returnFalseForDifferentPasswords(){
        LoginCredential loginCredential = new LoginCredential("1234-124","password1");
        assertFalse(loginCredential.equals(new LoginCredential("1234-123","password")));
    }

}