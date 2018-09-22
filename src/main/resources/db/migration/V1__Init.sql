CREATE TABLE country (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    iso_code CHAR(2) NOT NULL UNIQUE
);

CREATE TABLE state (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    iso_code VARCHAR(2) NOT NULL,
    country_id INT UNSIGNED NOT NULL,
    CONSTRAINT cs_fk
    FOREIGN KEY(country_id)
    REFERENCES country(id)
);


CREATE TABLE city (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    gmt TINYINT NOT NULL,
    state_id INT UNSIGNED NOT NULL,
    iata CHAR(3) NOT NULL UNIQUE,
    CONSTRAINT sc_fk
    FOREIGN KEY(state_id)
    REFERENCES state(id)
);

CREATE TABLE route (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    origin_city_id INT UNSIGNED NOT NULL,
    destiny_city_id INT UNSIGNED NOT NULL,
    departure_time TIME NOT NULL,
    arrival_time TIME NOT NULL,
    CONSTRAINT roc_fk
    FOREIGN KEY(origin_city_id)
    REFERENCES city(id),
    CONSTRAINT rdc_fk
    FOREIGN KEY(destiny_city_id)
    REFERENCES city(id)
);

CREATE TABLE connections (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    full_route_id INT UNSIGNED NOT NULL,
    connection_route_id INT UNSIGNED NOT NULL,
    CONSTRAINT cfr_fk
    FOREIGN KEY(full_route_id)
    REFERENCES route(id),
    CONSTRAINT ccr_fk
    FOREIGN KEY(connection_route_id)
    REFERENCES route(id)
);