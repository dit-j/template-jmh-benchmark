call mvn clean package

if not exist "docs" mkdir "docs"

echo. 
echo ------------ START BENCHMARK ------------
echo.

java -Xmx1256M -Xms1256M -jar target/benchmarks.jar > docs/benchmark.txt

pause