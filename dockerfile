FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/test-achat.jar test-achat.jar 
ENTRYPOINT ["java","-jar","/test-achat.jar"]