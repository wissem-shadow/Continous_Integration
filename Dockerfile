FROM openjdk:8-jdk-alpine
EXPOSE 8083
RUN apk --no-cache add curl
RUN curl -u admin:nexus -o achat-1.1.jar "http://192.168.33.10:8081/#browse/browse:maven-releases:tn%2Fesprit%2Frh%2Fachat%2F1.1%2Fachat-1.1.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.1.jar"]