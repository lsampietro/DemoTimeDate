# DemoTimeDate

Este es un demo a la pagina https://www.timeanddate.com/ realizado con IntelliJ IDEA utilizando TestNG.

Formato Page Object Model / Page Factory.

Los Test Cases son independientes, pueden ser ejecutados en forma individual o grupal, asi como con diferentes browsers.

Para ver el código, ingresar por la ruta src/test/java/org/demos.


Fue realizado con diferentes recursos, como ser extends class, Exceptions, Asserts, @DataProvider, @Parameers, Robot List, splits, Actions, Waits, Select, JavascriptExecutor, etc.
Contiene distintas formas de control de flujo como ser for, if, else, while, switch, etc.

Se realizao en distintos sectores de la página para poder lograr diferentes búsquedaas, selecciones mediante box, scroll, calendar, click, comparaciones, descarga de archivos, copia contenido a clipboard, cronometro, etc.

Archivos utilizados.
-------------------
pom.xml: este archivo coniene las dependencies necesarias.

timeandate.xml: Contiene los parametros necesarios para cada clase de testeo, actualmente se ejecutaran todos los Test Cases pero pueden dividirse en grupo o ejecutarse solo algunos.



Package "Base"
-------------

BrowserSelector: Clase mediante la cual se llamará al browser elegido para la realización de pruebas.
Contiene un switch con tres case para realizar selección de chrome, edge o firefox.


BasePage: Contiene métodos que serán utilizados en todas las clases principales mediante "extends".
Carga de url y métodos para ser convocados desde donde sea necesario como ser WebDriverWait, Actions, WebDriver.


BaseTest: Similar a BasePage pero para las clases Test.
Será convocado mediante "extends" en las clases de testeo.
Contiene @BeforeTest, selector de browser.

@AfterTest cierre del driver.
Llamado a carga de url.



Package "Main"
-------------

DataProviderFeatures: clase con un Object[][] el cual será utilizado para el envío de datos a la clase test necesaria y declarada en recepción de @DataProvider.
 
IntMeetPlanMain: Clase con extends BasePage. Ingresara al sector Time Zones - International Meeting Planner.
Se puede realizar una selección y desglosado de fecha, la cual será utilizada para seleccionar mediante calendar.
Se podrán realizar distintos tipos de selecciones mediante diferentes botones y opciones como ser "Search", "Zone" y combo box.
Contiene distintas metodologías de control de flujo como ser switch, if, for, así como WebElement list, Actions, Select, Assert, Waits, split y Exceptions.

MainWorldClock: Clase con extends BasePage. Ingresara al sector World Clock - Main World Clock.
Realizará selección de ciudades de diferentes formas dependiendo la que sea solicitada mediante la clase test correspondiente.
Contiente JavascriptExecutor, Wait, Assert, Select.

StopWatch:Clase con extends BasePage. Ingresara al sector Timers- Stopwatch.
Correrá un timer, para dejarlo correr se pasará por variable el tiempo estimado que corra el tiempo antes de ser pausado o detenido.
Contiene JavascriptExecutor, if, else.
Puede realizar splits, waits, copiar a clipboard o descargar resultado en txt.

TimeHomePage: Página principal con extends BasePage, contiene la clase que realizará la selección del menú superior llamado desde cualquier otra clase.



Package "Test"
--------------

IntMeetPlan_MainTest: Clase con extends BaseTest testeará mediante la clase IntMeetPlanMain.
Realizará la selección del menú principal convocando el método selectTopMenu detallado en TimeHomePage.
Contiene @Test priority, @Parameters, DataProvider.

MWC_CitiesShownScrollTest: Clase con extends BaseTest testeará mediante la clase MainWorldClock.
Realizará la selección del menú principal convocando el método selectTopMenu detallado en TimeHomePage.
Mostrará el resultado de "Current Local Time Around the World" dependiendo de lo que se seleccione desde combo box.
Contiene @Test priority, @Parameters.

MWC_SearchBoxTest: Clase con extends BaseTest testeará mediante la clase MainWorldClock.
Realizará la selección del menú principal convocando el método selectTopMenu detallado en TimeHomePage.
Mostrará el resultado de "Current Local Time" dependiendo de la búsqueda que se realice mediante searchbox.
Contiene @Test priority, @Parameters, Assert.

StopWatchTest: Clase con extends BaseTest testeará mediante la clase StopWatch.
Realizará la selección del menú principal convocando el método selectTopMenu detallado en TimeHomePage.
Iniciará el timer, presionara split para realizar una primera acción de resultado que se verá en pantalla, pausara el timer, y copiara a clipboard el resultado. 
De quererlo se puede realizar download de resultado en txt en lugar de copiar a clipboard, reemplazando la variable copyClipbeard por downloadTxtFile.

