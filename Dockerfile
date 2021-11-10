FROM openjdk:8-jdk-alpine
COPY target/pica-historic-0.0.1-SNAPSHOT.jar pica-historic.jar
ENTRYPOINT ["java", "-jar", "pica-historic.jar"]