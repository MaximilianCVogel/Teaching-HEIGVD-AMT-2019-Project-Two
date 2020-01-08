CREATE DATABASE IF NOT EXISTS encyclopedia_amt CHARACTER SET utf8 COLLATE utf8_general_ci;

USE encyclopedia_amt;

CREATE TABLE IF NOT EXISTS beers
( 
    name VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL, 
    type VARCHAR(255) NOT NULL,
    alcohol INT NOT NULL DEFAULT 0
) CHARACTER SET=utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS companies
( 
    name VARCHAR(255) PRIMARY KEY UNIQUE NOT NULL, 
    address VARCHAR(255) NOT NULL
) CHARACTER SET=utf8 COLLATE utf8_general_ci;

INSERT INTO beers(`name`, `type`, `alcohol`) VALUES
('Chouffe','blonde', 5), ('Trappiste','brune', 7), ('Punk IPA','ipa', 9);

INSERT INTO companies(`name`, `address`) VALUES
('Brasserie Machin-truc','Rue de la bière 5, Belgique'), ('Aachener Braeuerei','Hauptstrasse 32, Berlin'), ('Modern Brewzkies','Dope street 38, England');
