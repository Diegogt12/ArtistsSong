package com.example.demo.services;

import com.example.demo.domain.Song;
import com.example.demo.exceptions.ExceptionSongDoesNotExist;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    ArtistRepository artistRepository;


    public void changeFavorite(String songId) throws ExceptionSongDoesNotExist {
        if( !songRepository.existsById(songId) )throw new ExceptionSongDoesNotExist();
        Song s = songRepository.findById(songId).orElse(null);
        if(s.isFav() == true) s.setFav(false);
        else s.setFav(true);
        songRepository.save(s);

    }
}
