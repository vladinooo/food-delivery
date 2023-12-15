FROM amazoncorretto:17
WORKDIR /opt
COPY target/*.jar /opt/foodcatalogue.jar
ENTRYPOINT exec java $JAVA_OPTS -jar foodcatalogue.jar
