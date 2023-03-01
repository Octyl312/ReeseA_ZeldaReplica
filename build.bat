::@echo off
cls
javac Game.java View.java Controller.java Tile.java Json.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)

