@echo off
call mvn clean package
call docker build -t com.rest/warehouse .
call docker rm -f warehouse
call docker run -d -p 9080:9080 -p 9443:9443 --name warehouse com.rest/warehouse