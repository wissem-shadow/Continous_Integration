From openjdk:8
EXPOSE 8080
ADD target/achat-docker.jar achat-docker.jar
ENTRYPOINT ["java", "-jar", "/achat-docker.jar"]
