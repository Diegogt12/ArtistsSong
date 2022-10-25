package com.example.demo.exceptions;

public class ExceptionArtistAlreadyExist extends Exception {
    public ExceptionArtistAlreadyExist() {
        super(  "Artist already exists" );
    }
}