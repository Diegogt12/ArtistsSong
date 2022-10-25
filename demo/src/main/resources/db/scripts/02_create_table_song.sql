create table songs(
	song_id varchar(50) primary key,
	title varchar(100) not null,
	fav bit ,
    artist_id varchar(10) not null,

	FOREIGN KEY (artist_id) REFERENCES artists(artist_id)

 );