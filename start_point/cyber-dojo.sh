#! /bin/bash
set -e

cd ${CYBER_DOJO_SANDBOX}

CLASSES=.:`ls /junit/*.jar | tr '\n' ':'`

if javac -Xlint:preview -Xlint:unchecked -Xlint:deprecation -cp $CLASSES *.java; then
  java -jar /junit/junit-platform-console-standalone-1.10.1.jar \
      --disable-banner \
      --disable-ansi-colors \
      --details=tree \
      --details-theme=ascii \
      --class-path . \
      --scan-class-path
fi
