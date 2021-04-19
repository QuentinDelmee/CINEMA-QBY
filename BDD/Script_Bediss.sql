CREATE TABLE persons 
	(
		id_person int NOT NULL AUTO_INCREMENT,
		family_name varchar (50),
		first_name varchar (50),
		birthdate date,
		genre varchar (50),
		city varchar (50),
		e_mail varchar (50),
		PRIMARY KEY  (id_person)
	);


CREATE TABLE products 
	(
		id_product int NOT NULL AUTO_INCREMENT,
		product_name varchar (50),
		price decimal (6,2),
		category varchar (50),
		product_description text,
		PRIMARY KEY (id_product)
	);


CREATE TABLE security_level 
	(
		id_sl int NOT NULL AUTO_INCREMENT,
		roles varchar (50),
		PRIMARY KEY (id_sl)
	
	);

CREATE TABLE users 
	(
		id_user int NOT NULL AUTO_INCREMENT , 
		pseudo varchar (50),
		pwd varchar (50),
		id_person int,	
		id_sl int,
		PRIMARY KEY (id_user),
		FOREIGN KEY (id_person) REFERENCES persons(id_person),
		FOREIGN KEY (id_sl) REFERENCES security_level(id_sl)
	);



