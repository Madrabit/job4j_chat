DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS message;

CREATE TABLE room
(
    id   serial primary key,
    roomName varchar(2000) NOT NULL
);

CREATE TABLE person
(
    id   serial primary key,
    name varchar(2000) NOT NULL
);

CREATE TABLE role
(
    id   serial primary key,
    roomName varchar(2000) NOT NULL
);

CREATE TABLE message
(
    id   serial primary key,
    text varchar(2000) NOT NULL
);
--
-- CREATE TABLE accident
-- (
--     id               serial primary key,
--     name             varchar(2000),
--     description      varchar(2000),
--     address          varchar(2000),
--     accident_type_id INTEGER REFERENCES accident_type
--
-- );
