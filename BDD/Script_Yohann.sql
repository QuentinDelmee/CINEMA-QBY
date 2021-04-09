

USE CINEMA_test;


CREATE TABLE salles
(
	id_salles int NOT NULL AUTO_INCREMENT,
	nom varchar(50),
	etage varchar(50),
	taille_ecran varchar(50),
	nombre_de_place int,
	PRIMARY KEY (id_salles),
);

CREATE TABLE films
(
	id_films int NOT NULL AUTO_INCREMENT,
	titre varchar(50),
	titre_original varchar(50),
	age_limite int,
	annee_sortie varchar(50),
	duree_totale time,
	genre varchar(50),
	note_moyenne decimal(6 2),
	description varchar(50),
	PRIMARY KEY (id_films),
);

CREATE TABLE date_Heure
(
	dates datetime,
);

CREATE TABLE places
(
	id_salles int,
	id_places int NOT NULL AUTO_INCREMENT,
	numero int,
	rang varchar(50),
	FOREIGN KEY (id_salles) REFERENCES (id_salles),
	PRIMARY KEY (id_places),
);


