package com.ionelmarcu.flatex.auth.service;

/**
 * Created by Marcu on 13/11/2016.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
