FROM openjdk:8
ADD target/electricitybilling.jar electricitybilling.jar
ENTRYPOINT ["java", "-jar","electricitybilling.jar"]
EXPOSE 8080
