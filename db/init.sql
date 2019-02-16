CREATE DATABASE sonar;
CREATE USER sonar with encrypted password 'password';
GRANT ALL privileges ON DATABASE sonar to sonar;

CREATE DATABASE gitlabhq_production;
CREATE USER gitlab with encrypted password 'password';
GRANT ALL privileges ON DATABASE gitlabhq_production to gitlab;

CREATE USER artifactory with encrypted password 'password';
CREATE DATABASE artifactory WITH OWNER=artifactory ENCODING='UTF-8';
GRANT ALL privileges ON DATABASE artifactory to artifactory;


CREATE USER redmine with encrypted password 'password';
CREATE DATABASE redmine WITH OWNER=redmine ENCODING='UTF-8';
GRANT ALL privileges ON DATABASE redmine to redmine;

CREATE USER squashtm with encrypted password 'password';
CREATE DATABASE squashtm WITH OWNER=squashtm ENCODING='UTF-8';
GRANT ALL privileges ON DATABASE squashtm to squashtm;

\connect gitlabhq_production
CREATE EXTENSION pg_trgm;

