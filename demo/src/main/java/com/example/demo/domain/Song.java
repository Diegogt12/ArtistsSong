package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "songs")
public class Song {

    @Id
    private String songId;
    @NotBlank(message = "song title blank")
    @NotNull(message = "song is null")
    private String title;
    private boolean fav;
    @NotBlank( message = "artist id from song blank")
    @NotNull( message = "artist id from song null")
    private String artistId;


    public Song() {
    }

    public Song(String songId, String title, boolean fav, String artistId) {
        this.songId = songId;
        this.title = title;
        this.fav = fav;
        this.artistId = artistId;
    }

    public Song(String songId, String title, String artistId) {
        this.songId = songId;
        this.title = title;

        this.artistId = artistId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}
