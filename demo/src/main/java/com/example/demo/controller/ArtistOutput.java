package com.example.demo.controller;

import com.example.demo.domain.Song;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ArtistOutput {
    @Id
    private String artistId;
    @NotBlank( message = "name is blank")
    @NotNull(message = "name is null")
    private String name;
    private List<Song> songs;

    public ArtistOutput(){}
    public ArtistOutput(String artistId, String name, List<Song> songs) {
        this.artistId = artistId;
        this.name = name;
        this.songs = songs;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
