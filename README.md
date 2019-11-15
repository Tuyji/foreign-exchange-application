# Foreing Exchange Application

Simple foreign exchange application used in financial applications.


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* [Spring Cloud](https://spring.io/projects/spring-cloud) - Distributed/versioned configuration & Service registration and discovery & Routing
* [Spring Cloud Netflix](https://cloud.spring.io/spring-cloud-netflix/reference/html/) - The patterns provided include Service Discovery (Eureka), Circuit Breaker (Hystrix), Intelligent Routing (Zuul) and Client Side Load Balancing (Ribbon).
* [H2 Database](https://www.h2database.com/) - Java SQL database -  in-memory database
* [git](https://git-scm.com/) - Free and Open-Source distributed version control system
* [Lombok](https://projectlombok.org/) - Java library that automatically plugs into your editor and build tools, spicing up your java.
* [Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)
* [JUnit5](https://junit.org/junit5/) - JUnit 5 is the next generation of JUnit. The goal is to create an up-to-date foundation for developer-side testing on the JVM
* [Mockito](https://site.mockito.org/) - Tasty mocking framework for unit tests in Java

## To-Do

- [ ] Central Logging



## Project Architecture


[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/FlowDiagram.png)]()

## Modules

- ### conversion-api
- ### exchange-rate-api
- ### fixer-api-client
- ### foreign-exchange-common
- ### foreign-exchange-eureka-server
- ### foreign-exchange-eureka-zuul




## Running the application locally


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

### Eureka Server

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/EurekaServer.PNG)]()


### H2 Database

#### Login

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/H2DatabaseLogin.PNG)]()


#### DB Interface

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/H2Database.PNG)]()


### Swagger UI


#### Exchange Rate API Swagger Documentation

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/SwaggerUI1.png)]()


#### Conversions API Swagger Documentation

[![INSERT YOUR GRAPHIC HERE](https://github.com/Tuyji/foreing-exchange-application/blob/master/images/SwaggerUI2.png)]()


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
 
