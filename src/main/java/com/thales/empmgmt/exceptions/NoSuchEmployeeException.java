package com.thales.empmgmt.exceptions;

public class NoSuchEmployeeException extends Exception{
    public static final String message = "employee not found";
    public NoSuchEmployeeException(String msg){
        super(msg);
    }
}
