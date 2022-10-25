package com.example.demo.services;

import com.example.demo.controller.ArtistInput;
import com.example.demo.controller.ArtistOutput;
import com.example.demo.controller.SongInput;
import com.example.demo.domain.Artist;
import com.example.demo.domain.Song;
import com.example.demo.exceptions.ExceptionArtistAlreadyExist;
import com.example.demo.exceptions.ExceptionArtistDoesNotExist;
import com.example.demo.exceptions.ExceptionArtistsIsEmpty;
import com.example.demo.exceptions.ExceptionSongAlreadyExist;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    SongRepository songRepository;

    @Autowired
    ArtistRepository artistRepository;

    public void addArtist(ArtistInput artistInput) throws ExceptionArtistAlreadyExist {
        if (artistRepository.existsById(artistInput.getArtistId())) throw new ExceptionArtistAlreadyExist();
        Artist a = artistInput.toDomain();
        artistRepository.save(a);
    }

    public List<ArtistOutput> getAllArtist() throws ExceptionArtistsIsEmpty {
        List<Artist> artists = artistRepository.findAll();
        List<ArtistOutput> artistsOutputs = new ArrayList<>();

        for( Artist a: artists){
            ArtistOutput artistOutput = new ArtistOutput(a.getArtistId(),a.getName(), songRepository.findAllByArtistId(a.getArtistId()));
            artistsOutputs.add(artistOutput);
        }
        if(artistsOutputs.isEmpty()) throw new ExceptionArtistsIsEmpty();
        return artistsOutputs;
    }

    public void addSong(SongInput songInput) throws ExceptionSongAlreadyExist, ExceptionArtistDoesNotExist {
        if (songRepository.existsById(songInput.getSongId())) throw new ExceptionSongAlreadyExist();
        Song s = songInput.toDomain();
        if ( !artistRepository.existsById(songInput.getArtistId())) throw new ExceptionArtistDoesNotExist();
        songRepository.save(s);
    }
}
