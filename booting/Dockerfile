#build maven jar
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY src /build/src
COPY pom.xml /build/pom.xml
RUN mvn clean package

#这句指定了基础镜像，使用的是轻量级的 Alpine Linux 版本，里面预装了 Eclipse Temurin JRE 21，也就是 Java 21 的运行环境（JRE），用于运行 Java 程序。
FROM eclipse-temurin:21-jre-alpine
COPY --from=builder /build/target/*.jar /opt/app.jar
CMD ["java", "-jar", "/opt/app.jar"]