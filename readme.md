# Continuous integration stack demo

## Getting started
Generate certificates

    ansible-playbook -i hosts certificate.yml

Start docker container

    docker-compose up -d --build