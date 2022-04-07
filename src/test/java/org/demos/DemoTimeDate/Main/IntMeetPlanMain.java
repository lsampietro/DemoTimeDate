package org.demos.DemoTimeDate.Main;

import org.demos.DemoTimeDate.Base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class IntMeetPlanMain extends BasePage {

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

    @FindBy(id = "mfcountry")
    private WebElement pickCountry;

    @FindBy(id = "mflocation")
    private WebElement pickLocation;

    @FindBy(id = "selbutton")
    private WebElement selButton;

    @FindBy(id = "morelink")
    private WebElement addMoreCities;

    @FindBy(xpath = "//input[@value='Show Timetable']")
    private WebElement showTimetable;

    public IntMeetPlanMain(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void mainTitle(String expTitle){
        String actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'World Clock Meeting Planner ')]")).getText();
        Assert.assertEquals(actualTitle,expTitle);
    }

    //Click on Calendar button
    public void clickCalendarOption() {
        getWait().until(ExpectedConditions.elementToBeClickable(calendarOption));
        calendarOption.click();
    }

    public void findDateOnCalendar(String date) {
        String calendarMonth = "";
        String currentDate = "";

        //Split date
        String yearSplit = date.split("-")[0];
        String monthSplit = date.split("-")[1];
        String daySplit = date.split("-")[2];
        String month = "";

        System.out.println("Date to select: " + date);

        //Months
        switch (monthSplit) {
            case "01":
                month = "january";
                break;
            case "02":
                month = "february";
                break;
            case "03":
                month = "march";
                break;
            case "04":
                month = "april";
                break;
            case "05":
                month = "may";
                break;
            case "06":
                month = "june";
                break;
            case "07":
                month = "july";
                break;
            case "08":
                month = "august";
                break;
            case "09":
                month = "september";
                break;
            case "10":
                month = "october";
                break;
            case "11":
                month = "november";
                break;
            case "12":
                month = "december";
                break;
        }


        for (int i = 0; i < 12; i++) {
            getWait().until(ExpectedConditions.elementToBeClickable(getMonth));
            calendarMonth = getMonth.getText().toLowerCase();

            if (calendarMonth.equals(month)) {
                //System.out.println("Same month selected: " + month + " and " + calendarMonth);
                break;
            } else {
                //Next month button
                calendarNextMonthClick.click();

                //Prev month button
                //calendarPrevMonthClick.click();
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

            Assert.assertEquals(month,calendarMonth,"Different language between months. See example below.");

        }
    }


    //Method to identify Locator. It will be used in the next 3 methods.
    public void mainLocation(int locationNum) {

        //Location number to get it from any method of the class
        locNumber2 = locationNum;

        if (locNumber2 > 0 && locNumber2 <= 12) {

            //"Add More Cities" option can be clicked two times
            while (locNumber2 > 3 && locNumber2 <= 12 && addMoreCities.isDisplayed()) {
                addMoreCities.click();
                if (locNumber2 > 8 && locNumber2 <= 12 && addMoreCities.isDisplayed()) {
                    addMoreCities.click();
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

        try{
        if (locNumber2 > 0 && locNumber2 <= 12) {
            //Click the dropbox of the location indicated
            locations.get(locNumber2 - 1).click();

            //Select the option of the dropdown using the html Value
            new Select(driver.findElement(By.xpath("//select[@id='p" + locNumber2 + "']"))).selectByValue(lValue);

            //Press ESC option in order to close the dropdown options
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ESCAPE).build().perform();

            System.out.println("Location "+locNumber2+" was selected using dropdown option");

        }}catch (NoSuchElementException nse){
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("ERROR: Incorrect '"+lValue+"' selection type Location "+locNumber2+", review Data Provider class");
            System.out.println("---------------------------------------------------------------------------------------");
        }
    }


    //Select Location using Zones Button
    public void getLocationZonesButtons(String zoneValue) {

        try {
            if (locNumber2 > 0 && locNumber2 <= 12) {

                    //Click the Zone Button of the Location indicated
                    zonesButtons.get(locNumber2 - 1).click();

                    //Click "Pick Time Zone" dropdown
                    getWait().until(ExpectedConditions.elementToBeClickable(timeZoneScroll)).click();


                    //Select an option from the scroll (Using its html value)
                    Select se = new Select(timeZoneScroll);
                    se.selectByValue(zoneValue);


                    selButton.click();
                    System.out.println("Location "+locNumber2+" was selected using Zones button");

            }}catch (NoSuchElementException nse) {
                     System.out.println("---------------------------------------------------------------------------------------");
                     System.out.println("ERROR: Incorrect '"+zoneValue+"' value in Location "+locNumber2+", review Data Provider class");
                     System.out.println("---------------------------------------------------------------------------------------");
                     driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
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
            getActions().sendKeys(Keys.TAB).build().perform();
            getActions().sendKeys(Keys.ARROW_DOWN).build().perform();
            getWait().until(ExpectedConditions.elementToBeClickable(selButton)).click();

            System.out.println("Location "+locNumber2+" was selected using Search button");
            }else{
                  System.out.println("Search button: Location " + locNumber2 + " not in dashboard list");
            }}catch (NoSuchElementException nse){
                  System.out.println("---------------------------------------------------------------------------------------");
                  System.out.println("ERROR: Incorrect '"+searchValue+"' value in Location "+locNumber2+", review Data Provider class");
                  System.out.println("---------------------------------------------------------------------------------------");
                  driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
            }
     }

      //Get the table comparing all locations
      public void getTimetable(){
        showTimetable.submit();
      }

    }


