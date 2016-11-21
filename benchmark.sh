#!/bin/bash
#
mvn clean package

#
mkdir -p docs

> docs/benchmark.log
#
java -Xmx1256M -Xms1256M -jar target/benchmarks.jar > docs/benchmark.log
