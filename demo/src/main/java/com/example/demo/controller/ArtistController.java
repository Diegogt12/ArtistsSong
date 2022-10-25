package com.example.demo.controller;

import com.example.demo.exceptions.ExceptionArtistAlreadyExist;
import com.example.demo.exceptions.ExceptionArtistDoesNotExist;
import com.example.demo.exceptions.ExceptionArtistsIsEmpty;
import com.example.demo.exceptions.ExceptionSongAlreadyExist;
import com.example.demo.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ArtistController {

    @Autowired
    ArtistService artistService;


    @PostMapping("/artists")
    public ResponseEntity<String> addArtist(@Valid @RequestBody ArtistInput artistInput) {
        try {
            artistService.addArtist(artistInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ExceptionArtistAlreadyExist e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/artist/songs")
    public ResponseEntity<String> addSong(@Valid @RequestBody SongInput songInput) {
        try {
            artistService.addSong(songInput);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ExceptionSongAlreadyExist e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch(ExceptionArtistDoesNotExist e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistOutput>> getAllArtists(){

        try {
            List<ArtistOutput> artistsOutput = artistService.getAllArtist();
            return ResponseEntity.ok(artistsOutput);
        } catch (ExceptionArtistsIsEmpty e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }
}
