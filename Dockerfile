FROM openjdk:8

ARG JAR_FILE=target/file-manager-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} file-manager.jar

HEALTHCHECK --interval=1m --timeout=3s \
 CMD curl -f http://localhost:8081/actuator/health || exit 1

ENTRYPOINT ["java","-jar","file-manager.jar"]

