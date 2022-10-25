package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "artists")
public class Artist {

    @Id
    private String artistId;
    @NotBlank( message = "name is blank")
    @NotNull(message = "name is null")
    private String name;

    public Artist(){}
    public Artist(String artistId, String name) {
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
}
