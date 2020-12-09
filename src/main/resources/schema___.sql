DROP TABLE  IF  EXISTS vote;
DROP TABLE IF EXISTS menu ;
DROP TABLE  IF EXISTS dish;
DROP TABLE  IF EXISTS restaurant;
DROP TABLE IF EXISTS  users;


DROP SEQUENCE  IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE users
(
    id               INT  default global_seq.nextval primary key auto_increment,
    name             VARCHAR(255)            NOT NULL,
    email            VARCHAR(255)            NOT NULL ,
    password         VARCHAR(255)           NOT NULL ,
    role              VARCHAR(255)            NOT NULL,
    registered       TIMESTAMP DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
    ON USERS (email);



CREATE TABLE dish
(
    id          INT  default global_seq.nextval,
    name        VARCHAR(255) NOT NULL,
    price       INTEGER NOT NULL

);

CREATE TABLE restaurant
(
    id          INT  default global_seq.nextval,
    name        VARCHAR(255) NOT NULL,
    user_id     INTEGER      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);



CREATE TABLE vote
(
    id              INT  default global_seq.nextval,
    user_id         integer not null,
    restaurant_id    integer not null,
    date            TIMESTAMP DEFAULT now() NOT NULL
);
//create table test3(id bigint default group_seq.nextval primary key);
CREATE TABLE menu
(
    id             INT  default global_seq.nextval,
    dish_id         integer not null,
    restaurant_id     integer not null,
    date            TIMESTAMP DEFAULT now() NOT NULL
);