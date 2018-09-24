package model;

import java.util.Objects;

public class LoginCredential {
    private final String libraryNumber;
    private final String password;

    public LoginCredential(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LoginCredential loginCredential = (LoginCredential) object;
        return Objects.equals(libraryNumber, loginCredential.libraryNumber) &&
                Objects.equals(password, loginCredential.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
