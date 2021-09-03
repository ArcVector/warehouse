#!/bin/sh
mvn clean package && docker build -t com.rest/warehouse .
docker rm -f warehouse || true && docker run -d -p 9080:9080 -p 9443:9443 --name warehouse com.rest/warehouse