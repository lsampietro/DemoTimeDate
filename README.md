# DemoTimeDate

Este es un demo de Automation Test a la pagina https://www.timeanddate.com/ utilizando TestNG y MAVEN.

Formato Page Object Model / Page Factory.

Los 3 test cases que contiene el demo serán ejecutados en paralelo (todos al mismo tiempo), dos con chrome y uno con edge, aunque puede ser configurado. 
Los Test Cases son independientes, pueden ser ejecutados tanto en forma individual como grupal.

Para ver el código, ingresar por la ruta src/test/java/DemoTimeDate. Se encontrarán tres package: Base, Main, Test.

Fue realizado con diferentes recursos, como ser extends class, Exceptions, Asserts, @DataProvider, @Parameters, Robot List, splits, Actions, Waits, Select, JavascriptExecutor, etc.

Se realizao en distintos sectores de la página para poder lograr diferentes búsquedaas, selecciones mediante box, scroll, calendar, click, comparaciones, descarga de archivos, copia contenido a clipboard, cronometro, etc.

Tests:
-----
InMeetPlanTest: Ingresará al sector Time Zones - International Meeting Planner.
Constatará el título principal de la sección. Seleccionará en el calendario la fecha que sea indicada. Seleccionará tres locations (ciudades) de forma diferente (dropdown, Search button y Zone button). Mostrará un cuadro comparativo de las tres ciudades seleccionadas.

Los parámetros se pasarán a través de @parameters y @dataProvider.

.

MWC_CitiesShownScrollTest: Ingresará al sector World Clock - Main World Clock. Constatará el título principal de la sección. Seleccionará lo que verá en grilla mediante el dropdown "Cities Shown". Seleccionará la ciudad indicada mostrando su local time.

Los parámetros se pasarán a través de @parameters.

.

StopWatch: Ingresará al sector Timers - Stopwatch. Constatará el título principal de la sección. Presionará "Start button", lo cual hará que comience a correr un cronómetro. Presionará "Split button", lo cuál hará que tome una captura de datos al momento sin detener el cronómetro. Presionará "Stop button", lo cual detendrá el cronómetro. Presionará "Export button", lo cuál nos permitirá guardar los datos en "clipboard" o descargarlo en archivo (configurado clipboard, constatar abriendo un notepad y pegar datos). En caso de querer los datos en archivo txt reemplazar en TC objStopWatch.downloadPopUp(copyClipboard) por objStopWatch.downloadPopUp(downloadTxtFile). 

Los parámetros se pasarán a través de @parameters.




Archivos utilizados.
-------------------
pom.xml: archivo maven que contiene las dependencies necesarias.

timeandate.xml: Contiene los parametros necesarios para cada clase de testeo, actualmente se ejecutaran todos los Test Cases en paralelo aunque pueden dividirse en grupo o ejecutarse solo algunos.

