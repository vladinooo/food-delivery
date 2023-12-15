FROM amazoncorretto:17
WORKDIR /opt
COPY target/*.jar /opt/restaurantlisting.jar
ENTRYPOINT exec java $JAVA_OPTS -jar restaurantlisting.jar
