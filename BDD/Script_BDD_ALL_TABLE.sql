DROP DATABASE IF EXISTS CINEMA_test;

CREATE DATABASE IF NOT EXISTS CINEMA_test;
USE CINEMA_test;

CREATE TABLE IF NOT EXISTS persons 
(
    id_person int NOT NULL AUTO_INCREMENT,
    family_name varchar (255),
    first_name varchar (255),
    birthdate date,
    genre varchar (255),
    city varchar (255),
    e_mail varchar (255),
    PRIMARY KEY  (id_person)
);

CREATE TABLE IF NOT EXISTS products 
(
    id_product int NOT NULL AUTO_INCREMENT,
    product_name varchar (255),
    price decimal (6,2),
    category varchar (255),
    product_description text,
    PRIMARY KEY (id_product)
);

CREATE TABLE IF NOT EXISTS security_level 
(
    id_sl int NOT NULL AUTO_INCREMENT,
    roles varchar (255),
    PRIMARY KEY (id_sl)

);

CREATE TABLE IF NOT EXISTS users 
(
    id_user int NOT NULL AUTO_INCREMENT , 
    pseudo varchar (255),
    pwd varchar (255),
    id_person int,	
    id_sl int,
    PRIMARY KEY (id_user),
    FOREIGN KEY (id_person) REFERENCES persons(id_person),
    FOREIGN KEY (id_sl) REFERENCES security_level(id_sl)
);

CREATE TABLE IF NOT EXISTS cinemas (
	id_cinema int NOT NULL AUTO_INCREMENT,
	room_name varchar(255),
	room_level varchar(255),
	screen_size varchar(255),
	seats_number int,
	PRIMARY KEY (id_cinema)
);

CREATE TABLE IF NOT EXISTS movies (
	id_movie int NOT NULL AUTO_INCREMENT,
	title varchar(255) NOT NULL,
	original_title varchar(255),
	pegi int,
	release_year int,
	movie_duration time,
	movie_genre varchar(255),
	average_rating decimal(6,2),
	movie_description TEXT NOT NULL,
	PRIMARY KEY (id_movie)
);

CREATE TABLE IF NOT EXISTS seats (
	id_seat int NOT NULL AUTO_INCREMENT,
	id_cinema int,
	seat_number int,
	row_name varchar(255),
	PRIMARY KEY (id_seat, id_cinema),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema)
);

CREATE TABLE IF NOT EXISTS sessions (
	id_cinema int NOT NULL,
	id_movie int NOT NULL,
	id_date datetime,
	seats_left int,
	PRIMARY KEY (id_cinema,id_movie,id_date),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	FOREIGN KEY (id_movie) REFERENCES movies(id_movie)
);

CREATE TABLE IF NOT EXISTS opinions (
	id_cinema int NOT NULL,
	id_user int NOT NULL,
	rating int,
	cleanlyness varchar(255),
	PRIMARY KEY (id_cinema,id_user),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE IF NOT EXISTS comments (
	id_movie int NOT NULL,
	id_user int NOT NULL,
	rating int,
	comment TEXT,
	PRIMARY KEY (id_movie,id_user),
	FOREIGN KEY (id_movie) REFERENCES movies(id_movie),
	FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE IF NOT EXISTS reservations (
	id_user int NOT NULL,
	id_cinema int NOT NULL,
	id_seat int NOT NULL,
	id_date datetime,
	PRIMARY KEY (id_user,id_cinema,id_seat,id_date),
	FOREIGN KEY (id_user) REFERENCES users(id_user),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	FOREIGN KEY (id_seat) REFERENCES seats(id_seat)
);

CREATE TABLE IF NOT EXISTS purchases (
	id_product int NOT NULL,
	id_user int NOT NULL,
	id_date datetime,
	quantity int NOT NULL,
	id_purchase int,
	PRIMARY KEY (id_product,id_user,id_date),
	FOREIGN KEY (id_product) REFERENCES products(id_product),
	FOREIGN KEY (id_user) REFERENCES users(id_user)
);