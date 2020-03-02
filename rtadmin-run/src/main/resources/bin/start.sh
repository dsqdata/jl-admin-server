#!/bin/sh
APP_NAME="rtadmin-run-2.4"
JAVA_OPT="-Xms256m -Xmx512m -XX:PermSize=256m -XX:MaxPermSize=512m -XX:MaxNewSize=512m  -Dfile.encoding=UTF8 -Duser.timezone=GMT+08"

#has started
tpid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
if [[ ${tpid} ]]; then
    echo "error: ${APP_NAME} has started"
   exit 1
fi

rm -f tpid
nohup java ${JAVA_OPT} -jar "${APP_NAME}.jar"  > nohup.out 2>&1 &

echo $! > tpid
echo Start Success!
