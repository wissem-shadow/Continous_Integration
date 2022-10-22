FROM openjdk:8
ADD target/test-achat.jar test-achat.jar 
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test-achat.jar"]