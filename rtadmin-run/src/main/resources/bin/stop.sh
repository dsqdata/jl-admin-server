#!/bin/sh
APP_NAME="rtadmin-run-2.4"

tpid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
if [[ ${tpid} ]]; then
    echo 'Stop Process...'
    kill -15 ${tpid}
else
     echo "error: ${APP_NAME} not found"
     exit 1
fi

sleep 5

tpid=`ps -ef|grep ${APP_NAME}|grep -v grep|grep -v kill|awk '{print $2}'`
if [[ ${tpid} ]]; then
    echo 'Kill Process!'
    kill -9 ${tpid}
else
    echo 'Stop Success!'
fi
