DROP TABLE  IF  EXISTS vote;
DROP TABLE IF EXISTS menu ;
DROP TABLE  IF EXISTS dish;
DROP TABLE  IF EXISTS restaurant;
DROP TABLE IF EXISTS  users;


DROP SEQUENCE  IF EXISTS global_seq;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            ,
    password         VARCHAR(255)           ,
    role              VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON USERS (email);



CREATE TABLE dish
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR(255) NOT NULL,
    price       INTEGER NOT NULL

);

CREATE TABLE restaurant
(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR(255) NOT NULL,
    user_id     INTEGER      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);



CREATE TABLE vote
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id         integer not null,
    restaurant_id    integer not null,
    vote_date            TIMESTAMP DEFAULT now() NOT NULL
);

CREATE TABLE menu
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    dish_id         integer not null,
    restaurant_id     integer not null,
    menu_date            TIMESTAMP DEFAULT now() NOT NULL
);