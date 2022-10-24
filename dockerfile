FROM openjdk:8-alpine
EXPOSE 8089
ADD ./target/test-achat.jar test-achat.jar 
ENTRYPOINT ["java","-jar","/test-achat.jar"]
