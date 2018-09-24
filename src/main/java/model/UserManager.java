package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserManager {
    Collection<User> users;
    User currentUser = null;

    UserManager(Collection<User> users){
        this.users = users;
    }

    public boolean login(LoginCredential loginCredential){
        for(User user : users){
            if(user.isAuthentic(loginCredential)){
                currentUser = user;
                return true;
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
