FROM jenkins/jenkins:lts


ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false -Djenkins.CLI.disabled=true"

USER root
RUN apt-get update && apt-get install -y dos2unix
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN dos2unix  /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

VOLUME /var/jenkins_home/init.groovy.d

USER jenkins
ADD harden-jenkins.groovy $JENKINS_HOME/init.groovy.d/harden-jenkins.groovy
ADD ldap.groovy $JENKINS_HOME/init.groovy.d/ldap.groovy
ADD theme.groovy $JENKINS_HOME/init.groovy.d/theme.groovy
