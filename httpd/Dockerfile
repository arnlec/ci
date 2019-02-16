FROM httpd:2.4

EXPOSE 443

RUN sed -i \
    -e 's/^#\(LoadModule .*mod_vhost_alias.so\)/\1/' \
    -e 's/^#\(LoadModule .*mod_proxy.so\)/\1/' \
    -e 's/^#\(LoadModule .*mod_proxy_http.so\)/\1/' \
    -e 's/^#\(LoadModule .*mod_ssl.so\)/\1/' \
    -e 's/^#\(LoadModule .*mod_socache_shmcb.so\)/\1/' \
    -e 's/^#\(Include .*httpd-vhosts.conf\)/\1/' \
 #   -e 's/^#\(Include .*httpd-ssl.conf\)/\1/' \
    conf/httpd.conf

RUN mkdir -p ssl

ADD artifactory.forge.local.crt ssl/artifactory.forge.local.crt
ADD artifactory.forge.local.key ssl/artifactory.forge.local.key
RUN chmod 600 ssl/artifactory.forge.local.key

ADD db.forge.local.crt ssl/db.forge.local.crt
ADD db.forge.local.key ssl/db.forge.local.key
RUN chmod 600 ssl/db.forge.local.key

ADD gitlab.forge.local.crt ssl/gitlab.forge.local.crt
ADD gitlab.forge.local.key ssl/gitlab.forge.local.key
RUN chmod 600 ssl/gitlab.forge.local.key

ADD jenkins.forge.local.crt ssl/jenkins.forge.local.crt
ADD jenkins.forge.local.key ssl/jenkins.forge.local.key
RUN chmod 600 ssl/jenkins.forge.local.key

ADD redmine.forge.local.crt ssl/redmine.forge.local.crt
ADD redmine.forge.local.key ssl/redmine.forge.local.key
RUN chmod 600 ssl/redmine.forge.local.key

ADD sonarqube.forge.local.crt ssl/sonarqube.forge.local.crt
ADD sonarqube.forge.local.key ssl/sonarqube.forge.local.key
RUN chmod 600 ssl/sonarqube.forge.local.key

ADD squashtm.forge.local.crt ssl/squashtm.forge.local.crt
ADD squashtm.forge.local.key ssl/squashtm.forge.local.key
RUN chmod 600 ssl/squashtm.forge.local.key

ADD httpd-vhosts.conf conf/extra/httpd-vhosts.conf