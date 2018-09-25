package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserManager {
    private User currentUser = null;

    public boolean login(LoginCredential loginCredential, Collection<User> users){
        if(currentUser==null) {
            for (User user : users) {
                if (user.isAuthentic(loginCredential)) {
                    currentUser = user;
                    return true;
                }
            }
        }
        return false;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void logout(){
        currentUser = null;
    }

}
