package DemoTimeDate.Main;

import DemoTimeDate.Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;



public class IntMeetPlan extends BasePage {


    private int locNumber2;

    @FindBy(className = "btn-datepicker")
    private WebElement calendarOption;

    @FindBy(xpath = "//a[@class='picked-month']")
    private WebElement getMonth;

    @FindBy(xpath = "//a[contains(@onclick,\"Picker.stepMonth\") and @class='next']")
    private WebElement calendarNextMonthClick;

    @FindBy(xpath = "//a[contains(@onclick,\"Picker.stepMonth\") and @class='prev']")
    private WebElement calendarPrevMonthClick;

    @FindBy(xpath = "//p[@class='meetloc']//select[contains(@id,'p' ) and contains(@name,'p' )]")
    private List<WebElement> locations;

    @FindBy(xpath = "//input[@type='button' and @value='Zones...']")
    private List<WebElement> zonesButtons;

    @FindBy(xpath = "//input[@type='button' and @value='Search...']")
    private List<WebElement> searchButtons;

    @FindBy(id = "mftz")
    private WebElement timeZoneScroll;

    @FindBy(name = "mfcountry")
    private WebElement pickCountry;

    @FindBy(id = "mflocation")
    private WebElement pickLocation;

    @FindBy(id = "selbutton")
    private WebElement selButton;

    @FindBy(id = "morelink")
    private WebElement addMoreCities;

    @FindBy(xpath = "//input[@value='Show Timetable']")
    private WebElement showTimetable;

    enum Months{
        january, february, march, april, may, june, july, august,
        september, october, november, december
    }

