# Adidas Coding Challenge

## Microservice Route

### Development

* Spring Boot
* Java 8
* Secured -  Basic HTTP Authentication
* Eureka Client and Registered to be discovered
* TestNG as Test Framework
* Used H2 with MySQL as database for demonstration

### Environment Variables

* `DB_URL` - full jdbc URL, such as `jdbc:<dbms>://<username>:<password>@<host>:<port>/<db_name>` - according to configuration you prepared
* `JDBC_DRIVER` - such as `com.mysql.jdbc.Driver`
* `FLYWAY_ENABLE` - accept `true` or `false` as values
* `LOG_LEVEL` - Verbosity of Logging level
* `SERVER_PORT`
* `SEC_USER` - username to secure the API
* `SEC_PW` - password to secure the API
* `URL_SPRING_CLOUD` - URL to the Eureka Server

See [application.yml](https://github.com/deafjava/adidas_route/blob/master/src/main/resources/application.yml)