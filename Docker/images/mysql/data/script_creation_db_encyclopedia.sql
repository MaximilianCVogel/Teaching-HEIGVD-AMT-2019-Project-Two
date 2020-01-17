CREATE DATABASE IF NOT EXISTS encyclopedia_amt CHARACTER SET utf8 COLLATE utf8_general_ci;

USE encyclopedia_amt;

CREATE TABLE IF NOT EXISTS beer_entity
( 
    beer_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL, 
    type VARCHAR(255) NOT NULL,
    alcohol INT NOT NULL DEFAULT 0,
    PRIMARY KEY (beer_id)
) CHARACTER SET=utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bar_entity
(
    bar_id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL, 
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (bar_id)
) CHARACTER SET=utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS bar_serving_beer
(
    bar_id BIGINT NOT NULL,
    beer_id BIGINT NOT NULL, 
    CONSTRAINT bar_serving_beer_bar foreign key (bar_id) references bar_entity(bar_id), 
    CONSTRAINT bar_serving_beer_beer foreign key (beer_id) references beer_entity(beer_id)
) CHARACTER SET=utf8 COLLATE utf8_general_ci;


INSERT INTO beer_entity(`name`, `type`, `alcohol`) VALUES
('Chouffe','blonde', 5), ('Trappiste','brune', 7), ('Punk IPA','ipa', 9);

INSERT INTO bar_entity(`name`, `address`) VALUES
('Brasserie Machin-truc','Rue de la bière 5, Belgique'), ('Aachener Braeuerei','Hauptstrasse 32, Berlin'), ('Modern Brewzkies','Dope street 38, England');

INSERT INTO bar_serving_beer(`bar_id`, `beer_id`) VALUES
(1, 1), (1, 2), (2, 2), (2, 3), (3, 3), (3, 1);
