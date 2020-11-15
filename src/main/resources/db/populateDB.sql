DELETE FROM RESTORANS_DISH;
DELETE FROM RESTORANS_USERS;
DELETE FROM DISH;
DELETE FROM RESTORANS;
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

INSERT INTO RESTORANS (NAME, USER_ID)
VALUES ('Сокол', 100001),
       ('Рога и копыта', 100002),
       ('Шашлык и пляски', 100003);

INSERT INTO RESTORANS_DISH (DISH_ID, RESTORAN_ID)
VALUES (100010, 100019),
       (100011, 100019),
       (100016, 100019),
       (100017, 100019),
       (100018, 100019),
       (100018, 100020),
       (100010, 100020),
       (100011, 100020),
       (100014, 100020),
       (100015, 100020),
       (100016, 100020),
       (100010, 100021),
       (100017, 100021),
       (100014, 100021),
       (100015, 100021),
       (100018, 100021),
       (100012, 100021);

INSERT INTO RESTORANS_USERS (USER_ID, RESTORAN_ID)
VALUES (100000, 100019),
       (100004, 100019),
       (100005, 100019),
       (100006, 100019),
       (100007, 100020),
       (100008, 100020),
       (100009, 100021);