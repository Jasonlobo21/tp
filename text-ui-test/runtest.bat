@echo off
setlocal enableextensions
pushd %~dp0

cd ..
call gradlew clean shadowJar

cd build\libs
set jarloc=healthbud.jar
@REM for /f "tokens=*" %%a in (
@REM     'dir /b *.jar'
@REM ) do (
@REM     set jarloc=%%a
@REM )

java -jar %jarloc% < ..\..\text-ui-test\input.txt > ..\..\text-ui-test\ACTUAL.TXT

cd ..\..\text-ui-test

FC ACTUAL.TXT EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!
