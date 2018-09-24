package model;

public class User {
    private final LoginCredential loginCredential;

    public User(LoginCredential loginCredential) {
        this.loginCredential = loginCredential;
    }

    boolean isAuthentic(LoginCredential loginCredential){
        return this.loginCredential.equals(loginCredential);
    }
}