# DemoTimeDate

Este es un demo de Java Automation Test a la pagina https://www.timeanddate.com/ utilizando Selenium TestNG y MAVEN.

Formato Page Object Model / Page Factory.

Los 3 test cases que contiene el demo ser?n ejecutados en paralelo (todos al mismo tiempo), con chrome, firefox y edge, aunque puede ser configurado. 
Los Test Cases son independientes, pueden ser ejecutados tanto en forma individual como grupal.

Para ver el c?digo, ingresar por la ruta src/test/java/DemoTimeDate. Se encontrar?n tres package: Base, Main, Test.

Fue realizado con diferentes recursos, como ser extends class, Exceptions, enum, Asserts, @DataProvider, @Parameters, Robot List, splits, Actions, Waits, Select, JavascriptExecutor, etc.

Se realiz? en distintos sectores de la p?gina para poder lograr diferentes b?squedaas, selecciones mediante box, scroll, calendar, click, comparaciones, descarga de archivos, copia contenido a clipboard, cronometro, etc.

Tests:
-----
InMeetPlanTest: Ingresar? al sector Time Zones - International Meeting Planner.
Constatar? el t?tulo principal de la secci?n. Seleccionar? en el calendario la fecha que sea indicada. Seleccionar? tres locations (ciudades) de forma diferente (dropdown, Search button y Zone button). Mostrar? un cuadro comparativo de las tres ciudades seleccionadas.

Los par?metros se pasar?n a trav?s de @parameters y @dataProvider.

.

MWC_CitiesShownScrollTest: Ingresar? al sector World Clock - Main World Clock. Constatar? el t?tulo principal de la secci?n. Seleccionar? lo que ver? en grilla mediante el dropdown "Cities Shown". Seleccionar? la ciudad indicada mostrando su local time.

Los par?metros se pasar?n a trav?s de @parameters.

.

StopWatch: Ingresar? al sector Timers - Stopwatch. Constatar? el t?tulo principal de la secci?n. Presionar? "Start button", lo cual har? que comience a correr un cron?metro. Presionar? "Split button", lo cu?l har? que tome una captura de datos al momento sin detener el cron?metro. Presionar? "Stop button", lo cual detendr? el cron?metro. Presionar? "Export button", lo cu?l nos permitir? guardar los datos en "clipboard" o descargarlo en archivo (configurado clipboard, constatar abriendo un notepad y pegar datos). En caso de querer los datos en archivo txt reemplazar en TC objStopWatch.downloadPopUp(copyClipboard) por objStopWatch.downloadPopUp(downloadTxtFile). 

Los par?metros se pasar?n a trav?s de @parameters.




Archivos utilizados.
-------------------
pom.xml: archivo maven que contiene las dependencies necesarias.

timeandate.xml: Contiene los parametros necesarios para cada clase de testeo, actualmente se ejecutaran todos los Test Cases en paralelo aunque pueden dividirse en grupo o ejecutarse solo algunos.