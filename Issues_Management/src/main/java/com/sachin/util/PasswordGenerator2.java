package com.sachin.util;

import java.security.SecureRandom;

public class PasswordGenerator2 {
	
	private static final String PASSWORD="ABCDEFGHIJKLmnopqrstuvwxyz0123456789!@#$%^&*-+=";
    private static final int PASSWORDLENGTH=10;
    private static final SecureRandom secure=new SecureRandom();
    public static String generatePassword()
    {
        StringBuilder stringBuilder=new StringBuilder(PASSWORDLENGTH);
        for (int i=0;i<PASSWORDLENGTH;i++)
        {
            stringBuilder.append(PASSWORD.charAt(secure.nextInt(PASSWORD.length())));
        }
        return stringBuilder.toString();
    }

}


