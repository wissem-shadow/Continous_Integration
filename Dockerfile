FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o achat-1.4.jar "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.4/achat-1.4.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.4.jar"]