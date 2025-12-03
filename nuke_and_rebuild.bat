@echo off
set JAVA_HOME=C:\Program Files\Java\jdk-21
cd /d C:\Users\james\mods\kookie

echo Stopping Gradle daemons...
call C:\Users\james\mods\kookie\gradlew.bat --stop

echo Deleting build directory...
rmdir /s /q build 2>nul

echo Deleting .gradle directory (project)...
rmdir /s /q .gradle 2>nul

echo Deleting run directory caches...
rmdir /s /q run\.fabric 2>nul

echo Cleaning Loom caches from user gradle...
rmdir /s /q "%USERPROFILE%\.gradle\caches\fabric-loom" 2>nul

echo Running clean build...
call C:\Users\james\mods\kookie\gradlew.bat clean build -x test

echo Done!
pause
