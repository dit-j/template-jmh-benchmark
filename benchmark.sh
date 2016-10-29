#!/bin/bash
#
mvn clean package

#
mkdir -p docs

#
java -Xmx1256M -Xms1256M -jar target/benchmarks.jar > docs/benchmark.log
