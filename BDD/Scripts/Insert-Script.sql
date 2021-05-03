DELETE FROM cinemas ;
DELETE FROM comments ;
DELETE FROM movies ;
DELETE FROM opinions ;
DELETE FROM persons ;
DELETE FROM products ;
DELETE FROM purchases ;
DELETE FROM reservations ;
DELETE FROM seats ;
DELETE FROM security_level ;
DELETE FROM sessions ;
DELETE FROM users ;


INSERT INTO movies (
	title,
	original_title,
	pegi,
	release_year,
	movie_duration,
	movie_genre,
	average_rating,
	movie_description
)
VALUES
('titre du film', 'titre original', '18', '2018','1:46:0','genre','4.0','description');

INSERT INTO persons(
    family_name,
    first_name,
    birthdate,
    genre,
    city,
    e_mail
)
VALUES
('Demon','8queues','1984-03-21','F', 'Nantes','Demon.QYB@outlook.fr');



INSERT INTO users(
    pseudo,
    pwd,
    id_person,
    id_sl
)
VALUES
('QYB','CHIENCHATOISEAU','')

INSERT INTO cinemas(
	id_cinema, #int NOT NULL AUTO_INCREMENT,
	room_name, #varchar(255) NOT NULL,
	room_level, #varchar(255) NOT NULL,
	screen_size, #varchar(255),
	seats_number #int,

)
VALUES
('10','','',)

INSERT INTO comments(
	id_movie,# int NOT NULL,
	id_user,# int NOT NULL,
	rating,# int NOT NULL,
	comment# TEXT NOT NULL,
)
VALUES
('',)

INSERT INTO opinions(
	id_cinema,# int NOT NULL,
	id_user,# int NOT NULL,
	rating,# int,
	cleanlyness# varchar(255),
)
VALUES
('',)

INSERT INTO products(

    id_product,# int NOT NULL AUTO_INCREMENT,
    product_name,# varchar (255) NOT NULL,
    price,# decimal (6,2) NOT NULL,
    category,# varchar (255) NOT NULL,
    product_description# text,
)
VALUES
('',)

INSERT INTO purchases(

	id_product,# int NOT NULL,
	id_user,# int NOT NULL,
	id_date,# datetime,
	quantity,# int NOT NULL,
	id_purchase# int,
)
VALUES
('',)

INSERT INTO reservations(
	id_user,# int NOT NULL,
	id_cinema,# int NOT NULL,
	id_seat,# int NOT NULL,
	id_date# datetime,
)
VALUES
('',)

INSERT INTO seats(
	id_seat,# int NOT NULL AUTO_INCREMENT,
	id_cinema,# int NOT NULL,
	seat_number,# int NOT NULL,
	row_name# varchar(255) NOT NULL,
)
VALUES
('',)


INSERT INTO security_level(
	id_sl,# int NOT NULL AUTO_INCREMENT,
    roles# varchar (255) NOT NULL,
)
VALUES
('',)


INSERT INTO sessions(
	id_cinema,# int NOT NULL,
	id_movie,# int NOT NULL,
	id_date,# datetime,
	seats_left# int NOT NULL,
)
VALUES
('',)

INSERT INTO users(
	id_user,# int NOT NULL AUTO_INCREMENT, 
    pseudo,# varchar (255) NOT NULL,
    pwd,# varchar (255) NOT NULL,
    id_person,# int NOT NULL,	
    id_sl#int,
)
VALUES
('',)