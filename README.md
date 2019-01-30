# template-jmh-benchmark

Simple JMH template project

# How to start

1. ```mvn clean package```
2. ```java -jar target/benchmarks.jar```

# Benchmark results

```
# Run complete. Total time: 00:00:24

Benchmark                  Mode  Cnt      Score      Error  Units
SimpleBenchmark.dec_all   thrpt   10  34561,455 ± 1971,310  ops/s
SimpleBenchmark.dec_half  thrpt   10  26678,700 ± 2426,754  ops/s

```

*dec_all* wins, cause more ops/s [operations per second]