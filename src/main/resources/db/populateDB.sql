DELETE FROM user_roles;
DELETE FROM RESTORANS_DISH;
DELETE FROM DISH;
DELETE FROM RESTORANS;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO DISH (NAME,PRICE)
VALUES ('Пельмени', 60),
       ('чай', 15),
       ('картофельное пюре', 20),
       ('Котлета', 35),
       ('шашлык', 250),
       ('салат цезарь', 60),
       ('салат зимний', 60),
       ('кофе', 25),
       ('борщ', 40);