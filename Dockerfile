FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN apk --no-cache add curl
RUN curl -u admin:admin -o achat-1.1.jar "http://192.168.33.10:8081/repository/maven-releases/tn/esprit/rh/achat/1.1/achat-1.1.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.1.jar"]