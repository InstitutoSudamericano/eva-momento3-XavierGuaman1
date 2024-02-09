CREATE TABLE IF NOT EXISTS film(
    id SERIAL,
    title VARCHAR (100),
    director VARCHAR (100),
    duration INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS scene(
    id SERIAL,
    description VARCHAR (200) NOT NULL,
    budget DECIMAL NOT NULL,
    minutes DECIMAL NOT NULL,
    film_id INT,
    FOREIGN KEY (film_id) REFERENCES film(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS characters(
    id SERIAL,
    description VARCHAR (200),
    cost DECIMAL (9,2),
    scene_id INT,
    FOREIGN KEY (scene_id) REFERENCES scene (id),
    PRIMARY KEY (id)
);