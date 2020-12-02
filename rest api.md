вывод голосов на дату:
get http://localhost:8080/restaurant/vote?date=2020-11-20

вывод всех ресторанов:
get http://localhost:8080/restaurant/

вывод ресторана:
get http://localhost:8080/id

вывод голосов за ресторан на дату:
get http://localhost:8080/restaurant/vote/id?date=2020-11-20

меню ресторана на дату:

get http://localhost:8080/restaurant/menu/100019?date=2020-11-20

голосование:

POST http://localhost:8080/restaurant/vote/
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{ "id": "", "userId" : 100000, "restaurantId" : 100019, "voteDate": "2020-12-01" }

Добавление еды:

POST http://localhost:8080/admin/dish
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

[{"id":"","name":"шашлык из баранины","price":280}]

Добавление ресторана:

POST http://localhost:8080/admin/restaurant
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

[{"id":"","name":"Новый ресторан"}]

добавление меню:

POST http://localhost:8080/admin/menu/100019
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

[{"id":100012,"name":"картофельное пюре","price":20},{"id":100013,"name":"Котлета","price":35},{"id":100014,"name":"шашлык","price":250},{"id":100015,"name":"салат цезарь","price":60}]

создание пользователя:

POST http://localhost:8080/user
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{"id":"","name":"новый Пользователь", "role": "USER"}

Список пользователей:

GET http://localhost:8080/user

пользователь:
GET http://localhost:8080/user/100000

удаление пользователя:
DELETE http://localhost:8080/user/100000