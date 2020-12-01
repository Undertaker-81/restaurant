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