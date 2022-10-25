package com.example.demo.exceptions;

public class ExceptionArtistDoesNotExist extends Exception {
    public ExceptionArtistDoesNotExist() {
        super(  "Artist does not exists" );
    }
}