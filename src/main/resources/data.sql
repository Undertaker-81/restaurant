//alter sequence global_seq restart with 1;

INSERT INTO users (name, email, ROLE, password)
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
VALUES ('Сокол', 1),
       ('Рога и копыта', 2),
       ('Шашлык и пляски', 3);

INSERT INTO MENU(DISH_ID, RESTAURANT_ID, DATE)
VALUES (11, 20, '2020-11-20'),
       (14, 20, '2020-11-20'),
       (16, 20, '2020-11-20'),
       (18, 20, '2020-11-20'),
       (19, 20, '2020-11-20'),
       (19, 21, '2020-11-20'),
       (16, 21, '2020-11-20'),
       (11, 21, '2020-11-20'),
       (12, 22, '2020-11-20'),
       (14, 22, '2020-11-20'),
       (15, 22, '2020-11-20');

INSERT INTO VOTE(USER_ID, RESTAURANT_ID, DATE)
VALUES (1, 20, '2020-11-20'),
       (5, 20, '2020-11-20'),
       (5, 20, '2020-11-20'),
       (7, 20, '2020-11-20'),
       (8, 21, '2020-11-20'),
       (9, 21, '2020-11-20'),
       (10, 22, '2020-11-20'),
       (1, 2, '2020-11-21'),
       (5, 2, '2020-11-21'),
       (6, 2, '2020-11-21'),
       (7, 20, '2020-11-21'),
       (8, 20, '2020-11-21'),
       (9, 21, '2020-11-21');