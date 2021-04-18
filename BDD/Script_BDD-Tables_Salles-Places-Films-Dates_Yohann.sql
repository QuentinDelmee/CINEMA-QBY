DROP DATABASE IF EXISTS CINEMA_test;

CREATE DATABASE IF NOT EXISTS CINEMA_test;
USE CINEMA_test;


CREATE TABLE IF NOT EXISTS cinemas (
	id_cinema int NOT NULL AUTO_INCREMENT,
	room_name varchar(50),
	room_level varchar(50),
	screen_size varchar(50),
	seats_number int,
	PRIMARY KEY (id_salles)
);

CREATE TABLE IF NOT EXISTS movies (
	id_movie int NOT NULL AUTO_INCREMENT,
	title varchar(50) NOT NULL,
	original_title varchar(50),
	pegi int,
	release_year int,
	movie_duration time,
	movie_genre varchar(50),
	average_rating decimal(6,2),
	movie_description varchar(50) NOT NULL,
	PRIMARY KEY (id_films)
);

CREATE TABLE IF NOT EXISTS seats (
	id_seat int NOT NULL AUTO_INCREMENT,
	id_cinema int,
	seat_number int,
	row_name varchar(50),
	PRIMARY KEY (id_seat),
	PRIMARY KEY (id_cinema),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema)
);


