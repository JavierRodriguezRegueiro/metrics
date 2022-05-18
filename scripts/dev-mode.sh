#!/bin/bash
sed -i '' -e 's/#HOST#/localhost/g' ../src/main/resources/application.yml
sed -i '' -e 's/mongo-database/localhost/g' ../src/main/resources/application.yml
docker-compose up -d --no-deps --build mongo-database mongo-express