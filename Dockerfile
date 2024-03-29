FROM amazoncorretto:17
CMD ["./gradlew","build"]

ARG JAR_FILE=./build/libs/comment-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]