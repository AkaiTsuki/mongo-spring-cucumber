package me.msc.cucumber.features.spring;

/**
 * Created by jliu on 3/27/2015.
 */
public class CucumberUser {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "CucumberUser{" +
                "username='" + username + '\'' +
                '}';
    }
}
