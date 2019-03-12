FROM osixia/openldap

ENV VERSION 2
ENV LDAP_ORGANISATION="My Company"
ENV LDAP_DOMAIN="example.com"
ENV LDAP_ADMIN_PASSWORD="password"

ADD auth.ldif /container/service/slapd/assets/config/bootstrap/ldif/custom/auth.ldif
