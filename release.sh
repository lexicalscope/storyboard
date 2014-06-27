#!/bin/bash

if [ $# -lt 2 ]; then
   echo 1>&2 "$0: not enough arguments"
   exit 2
fi

mvn versions:set -DnewVersion=$1
mvn versions:commit
git add pom.xml */pom.xml
git commit -m "release version $1"

mvn versions:set -DnewVersion=$2
mvn versions:commit
git add pom.xml */pom.xml
git commit -m "prepare for development"
