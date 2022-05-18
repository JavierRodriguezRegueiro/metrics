#!/bin/bash
sed -i '' -e 's/#HOST#/mongo-database/g' ../src/main/resources/application.yml
sed -i '' -e 's/localhost/mongo-database/g' ../src/main/resources/application.yml
docker-compose up