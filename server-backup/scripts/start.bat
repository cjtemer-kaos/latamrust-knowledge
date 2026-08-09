@echo off
title COBBLEVERSE - Pokemon Adventure Server
echo ========================================
echo   COBBLEVERSE - Pokemon Adventure
echo   Fabric 1.21.1 + Cobblemon 1.7.3
echo ========================================
echo.

REM --- Find Java 21 automatically ---
set "JAVA_PATH="

REM Check common locations
if exist "java.exe" (
    set "JAVA_PATH=java.exe"
    goto :found_java
)

REM Check JAVA_HOME
if defined JAVA_HOME (
    if exist "%JAVA_HOME%\bin\java.exe" (
        set "JAVA_PATH=%JAVA_HOME%\bin\java.exe"
        goto :found_java
    )
)

REM Check PATH
where java >nul 2>&1
if %errorlevel% equ 0 (
    set "JAVA_PATH=java"
    goto :found_java
)

REM Check common install locations
for %%P in (
    "C:\Program Files\Eclipse Adoptium\jdk-21*\bin\java.exe"
    "C:\Program Files\Java\jdk-21*\bin\java.exe"
    "C:\Program Files\Microsoft\jdk-21*\bin\java.exe"
    "C:\Program Files\Zulu\zulu-21*\bin\java.exe"
    "%USERPROFILE%\.jdks\jdk-21*\bin\java.exe"
) do (
    for %%F in (%%P) do (
        if exist "%%F" (
            set "JAVA_PATH=%%F"
            goto :found_java
        )
    )
)

echo ERROR: Java 21 not found!
echo Please install Eclipse Temurin JDK 21 or set JAVA_HOME
pause
exit /b 1

:found_java
echo Using Java: %JAVA_PATH%
echo.

set SERVER_JAR=fabric-server-launch.jar
set MIN_RAM=10G
set MAX_RAM=20G

REM === Launch post-startup script in background ===
start "" "D:\SERVIDOR\servers\LATAMRUST COBBLEMON\post_startup.bat"

REM === Flags optimizados Ryzen 5 2600 (6C/12T) + 32GB ===
"%JAVA_PATH%" -Xms%MIN_RAM% -Xmx%MAX_RAM% -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=150 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=30 -XX:G1MaxNewSizePercent=40 -XX:G1HeapRegionSize=8M -XX:G1ReservePercent=20 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=15 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -XX:ActiveProcessorCount=6 -XX:ParallelGCThreads=6 -XX:ConcGCThreads=2 -XX:+UseStringDeduplication -XX:+ExitOnOutOfMemoryError -Dusing.aikars.flags=https://mcflags.emc.gs -Daikars.new.flags=true -jar "%SERVER_JAR%" nogui

echo.
echo server stopped.
