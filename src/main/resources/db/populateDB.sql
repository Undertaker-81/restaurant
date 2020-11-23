DELETE FROM MENU;
DELETE FROM DISH;
DELETE FROM VOTE;
DELETE FROM RESTAURANT;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, ROLE,password)
VALUES ('User1', 'user@yandex.ru', 'USER','password'),
       ('Admin', 'admin@gmail.com','ADMIN', 'admin'),
       ('Admin2', 'admin2@gmail.com', 'ADMIN', 'admin'),
       ('Admin3', 'admin3@gmail.com', 'ADMIN','admin'),
       ('User2', 'user2@yandex.ru', 'USER','password'),
       ('User3', 'user3@yandex.ru', 'USER','password'),
       ('User4', 'user4@yandex.ru', 'USER', 'password'),
       ('User5', 'user5@yandex.ru', 'USER','password'),
       ('User6', 'user6@yandex.ru', 'USER','password'),
       ('User7', 'user7@yandex.ru','USER',  'password');

INSERT INTO DISH (NAME, PRICE)
VALUES ('Пельмени', 60),
       ('чай', 15),
       ('картофельное пюре', 20),
       ('Котлета', 35),
       ('шашлык', 250),
       ('салат цезарь', 60),
       ('салат зимний', 60),
       ('кофе', 25),
       ('борщ', 40);

INSERT INTO RESTAURANT (NAME, USER_ID)
VALUES ('Сокол', 100001),
       ('Рога и копыта', 100002),
       ('Шашлык и пляски', 100003);

INSERT INTO MENU(DISH_ID, RESTAURANT_ID, MENU_DATE)
VALUES (100010, 100019, '2020-11-20'),
       (100013, 100019, '2020-11-20'),
       (100015, 100019, '2020-11-20'),
       (100017, 100019, '2020-11-20'),
       (100018, 100019, '2020-11-20'),
       (100018, 100020, '2020-11-20'),
       (100015, 100020, '2020-11-20'),
       (100010, 100020, '2020-11-20'),
       (100011, 100021, '2020-11-20'),
       (100013, 100021, '2020-11-20'),
       (100014, 100021, '2020-11-20');

INSERT INTO VOTE(USER_ID, RESTAURANT_ID, VOTE_DATE)
VALUES (100000, 100019, '2020-11-20'),
       (100004, 100019, '2020-11-20'),
       (100005, 100019, '2020-11-20'),
       (100006, 100019, '2020-11-20'),
       (100007, 100020, '2020-11-20'),
       (100008, 100020, '2020-11-20'),
       (100009, 100021, '2020-11-20'),
       (100000, 100021, '2020-11-21'),
       (100004, 100021, '2020-11-21'),
       (100005, 100021, '2020-11-21'),
       (100006, 100019, '2020-11-21'),
       (100007, 100019, '2020-11-21'),
       (100008, 100020, '2020-11-21');