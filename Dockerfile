FROM openjdk:8
ADD target/achat-1.0.jar achat-1.0.jar
EXPOSE 9090
ENTRYPOINT [ "java", "-jar", "achat-1.0.jar" ]