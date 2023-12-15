FROM amazoncorretto:17
WORKDIR /opt
COPY target/*.jar /opt/user.jar
ENTRYPOINT exec java $JAVA_OPTS -jar user.jar
