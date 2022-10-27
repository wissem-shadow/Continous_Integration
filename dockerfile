FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/achat-1.0.jar test-achat.jar 
ENTRYPOINT ["java","-jar","/test-achat.jar"]
