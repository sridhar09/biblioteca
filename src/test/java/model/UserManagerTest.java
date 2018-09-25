package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    User user1;
    User user2;
    User user3;
    User user4;

    LoginCredential loginCredential1;
    LoginCredential loginCredential2;
    LoginCredential loginCredential3;
    LoginCredential loginCredential4;
    LoginCredential wrongLoginCredential;
    List<User> users;

    UserManager userManager;

    @BeforeEach
    void init(){
        loginCredential1 = new LoginCredential("1","1");
        loginCredential2 = new LoginCredential("2","2");
        loginCredential3 = new LoginCredential("3","3");
        loginCredential4 = new LoginCredential("4","4");
        wrongLoginCredential = new LoginCredential("wrong","wrong");

        user1= new User(loginCredential1);
        user2= new User(loginCredential2);
        user3= new User(loginCredential3);
        user4= new User(loginCredential4);

        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        userManager = new UserManager();
    }
    @DisplayName("Return true for Correct Credentials")
    @Test
    void testForLoginTrue(){
        assertTrue(userManager.login(loginCredential1,users));
    }

    @DisplayName("Return false for Incorrect Credentials")
    @Test
    void testForLoginFalse(){
        assertFalse(userManager.login(wrongLoginCredential,users));
    }
}