FROM openjdk:11-jre-slim-buster

RUN apt-get install tzdata

ENV TZ America/Guayaquil

ADD build/libs/my-kiosk-api-1.2.0-SNAPSHOT.jar /usr/share/app.jar

ENTRYPOINT ["java", "-jar", "/usr/share/app.jar"]