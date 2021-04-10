DROP DATABASE IF EXISTS CINEMA_test;

CREATE DATABASE IF NOT EXISTS CINEMA_test;
USE CINEMA_test;


CREATE TABLE IF NOT EXISTS seances (
	id_seance int NOT NULL AUTO_INCREMENT,
	id_salles int NOT NULL,
	id_films int NOT NULL,
	dates datetime,
	nbplacesrestantes int,
	PRIMARY KEY (id_seance)
	FOREIGN KEY (id_salles) REFERENCES salles(id_salles)
	FOREIGN KEY (id_films) REFERENCES films(id_films)
	FOREIGN KEY (dates) REFERENCES date_heure(id_date_heure)
);

CREATE TABLE IF NOT EXISTS avis (
	id_avis int NOT NULL AUTO_INCREMENT,
	id_salles int NOT NULL,
	id_users int NOT NULL,
	note int,
	proprete varchar(50),
	PRIMARY KEY (id_avis),
	FOREIGN KEY (id_salles) REFERENCES salles(id_salles),
	FOREIGN KEY (id_users) REFERENCES utilisateurs(id_users)
);

CREATE TABLE IF NOT EXISTS reservation (
	id_reservation int NOT NULL AUTO_INCREMENT,
	id_users int NOT NULL,
	id_salles int NOT NULL,
	id_places int NOT NULL,
	dates datetime,
	PRIMARY KEY (id_reservation),
	FOREIGN KEY (id_users) REFERENCES utilisateurs(id_users),
	FOREIGN KEY (id_salles) REFERENCES salles(id_salles),
	FOREIGN KEY (id_places) REFERENCES places(id_places),
	FOREIGN KEY (dates) REFERENCES date_heure(id_date_heure)
);

CREATE TABLE IF NOT EXISTS achat (
	id_achat int NOT NULL AUTO_INCREMENT,
	id_produits int NOT NULL,
	id_users int NOT NULL,
	id dates datetime,
	quantite int NOT NULL,
	PRIMARY KEY (id_achat),
	FOREIGN KEY (id_produits) REFERENCES produits(id_produits),
	FOREIGN KEY (id_users) REFERENCES utilisateurs(id_users),
	FOREIGN KEY (dates) REFERENCES date_heure(id_date_heure)
);

