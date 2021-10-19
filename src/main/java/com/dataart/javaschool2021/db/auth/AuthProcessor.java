package com.dataart.javaschool2021.db.auth;

public interface AuthProcessor {
    String performLogin(String userName, String password) throws Exception;
}
