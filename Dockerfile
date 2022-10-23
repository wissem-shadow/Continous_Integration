From openjdk:8
EXPOSE 8089
ADD target/achat-docker.jar achat-docker.jar
ENTRYPOINT ["java", "-jar", "/achat-docker.jar"]
