
package model;


public class User {
    private String UserName;
    private String UserPassword;

    public User(String UserName, String UserPassword) {
        this.UserName = UserName;
        this.UserPassword = UserPassword;
    }

    public User() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    @Override
    public String toString() {
        return "User{" + "UserName=" + UserName + ", UserPassword=" + UserPassword + '}';
    }
    
}
