FROM tomcat:9.0
MAINTAINER Spurthi

# fixed path for copying
RUN /bin/bash -c "rm -rf /usr/local/tomcat/webapps"
RUN /bin/bash -c "mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps"
ADD ./target/kafka-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/

# Routine for me - optional for your case
EXPOSE 8080

# And run tomcat
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
