FROM openjdk:11-jre-slim-buster

ADD build/libs/my-kiosk-api-0.0.1-SNAPSHOT.jar /usr/share/app.jar

ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]