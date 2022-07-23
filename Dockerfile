FROM openjdk:8
ADD target/ElectricityBilling.jar ElectricityBilling.jar
ENTRYPOINT ["java", "-jar","ElectricityBilling.jar"]
EXPOSE 8080
