FROM openjdk:11-jdk-slim
MAINTAINER Tom <xxx@qq.com>
VOLUME ["/tmp","/config"]

ADD metaq-service-monitor-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]