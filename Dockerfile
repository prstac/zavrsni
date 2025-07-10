FROM openjdk:21-ea-1-slim
LABEL authors="joso"

EXPOSE 8989
ENTRYPOINT ["java", "-jar","/jar.jar"]