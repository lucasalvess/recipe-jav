FROM tomcat:8.0-alpine

ADD target/recipe-java.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]