DROP DATABASE IF EXISTS CINEMA_test;

CREATE DATABASE IF NOT EXISTS CINEMA_test;
USE CINEMA_test;


CREATE TABLE IF NOT EXISTS sessions (
	id_cinema int NOT NULL,
	id_film int NOT NULL,
	id_date datetime,
	seats_left int,
	PRIMARY KEY (id_cinema),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	PRIMARY KEY (id_film),
	FOREIGN KEY (id_film) REFERENCES films(id_film),
	PRIMARY KEY (id_date),
	FOREIGN KEY (id_date)
);

CREATE TABLE IF NOT EXISTS opinion (
	id_cinema int NOT NULL,
	id_user int NOT NULL,
	rating int,
	cleanlyness varchar(50),
	PRIMARY KEY (id_cinema),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	PRIMARY KEY (id_user),
	FOREIGN KEY (id_user) REFERENCES users(id_user)
);

CREATE TABLE IF NOT EXISTS reservation (
	id_user int NOT NULL,
	id_cinema int NOT NULL,
	id_seat int NOT NULL,
	id_date datetime,
	PRIMARY KEY (id_user),
	FOREIGN KEY (id_user) REFERENCES users(id_user),
	PRIMARY KEY (id_cinema),
	FOREIGN KEY (id_cinema) REFERENCES cinemas(id_cinema),
	PRIMARY KEY (id_seat),
	FOREIGN KEY (id_seat) REFERENCES seats(id_seat),
	PRIMARY KEY (id_date),
	FOREIGN KEY (id_date)
);

CREATE TABLE IF NOT EXISTS purchases (
	id_product int NOT NULL,
	id_user int NOT NULL,
	id_date datetime,
	quantity int NOT NULL,
	id_purchase int,
	PRIMARY KEY (id_product),
	FOREIGN KEY (id_product) REFERENCES products(id_product),
	PRIMARY KEY (id_user),
	FOREIGN KEY (id_user) REFERENCES users(id_user),
	PRIMARY KEY (id_date),
	FOREIGN KEY (id_date)
);

