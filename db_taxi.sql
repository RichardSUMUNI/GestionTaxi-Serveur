-- Projet Gestion Taxi
-- Structure de la base de donn�es

CREATE DATABASE db_taxi;

USE db_taxi;

CREATE TABLE Taxi (
	id INT PRIMARY KEY AUTO_INCREMENT,
	numeroTaxi VARCHAR(10) NOT NULL,
	modeleVoiture VARCHAR(255) NOT NULL,
	adresse VARCHAR(255) NOT NULL,
	ville VARCHAR(255) NOT NULL,
	pays VARCHAR(255) NOT NULL DEFAULT 'RD Congo') ENGINE = InnoDB;

INSERT INTO Taxi (numeroTaxi, modeleVoiture, adresse, ville, pays) VALUES ("0001", "Toyota Carina", "1024 Ave Maman Yemo", "Lubumbashi", "RD Congo");
INSERT INTO Taxi (numeroTaxi, modeleVoiture, adresse, ville, pays) VALUES ("0002", "Toyota RAUM", "13eme Limete", "Kinshasa", "RD Congo");
INSERT INTO Taxi (numeroTaxi, modeleVoiture, adresse, ville, pays) VALUES ("0003", "Nissan x02", "10 Ave Du 30 Juin", "Kolwezi", "RD Congo");