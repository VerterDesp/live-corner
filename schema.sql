CREATE TABLE IF NOT EXISTS animal (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    animal_class VARCHAR NOT NULL,
    animal_type VARCHAR NOT NULL,
    animal_warehouse VARCHAR NOT NULL
);