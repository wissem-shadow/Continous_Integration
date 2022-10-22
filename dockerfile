FROM openjdk:8
EXPOSE 8080
ADD target/*.jar test-achat.jar 
ENTRYPOINT ["java","-jar","/test-achat.jar"]