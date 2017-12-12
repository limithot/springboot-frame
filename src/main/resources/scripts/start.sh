JAR=
PROCESS=`ps -ef | grep java | grep $JAR | awk '{print $2}'`

if [ -n $PROCESS ]; then
    kill -9 `ps -ef | grep java | grep  $JAR | awk '{print $2}'`
fi

nohup java -jar $JAR > /dev/null 2>&1 &