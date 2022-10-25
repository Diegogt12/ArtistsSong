package com.example.demo.controller;

import com.example.demo.domain.Artist;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArtistInput {

    @Id
    private String artistId;
    @NotBlank( message = "name is blank")
    @NotNull(message = "name is null")
    private String name;

    public ArtistInput(){}
    public ArtistInput(String artistId, String name) {
        this.artistId = artistId;
        this.name = name;
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

    public Artist toDomain() {
        Artist a = new Artist(this.artistId,this.name);
        return a;
    }
}

