@echo off
REM Wait for server to be ready (30 seconds)
timeout /t 30 /nobreak >nul
REM Set sendCommandFeedback
D:\SERVIDOR\mcrcon\mcrcon.exe -H 127.0.0.1 -P 25575 -p cobbleverse2026 "gamerule sendCommandFeedback true" >nul 2>&1
echo sendCommandFeedback set to true
