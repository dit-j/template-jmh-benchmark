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


1. ```mvn clean package```
2. ```java -Xmx1256M -Xms1256M -jar target/benchmarks.jar```

oder nutze einen Startscript (siehe Root-Verzeichnis des Projekts)
