#!/bin/bash
set +x
cd /tmp
ls juddi-distro-3.3.7 || { wget http://archive.apache.org/dist/juddi/juddi/3.3.7/juddi-distro-3.3.7.zip ; unzip juddi-distro-3.3.7.zip ; }
cd juddi-distro-3.3.7
JAVA_OPTS=-Djavax.xml.accessExternalDTD=all juddi-tomcat-3.3.7/bin/startup.sh

sleep 5

echo "JUDDI is ready"