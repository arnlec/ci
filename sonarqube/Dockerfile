FROM sonarqube:6.7-community

USER root
ADD https://binaries.sonarsource.com/Distribution/sonar-ldap-plugin/sonar-ldap-plugin-2.2.0.608.jar /opt/sonarqube/extensions/plugins/
RUN chown sonarqube:sonarqube  /opt/sonarqube/extensions/plugins/sonar-ldap-plugin-2.2.0.608.jar
USER sonarqube
ADD ldap.properties /tmp/ldap.properties
RUN cat /tmp/ldap.properties >> /opt/sonarqube/conf/sonar.properties

