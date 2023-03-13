DROP DATABASE IF EXISTS Formation;
CREATE DATABASE Formation;
USE Formation;



CREATE TABLE T_Category (
	idCategory int(4) PRIMARY KEY AUTO_INCREMENT,
	nameCategory VARCHAR(30) NOT NULL,
	descriptionCategory TEXT(150) NOT NULL
	
) ENGINE= InnoDB;

CREATE TABLE T_Formation (
	idFormation int(4) PRIMARY KEY AUTO_INCREMENT,
	nameFormation VARCHAR(30) NOT NULL,
	descriptionFormation TEXT(150) NOT NULL,
	durationFormation int(4) NOT NULL,
	statusFormation VARCHAR(30) NOT NULL,
	priceFormation FLOAT(8) NOT NULL,
	idCategory int(4) NOT NULL, 
	FOREIGN KEY(idCategory) REFERENCES T_Category(idCategory)
	
) ENGINE = InnoDB;

CREATE TABLE T_User(
	idUser int(4) PRIMARY KEY AUTO_INCREMENT,
	loginUser VARCHAR(30) NOT NULL,
	pswdUser VARCHAR(30) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE T_Basket(
	idBasket int(4) PRIMARY KEY AUTO_INCREMENT,
	amount FLOAT NOT NULL,
	dateOrder DATE NOT NULL DEFAULT CURRENT_TIMESTAMP() ,
	idCustomer int(4) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE T_Order_Formation(
	idOrderFormatin int(4) PRIMARY KEY AUTO_INCREMENT,
	idFormation int(4) NOT NULL,
	FOREIGN KEY(idFormation) REFERENCES T_Formation(idFormation),
	quantity FLOAT NOT NULL,
	unitaryPrice FLOAT NOT NULL,
	idBasket int(4) ,
	FOREIGN KEY (idBasket) REFERENCES T_Basket(idBasket)
) ENGINE = InnoDB;

INSERT INTO T_Category(nameCategory, descriptionCategory) VALUES('Developpement Web', 'Creation et développement de site internet');
INSERT INTO T_Category(nameCategory, descriptionCategory) VALUES('Web Design', 'Design de site internet');
INSERT INTO T_Category(nameCategory, descriptionCategory) VALUES('Sys Admin', 'Administration de systeme informatique');
INSERT INTO T_Category(nameCategory, descriptionCategory) VALUES('Bureautique', 'Utilisation des outils bureatique');


INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Java', 'Decouverte du langage Java', 20,'Présentiel', 1500, 1);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Java avancé', 'Approfondissement du langage Java', 50,'Présentiel', 2500, 1);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Figma', 'Utilisation de Figma ', 10,'Distanciel', 5500, 2);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Word', 'Utilisation de Word', 5,'Présentiel', 500, 4);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Excel', 'Utilisation d''Excel', 20,'Présentiel', 1200.54, 4);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Photohop', 'Les bases de photoshop ', 150,'Présentiel', 6500, 2);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Linux', 'Decouverte de Linux ', 20,'Distanciel', 1500, 3);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Spring', 'Utilisation du framework spring  ', 143,'Présentiel', 3500, 1);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('Console', 'Prise en main de notre console ', 10,'Distanciel', 300, 3);
INSERT INTO T_Formation (nameFormation, descriptionFormation, durationFormation, statusFormation, priceFormation, idCategory) VALUES ('ReactJs', 'Utilisation de ReactJs pour creer notre SPA', 250,'Présentiel', 7342.25, 1);


INSERT INTO T_USER(loginUser, pswdUser) VALUES ('ARaphael','fms2023');

