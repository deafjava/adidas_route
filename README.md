## ?. Why `gradle`?


## ?. Instructions to run the microservices locally with `docker`

To run, your machine must have [__Java 8__](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html), [__docker__](https://docs.docker.com/install/) and [__git__](https://git-scm.com/downloads) installed

### ?.1 Create an isolated local network

Run the command: `docker network create --driver=bridge --subnet=192.168.3.0/24 --gateway=192.168.3.10 zaragoza_net`

### ?.2 Get the _routes_ microservice

* Get the project: `git clone git@github.com:deafjava/adidas_route.git`
* Go to the project root: `cd adidas_route/`
* Build the project and generate docker image: `./gradlew build docker`
* Run the microservice: `docker run -d --name adidas_routes --net=zaragoza_net --ip 192.168.3.20 -p 8081:8081 -t com.adidas/trip`
