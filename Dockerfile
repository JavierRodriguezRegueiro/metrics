FROM openjdk:11
ADD target/metrics.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
