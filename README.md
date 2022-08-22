# DemoTimeDate

Path to visualize the automation testing code:
DemoTimeDate/src/test/java/DemoTimeDate/


Este es un demo de Java Automation Test a la pagina https://www.timeanddate.com/ utilizando Selenium TestNG y MAVEN.

Formato Page Object Model / Page Factory.

Los 3 test cases que contiene el demo serán ejecutados en paralelo (todos al mismo tiempo), dos con chrome y uno edge, aunque puede ser configurado (incluyendo firefox). 
Los Test Cases son independientes, pueden ser ejecutados tanto en forma individual como grupal.

Para ver el código, ingresar por la ruta src/test/java/DemoTimeDate. Se encontrarán tres package: Base, Main, Test.

Fue realizado con diferentes recursos, como ser extends class, Exceptions, enum, Asserts, @DataProvider, @Parameters, Robot List, splits, Actions, Waits, Select, JavascriptExecutor, etc.

Se realizó en distintos sectores de la página para poder lograr diferentes búsquedaas, selecciones mediante box, scroll, calendar, click, comparaciones, descarga de archivos, copia contenido a clipboard, cronómetro, etc.

Tests:
-----
InMeetPlanTest: Ingresar  al sector Time Zones - International Meeting Planner.
Constatar  el título principal de la sección. Seleccionar  en el calendario la fecha que sea indicada. Seleccionar  tres locations (ciudades) de forma diferente (dropdown, Search button y Zone button). Mostrará un cuadro comparativo de las tres ciudades seleccionadas.

Los parámetros se pasarán a trav s de @parameters y @dataProvider.

.

MWC_CitiesShownScrollTest: Ingresar  al sector World Clock - Main World Clock. Constatar  el título principal de la sección. Seleccionará lo que verá en grilla mediante el dropdown "Cities Shown". Seleccionará la ciudad indicada mostrando su local time.

Los parámetros se pasarán a través de @parameters.

.

StopWatch: Ingresar  al sector Timers - Stopwatch. Constatar  el título principal de la sección. Presionar  "Start button", lo cual hará que comience a correr un cronómetro. Presionar  "Split button", lo cuál hará que tome una captura de datos al momento sin detener el cronómetro. Presionar  "Stop button", lo cual detendrá el cronómetro. Presionar  "Export button", lo cuál nos permitirá guardar los datos en "clipboard" o descargarlo en archivo (configurado clipboard, constatar abriendo un notepad y pegar datos). En caso de querer los datos en archivo txt reemplazar en TC objStopWatch.downloadPopUp(copyClipboard) por objStopWatch.downloadPopUp(downloadTxtFile). 

Los parámetros se pasarán a través de @parameters.




Archivos utilizados.
-------------------
pom.xml: archivo maven que contiene las dependencies necesarias.

timeandate.xml: Contiene los parámetros necesarios para cada clase de testeo, actualmente se ejecutarán todos los Test Cases en paralelo aunque pueden dividirse en grupo o ejecutarse solo algunos.
