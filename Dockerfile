FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENV DB_URL jdbc:h2:mem:test;MODE=MySQL;DB_CLOSE_ON_EXIT=FALSE
ENV JDBC_DRIVER org.h2.Driver
ENV FLYWAY_ENABLE true
ENV CORS_URL http://192.168.3.12:8082/
ENV LOG_LEVEL INFO
ENV SERVER_PORT 8081
ENV SEC_USER admin
ENV SEC_PW adidas!
ENV URL_SPRING_CLOUD http://192.168.3.15:8088/eureka

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]