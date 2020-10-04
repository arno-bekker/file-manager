## Description

This java spring-boot application exposes a REST interface on port 8080 and allows a client application to obtain the full
directory listing of a given path. The application can be run in a docker container or standalone.

## Getting Started

### Running the application using Docker

##### First build the application using maven

    $ mvn clean package

###### If maven is not installed locally, then using the provided wrapper

    $ ./mvnw clean package 

##### Running the application with Docker

    $ docker build -t file-manager:0.0.1 .

    $ docker run -d -p 8080:8080 -t file-manager:0.0.1

### Running standalone

    $ mvn clean spring-boot:run

###### Or
    $ mvn clean package
    $ java -jar target/admin-0.0.1-SNAPSHOT.jar


### Using the Rest endpoint

* http://localhost:8080/directory?path=/home/<username/tmp&size=0&page=0

* Use the size "parameter" to select the number of results to return. Size of 0 will return all entries in directory.

* Use the "page" parameter to navigate between pages.  

### Endpoint to check health status

* http://localhost:8081/actuator/health


### Notes:

##### Stopping the application 

    $ docker ps // Take note of the container id

    $ docker stop <CONTAINER ID>

##### Adding docker group to user, then docker can be run without sudo
    $ sudo usermod -aG docker $(whoami)

#### Fedora 32/31 using podman 
###### Fedora 32 and 31 uses cgroup v2 which is incompatible with Docker. Use podman instead of docker and the same commands as for docker, for example:

    $ sudo podman run -d -p 8080:8080 -t file-manager:0.0.1


