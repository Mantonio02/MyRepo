FROM gradle:8-jdk21

WORKDIR /home/gradle

COPY settings.gradle.kts/ gradlew/ build.gradle.kts/ ./
COPY src src
COPY gradle gradle

RUN gradle bootJar
RUN mv build/libs/MyProject-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
