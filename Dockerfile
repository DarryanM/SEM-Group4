FROM openjdk:latest
COPY ./target/SEM-Group4.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SEM-Group4.jar", "db:3306", "10000"]