Airline Ticketer

[![Build Status](https://api.travis-ci.org/mbogaz/airlineTicketing.svg?branch=master)](https://api.travis-ci.org/mbogaz/airlineTicketing.svg)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

or

from your terminal in root directory simply run :
```shell
mvn clean install
java -jar target/ticketer-0.0.1-SNAPSHOT.jar
```

swagger url: 

you can check all endpoints from this address
```http://localhost:8080/swagger-ui.html#/ ```


## Operations :

--adding Airline Company
```shell
curl -X POST "http://localhost:8080/company" -H "accept: */*" -H "Content-Type: application/json" -d 
"{
  "desc": "test company desc",
  "name": "test company"
}"
```
--search any entity

it returns pageable response, pageable params available at url, {key} value will be checked for name and desc fields.

entities : company, airport, route, ticket, flight
```shell
curl -X GET "http://localhost:8080/{entity}/search/{key}?direction=ASC&pageNo=0&pageSize=10&sortBy=id" -H "accept: */*"
```

--get an entity
```shell
curl -X GET "http://localhost:8080/{entity}/{id}" -H "accept: */*"
```

--delete an entity
```shell
curl -X DELETE "http://localhost:8080/{entity}/{id}" -H "accept: */*"
```

--update an entity
```shell
curl -X PUT "http://localhost:8080/{entity}/{id}" -H "accept: */*" -H "Content-Type: application/json" -d
"{entity json}"
```

--adding Airport 
```shell
curl -X POST "http://localhost:8080/airport" -H "accept: */*" -H "Content-Type: application/json" -d 
"{
    "city": "istanbul",
    "desc": "test airport desc",
    "name": "test airport"
}"
```

--adding route
```shell
curl -X POST "http://localhost:8080/route" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"desc\": \"test route desc\", \"fromAirportId\": 1, \"name\": \"test route\", \"toAirportId\": 2}
"{
   "desc": "test route desc",
   "fromAirportId": 1,
   "name": "test route",
   "toAirportId": 2
 }"
```

--adding flight to Airport Company
```shell
curl -X POST "http://localhost:8080/flight" -H "accept: */*" -H "Content-Type: application/json" -d 
"{
  "basePrice": 10,
  "capacity": 36,
  "companyId": 1,
  "dateStr": "20-02-2020",
  "desc": "test flight desc",
  "name": "test flight",
  "routeId": 2
}"
```

-search flight

there are already a pageable search endpoint for all of entities, but for flight there is anoher for searching by company
```shell
curl -X GET "http://localhost:8080/flight/company/1?direction=ASC&pageNo=0&pageSize=10&sortBy=id" -H "accept: */*"
```

--ask price for a flight
```shell
curl -X GET "http://localhost:8080/flight/1/price" -H "accept: */*"
```
it returns :
```shell
{
  "totalCapacity": 40,
  "currentCapacity": 40,
  "basePrice": 60,
  "currentPrice": 155.62
}
 ```

--get tickets for a flight
it again pageable
```shell
curl -X GET "http://localhost:8080/ticket/flight/1?direction=ASC&pageNo=0&pageSize=10&sortBy=id" -H "accept: */*"
 ```

--buy a ticket

because of there is no specific declaration, i did not ask price for buying ticket,
it uses last price(effected by fullness of flight) and this business logic inside a 
synchronised block, so system guaranties pricing wont broke under simultaneous requests 
```shell
curl -X POST "http://localhost:8080/ticket" -H "accept: */*" -H "Content-Type: application/json" -d 
"{
   "cardNumber": "1234,1234-1234;12 34",
   "flightId": 1,
   "name": "test ticket",
   "number": "1"
 }"
```
after this request, card number stores like this : "123412******1234"

--get ticket by ticket number
```shell
curl -X GET "http://localhost:8080/ticket/flight/1/number/a1" -H "accept: */*"
```

--delete ticket by ticket number
```shell
curl -X DELETE "http://localhost:8080/ticket/flight/1/number/a1" -H "accept: */*"
```
--- 
*every 10% ticket sold increases the price by 10%

*input card number removes non numeric characters and hides 6 digits

*hateoas for generic response implemented, for entity crud operations

*ci tool added, used https://api.travis-ci.org. You can check last commit's build status

*Spring Test added, just for entity repository, not much more, because not required :)

*swagger support, you can access from "/" path too, not need to ask swagger-ui.html

*i did not added user & authentication, it is not required too


