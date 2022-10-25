package com.example.demo.controller;


import com.example.demo.exceptions.ExceptionSongDoesNotExist;
import com.example.demo.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SongController {

    @Autowired
    SongService songService;



    @PostMapping("/{songId}/favorite")
    public ResponseEntity<String> markAsFavorite(@PathVariable String songId){
        try{
            songService.changeFavorite(songId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch ( ExceptionSongDoesNotExist e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
