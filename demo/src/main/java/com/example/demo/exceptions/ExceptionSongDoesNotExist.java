package com.example.demo.exceptions;

public class ExceptionSongDoesNotExist extends Exception{
    public ExceptionSongDoesNotExist() {
        super(  "Song does not exists" );
    }
}
