#!/usr/bin/env bash

./mvnw flyway:migrate -Dflyway.configFile=src/main/resources/flyway.properties