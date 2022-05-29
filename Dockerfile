FROM openjdk:17
LABEL maintainner="springbootecomarket.mirea"
ADD build/libs/SpringBootEcomarket-0.0.1-SNAPSHOT.jar springboot-docker.jar
ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]