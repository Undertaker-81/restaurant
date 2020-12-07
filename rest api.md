вывод голосов на дату:
get http://localhost:8080/restaurant/vote?date=2020-11-20
Authorization: Basic user2@yandex.ru password

вывод всех ресторанов:
get http://localhost:8080/restaurant/
Authorization: Basic user2@yandex.ru password

вывод ресторана:
get http://localhost:8080/id
Authorization: Basic user2@yandex.ru password

вывод голосов за ресторан на дату:
get http://localhost:8080/restaurant/vote/id?date=2020-11-20
Authorization: Basic user2@yandex.ru password

меню ресторана на дату:

get http://localhost:8080/restaurant/menu/100019?date=2020-11-20
Authorization: Basic user2@yandex.ru password
голосование:

POST http://localhost:8080/restaurant/vote/
Accept: */*
Cache-Control: no-cache
Content-Type: application/json
Authorization: Basic user2@yandex.ru password

{  "restaurantId" : 100019 }

Добавление еды:

POST http://localhost:8080/admin/dish
Accept: */*
Cache-Control: no-cache
Content-Type: application/json
Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu

{"id":"","name":"шашлык из баранины","price":280}

Добавление ресторана:

POST http://localhost:8080/admin/restaurant
Accept: */*
Cache-Control: no-cache
Content-Type: application/json
Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu

[{"id":"","name":"Новый ресторан"}]

добавление меню:

POST http://localhost:8080/admin/menu/100019
Accept: */*
Cache-Control: no-cache
Content-Type: application/json
Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu

[{"id":100012,"name":"картофельное пюре","price":20},{"id":100013,"name":"Котлета","price":35},{"id":100014,"name":"шашлык","price":250},{"id":100015,"name":"салат цезарь","price":60}]

создание пользователя:

POST http://localhost:8080/register
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{"name":"новый Пользователь", "role": "USER", "email": "newuser@mail.ru", "password": "derparol"}

Список пользователей:
Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu
GET http://localhost:8080/user

пользователь:
Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu
GET http://localhost:8080/user/100000

удаление пользователя:

Authorization: Basic YWRtaW5AZ21haWwuY29tOmFkbWlu
DELETE http://localhost:8080/user/100001

Логины для тестирования:
user@yandex.ru password
user2@yandex.ru password
user3@yandex.ru password
user4@yandex.ru password
user6@yandex.ru password
user7@yandex.ru password
admin@gmai.com
admin2@gmai.com
admin3@gmai.com
