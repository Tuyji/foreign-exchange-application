# Foreing Exchange Application

Simple foreign exchange application used in financial applications.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [Spring Cloud](https://spring.io/projects/spring-cloud) - Distributed/versioned configuration & Service registration and discovery & Routing
* [H2 Database](https://www.h2database.com/) - Java SQL database -  in-memory database
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system
* [Lombok](https://projectlombok.org/) - Java library that automatically plugs into your editor and build tools, spicing up your java.
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## To-Do

- [ ] Central Logging


## Project Architecture

***INSERT ANOTHER GRAPHIC HERE***

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/FlowDiagram.png)]()

## Modules

### conversion-api
### exchange-rate-api
### fixer-api-client
### foreign-exchange-common
### foreign-exchange-eureka-server
### foreign-exchange-eureka-zuul


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

- Download the zip or clone the Git repository.
- Import Maven projects
- Running Order : run eureka-server -> run conversion-api & exchange-rate-api -> run eureka-zuul

### URLs

|  URL | Remark |
|----------|--------------|
|`http://localhost:8761`                       | Eureka Server |
|`http://localhost:8762`                       | Eureka Zuul |
|`http://localhost:8762/conversions`           | Conversion API |
|`http://localhost:8762/exchangerates` 		   | Exchange Rate API |
|`http://localhost:8762/swagger-ui.html`       | Swagger Documentation |
|`http://localhost:8300/h2`                    | H2 Database (Conversions API) |


## Sample Images & Documentation

### Eureka Server and Zuul Gateway

### Swagger UI


* [Postman Collection](https://documenter.getpostman.com/view/2449187/RWTiwzb2) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages
* [Postman Collection](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/blob/master/Spring%20Boot%20Template.postman_collection.json) - offline
* [Swagger](http://localhost:8088/swagger-ui.html) - Documentation & Testing


## packages

- `model` — entity holders;
- `repository` — database communication;
- `service` — business logic holder;
- `controller` — rest api implementations;
- `errorhandling` — custon error handling and exceptions;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties (server, proxy, url, database configrations) .

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies
 
