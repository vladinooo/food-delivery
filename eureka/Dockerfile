FROM amazoncorretto:17
WORKDIR /opt
COPY target/*.jar /opt/eureka.jar
ENTRYPOINT exec java $JAVA_OPTS -jar eureka.jar
