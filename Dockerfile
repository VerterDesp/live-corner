FROM openjdk:11

COPY target/live-corner.jar live-corner.jar

CMD ["java","-jar","live-corner.jar"]