CREATE TABLE personnes 
	(
		id_personnes int NOT NULL AUTO_INCREMENT,
		nom varchar (50),
		prenom varchar (50),
		date_de_naissance date,
		genre varchar (50),
		adresse varchar (250),
		e_mail varchar (50),
		PRIMARY KEY  (id_personnes)
	);


CREATE TABLE produits 
	(
		id_produits int NOT NULL AUTO_INCREMENT,
		prix decimal (6,2),
		categorie varchar (50),
		description text,
		PRIMARY KEY (id_produits)
		
	);


CREATE TABLE niveau_de_securite 
	(
		id_nds int NOT NULL AUTO_INCREMENT,
		roles varchar (50),
		PRIMARY KEY (id_nds)
	
	);

CREATE TABLE utilisateurs 
	(
		id_users int NOT NULL AUTO_INCREMENT , 
		pseudo varchar (50),
		mdp varchar (50),
		id_personnes int,	
		id_nds int,
		PRIMARY KEY (id_users),
		FOREIGN KEY (id_personnes) REFERENCES personnes(id_personnes),
		FOREIGN KEY (id_nds) REFERENCES niveau_de_securite(id_nds)
	);



