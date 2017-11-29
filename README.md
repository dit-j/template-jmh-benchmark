# template-jmh-benchmark

JMH template project

## Beipiel Benchmarks in diesem Templateprojekt


### BoolArrayVsBitSetBenchmark

Performancevergleich zwischen ```boolean[]``` und ```java.util.BitSet```

Getestet werden:
* Setzen von boolean-Werten an bestimmen Stellen im Set
* Auslesen von boolen-Werten
* Berechnung der Kardinalität
* Zurücksetzen des Sets


### JacksonVsGsonBenchmark

Performancevergleich zwischen ```com.fasterxml.jackson``` und ```com.google.gson``` JsonParser

In diesem Test aus einem großen Json-String ein Java-Objekt erstellt (Deserialisiert)


### SumOverGlobalVsLocalVsStreamBenchmark

In diesem Test wird eine Summe aus einer Integer-Liste auf folgende drei Arten gebildet:
 * Für die Iteration wird globale (Instanz)Variable verwendet
 * Für die Iteration wird eine lokale Variable verwendet (mehr für Android von Bedeutung)
 * Summe wird mit Hilfe von Stream gebildet
 * Summe wird mit Hilfe von ParallelStream gebildet

z.B.

```java
public long sumLocal() {
    List<Integer> local = this.list;
    long sum = 0;
    for (int i = 0; i < local.size(); i++) {
        sum += local.get(i);
    }
    return sum;
}

public long sumGlobal() {
    long sum = 0;
    for (int i = 0; i < this.list.size(); i++) {
        sum += this.list.get(i);
    }
    return sum;
}

public long sumStream() {
    long sum = 0;
    for (int i = 0; i < this.list.size(); i++) {
        sum += this.list.get(i);
    }
    return sum;
}

public long sumParallelStream() {
    LongAdder a = new LongAdder();
    this.list.parallelStream().forEach(a::add);
    return a.longValue();
}
```

# Benchmark starten

Nach dem Kompilieren muss nur noch das Runnable-Jar ```target/benchmarks.jar``` über Konsole gestartet werden.

Oder nutze einen Startscript (siehe Root-Verzeichnis des Projekts)

1. ```mvn clean package```
2. ```java -Xmx1256M -Xms1256M -jar target/benchmarks.jar```

# Benchmark Resultat
```
Run complete. Total time: 00:05:04

Benchmark                                                   (length)   Mode  Cnt      Score      Error  Units
d.j.j.b.e.bool.BoolArrayVsBitSetBenchmark.bitset            10000000  thrpt    6  77669,792 ± 3196,014  ops/s
d.j.j.b.e.bool.BoolArrayVsBitSetBenchmark.primitive         10000000  thrpt    6    240,630 ±   42,550  ops/s
d.j.j.b.e.json.JacksonVsGsonBenchmark.gson                       N/A  thrpt    6    586,259 ±   87,790  ops/s
d.j.j.b.e.json.JacksonVsGsonBenchmark.jackson                    N/A  thrpt    6    780,863 ±  410,441  ops/s
d.j.j.b.e.sum.SumBenchmark.benchmark_OverGlobal                  N/A  thrpt    6  11424,401 ± 6568,256  ops/s
d.j.j.b.e.sum.SumBenchmark.benchmark_OverLocal                   N/A  thrpt    6  12512,645 ± 4699,326  ops/s
d.j.j.b.e.sum.SumBenchmark.benchmark_OverStream                  N/A  thrpt    6  10877,600 ± 1962,375  ops/s
d.j.j.b.e.sum.SumBenchmark.benchmark_OverStreamParallel          N/A  thrpt    6   1807,188 ±  197,855  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_A_1       N/A  thrpt    4    342,143 ±  161,046  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_A_2       N/A  thrpt    4    489,583 ±   46,133  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_A_3       N/A  thrpt    4    507,108 ±   38,143  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_A_4       N/A  thrpt    4    500,157 ±    8,919  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_B_1       N/A  thrpt    4    337,846 ±   73,079  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_B_2       N/A  thrpt    4    514,590 ±   16,642  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_B_3       N/A  thrpt    4    490,124 ±  102,165  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_B_4       N/A  thrpt    4    454,841 ±   28,688  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_C_1       N/A  thrpt    4    349,085 ±   22,884  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_C_2       N/A  thrpt    4    525,857 ±   66,625  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_C_3       N/A  thrpt    4    499,487 ±   10,346  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_C_4       N/A  thrpt    4    484,855 ±   32,619  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_D_1       N/A  thrpt    4    306,725 ±  125,430  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_D_2       N/A  thrpt    4    387,188 ±  114,605  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_D_3       N/A  thrpt    4    567,134 ±   20,601  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_D_4       N/A  thrpt    4    533,530 ±    8,119  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_E_1       N/A  thrpt    4    296,939 ±  438,647  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_E_2       N/A  thrpt    4    300,027 ±  447,246  ops/s
d.j.j.b.e.uniquechars.UniqueCharsBenchmark.uniqueChars_F         N/A  thrpt    4   3331,698 ±   91,609  ops/s


