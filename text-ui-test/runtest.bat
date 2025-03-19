@echo off
setlocal enableextensions
pushd %~dp0

cd ..
call gradlew clean shadowJar

cd build\libs
for /f "tokens=*" %%a in (
    'dir /b *.jar'
) do (
    set jarloc=%%a
)

java -jar %jarloc% < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test

FC ACTUAL.TXT EXPECTED.TXT >NUL
if %ERRORLEVEL% == 0 (
    echo Test passed!
) else (
    echo Test failed!
    echo Expected Output:
    type EXPECTED.TXT
    echo Actual Output:
    type ACTUAL.TXT
)
