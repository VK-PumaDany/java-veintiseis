@echo off
echo Buscando y compilando todos los archivos nuevos...

:: Crea la carpeta bin si no existe para mantener limpio el proyecto
if not exist bin mkdir bin

:: Busca todos los .java y los guarda en un archivo temporal
dir /s /b src\*.java > sources.txt
if exist App.java echo App.java >> sources.txt

:: Compila todo lo que encontró
javac -d bin @sources.txt

if %errorlevel% == 0 (
    echo [OK] Compilacion exitosa.
    java -cp bin App
) else (
    echo [ERROR] Revisa tu codigo.
)
del sources.txt
pause