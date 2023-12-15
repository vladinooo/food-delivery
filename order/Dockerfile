FROM amazoncorretto:17
WORKDIR /opt
COPY target/*.jar /opt/order.jar
ENTRYPOINT exec java $JAVA_OPTS -jar order.jar
