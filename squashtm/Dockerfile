FROM openjdk:8

ADD https://www.squashtest.org/xsquash/telecharger-squash-tm-1-18/send/13-version-stable-tm/311-stm-1190-targz?lang=en squashtm.tar.gz
RUN tar xvfz squashtm.tar.gz --one-top-level=squashtm
RUN chmod +x /squashtm/squash-tm/bin/startup.sh

#RUN sed -i \
#    -e 's/^DB_TYPE.*$/DB_TYPE=postgresql/' \
#    -e 's/^DB_URL.*$/DB_URL=jdbc:postgresql:\/\/db:5432\/squashtm/' \
#    -e 's/^DB_USERNAME.*$/DB_USERNAME=squashtm/' \
#    -e 's/^DB_PASSWORD.*$/DB_PASSWORD=password/' \
#    /squashtm/squash-tm/bin/startup.sh

WORKDIR /squashtm/squash-tm/bin

ENTRYPOINT [ "/squashtm/squash-tm/bin/startup.sh"]

