DROP DATABASE IF EXISTS CINEMA_test;

CREATE DATABASE IF NOT EXISTS CINEMA_test;
USE CINEMA_test;


CREATE TABLE IF NOT EXISTS salles (
	id_salles int NOT NULL AUTO_INCREMENT,
	nom varchar(50),
	etage varchar(50),
	taille_ecran varchar(50),
	nombre_de_place int,
	PRIMARY KEY (id_salles)
);

CREATE TABLE IF NOT EXISTS films (
	id_films int NOT NULL AUTO_INCREMENT,
	titre varchar(50) NOT NULL,
	titre_original varchar(50),
	age_limite int,
	annee_sortie varchar(50),
	duree_totale time,
	genre varchar(50),
	note_moyenne decimal(6,2),
	description varchar(50) NOT NULL,
	PRIMARY KEY (id_films)
);

CREATE TABLE IF NOT EXISTS date_heure (
	id_date_heure int NOT NULL AUTO_INCREMENT,
	dates datetime,
	PRIMARY KEY (id_date_heure)
);

CREATE TABLE IF NOT EXISTS places (
	id_places int NOT NULL AUTO_INCREMENT,
	id_salles int,
	numero int,
	rang varchar(50),
	PRIMARY KEY (id_places),
	FOREIGN KEY (id_salles) REFERENCES salles(id_salles)
);


