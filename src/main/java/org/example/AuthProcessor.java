package org.example;

public interface AuthProcessor {
    String performLogin(String userName, String password) throws Exception;
}
