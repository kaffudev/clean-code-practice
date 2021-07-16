FROM openjdk:11-jdk
WORKDIR /opt/user-api
COPY target/*.jar appSpring.jar
ENTRYPOINT ["java","-jar","appSpring.jar"]