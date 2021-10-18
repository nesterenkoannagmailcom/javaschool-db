package org.example;

public class ZeroAuthProcessor implements AuthProcessor {

    @Override
    public String performLogin(String userName, String password) {
        return userName;
    }
}