    public IntMeetPlan(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public String getMainTitle(){
        String actualTitle="";
        actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'World Clock Meeting Planner')]")).getText();
        return actualTitle;
    }

    //Click on Calendar button
    public void clickCalendarOption() {
        getWait().until(ExpectedConditions.elementToBeClickable(calendarOption)).click();
    }

    //Select a date from calendar
    public void findDateOnCalendar(String date) {
        String calendarMonth = "";
        String currentDate = "";
        Months month = null;

        //Split date
        String yearSplit = date.split("-")[0];
        String monthSplit = date.split("-")[1];
        String daySplit = date.split("-")[2];


        //Months
        switch (monthSplit) {
            case "01":
                month = Months.january;
                break;
            case "02":
                month = Months.february;
                break;
            case "03":
                month = Months.march;
                break;
            case "04":
                month = Months.april;
                break;
            case "05":
                month = Months.may;
                break;
            case "06":
                month = Months.june;
                break;
            case "07":
                month = Months.july;
                break;
            case "08":
                month = Months.august;
                break;
            case "09":
                month = Months.september;
                break;
            case "10":
                month = Months.october;
                break;
            case "11":
                month = Months.november;
                break;
            case "12":
                month = Months.december;
                break;

            default:
                System.out.println("-------------------------------------");
                System.out.println("Incorrect month. Check date on params");
                System.out.println("-------------------------------------");
        }


        for (int i = 0; i < 12; i++) {
            getWait().until(ExpectedConditions.elementToBeClickable(getMonth));
            calendarMonth = getMonth.getText().toLowerCase();


            if (calendarMonth.equals(month.toString())){
                break;
            } else {
                //Next month button
                getWait().until(ExpectedConditions.elementToBeClickable(calendarNextMonthClick));
                calendarNextMonthClick.click();

            }
        }


        //Set day
        try {
            List<WebElement> dates = driver.findElements(By.tagName("td"));
            int total_nodes = dates.size();
            for (int i = 0; i <= total_nodes; i++) {
                currentDate = dates.get(i).getText();

                if (currentDate.equals(daySplit)) {
                    dates.get(i).click();
                    break;
                }
            }
        } catch (StaleElementReferenceException ser) {
            System.out.println("---------------------------------------------------------------");
            System.out.println("ERROR: The date was not found, check format and months language");
            System.out.println("---------------------------------------------------------------");

       }
    }


    //Method to identify Locator. It will be used in the next 3 methods.
    public void mainLocation(int locationNum) {

        //Location number to get it from any method of the class
        locNumber2 = locationNum;

        if (locNumber2 > 0 && locNumber2 <= 12) {

            //"Add More Cities" option can be clicked two times
            while (locNumber2 > 3 && locNumber2 <= 12 && addMoreCities.isDisplayed()) {
                getWait().until(ExpectedConditions.elementToBeClickable(addMoreCities)).click();
                if (locNumber2 > 8 && locNumber2 <= 12 && addMoreCities.isDisplayed()) {
                    getWait().until(ExpectedConditions.elementToBeClickable(addMoreCities)).click();
                }
                break;
            }
        } else {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Location " + locNumber2 + " is not in page, check Data Provider class");
            System.out.println("---------------------------------------------------------------------");
        }
    }


    //Select Location using dropdown option
    public void getLocationDropdown(String lValue) {

        try {
          if (locNumber2 > 0 && locNumber2 <= 12) {

                //Click the dropbox of the location indicated
                WebElement locationSelected = locations.get(locNumber2 - 1);
                getWait().until(ExpectedConditions.elementToBeClickable(locationSelected)).click();

                //Select the option of the dropdown using the html Value
                new Select(driver.findElement(By.xpath("//select[@id='p" + locNumber2 + "']"))).selectByValue(lValue);

                //Press ESC option in order to close the dropdown options
                getActions().sendKeys(Keys.ESCAPE).build().perform();
            }
        } catch (NoSuchElementException nse) {
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("ERROR: Incorrect '" + lValue + "' selection type Location " + locNumber2 + ", review Data Provider class");
            System.out.println("---------------------------------------------------------------------------------------");

        }
    }


    //Select Location using Zones Button
    public void getLocationZonesButtons(String zoneValue) {

        try {
            if (locNumber2 > 0 && locNumber2 <= 12) {

                    //Click the Zone Button of the Location indicated
                    WebElement zb = zonesButtons.get(locNumber2 - 1);
                    getWait().until(ExpectedConditions.elementToBeClickable(zb)).click();

                    //Click "Pick Time Zone" dropdown
                    getWait().until(ExpectedConditions.elementToBeClickable(timeZoneScroll)).click();

                    //Select an option from the scroll (Using its html value)
                    Select se = new Select(timeZoneScroll);
                    se.selectByValue(zoneValue);

                    getWait().until(ExpectedConditions.elementToBeClickable(selButton)).click();


            }}catch (NoSuchElementException nse) {
                     System.out.println("---------------------------------------------------------------------------------------");
                     System.out.println("ERROR: Incorrect '"+zoneValue+"' value in Location "+locNumber2+", review Data Provider class");
                     System.out.println("---------------------------------------------------------------------------------------");
        }
    }


        //Select location using Search button
    public void getLocationSearchButtons(String searchValue){

         try{
             if(locNumber2 > 0 && locNumber2 <= 12) {

            //Click the Search Button of the Location indicated
            searchButtons.get(locNumber2 - 1).click();
            getWait().until(ExpectedConditions.elementToBeClickable(pickCountry)).click();

            //Select an option from the scroll (Using its html value)
            Select se = new Select(pickCountry);
            se.selectByValue(searchValue);

            //For this demo always select the first option of "Pick Location" using TAB and Arrow Down action
            //TAB key and Arrow Down key needed two times (lest and right boxes)
             int aux=0;
             while(aux<2) {
                 getActions().sendKeys(Keys.TAB).build().perform();
                 getActions().sendKeys(Keys.ARROW_DOWN).build().perform();
                 aux++;
             }

            getWait().until(ExpectedConditions.elementToBeClickable(selButton)).click();

          }}catch (NoSuchElementException nse){
                  System.out.println("-----------------------------------------------------------------------------------------------");
                  System.out.println("ERROR: Incorrect '"+searchValue+"' value in Location "+locNumber2+", review Data Provider class");
                  System.out.println("-----------------------------------------------------------------------------------------------");

            }
     }

      //Get the table comparing all locations
      public void getTimetable(){
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(showTimetable)).submit();
        }catch (UnhandledAlertException uae){
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("ERROR: Show Timetable button not available");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
      }
}


