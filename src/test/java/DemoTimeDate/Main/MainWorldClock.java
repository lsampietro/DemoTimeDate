package DemoTimeDate.Main;

import DemoTimeDate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;

public class MainWorldClock extends BasePage {

    private Robot robot;
    private JavascriptExecutor js;

    @FindBy(xpath = "//input[@name=\"query\" and @class=\"picker-city__input\"]")
    private WebElement searchCityBox;

    @FindBy(className = "picker-city__button")
    private WebElement searchButton;

    @FindBy(id = "pop")
    private WebElement citiesShownScroll;

    @FindBy(className = "headline-banner__title")
    private WebElement cityName;


    public MainWorldClock(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Search for city using search box and button
    public void  searchCityBox(String city){
        searchCityBox.sendKeys(city);
        getWait().until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    //Check main title of the page
    public String getMainTitle(){
        String actualTitle="";
        actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'The World Clock — Worldwide')]")).getText();
        return actualTitle;
    }

    //Select option from Cities Shown scroll
    public void citiesShownOption(String opt){
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");

        Select citiesShown = new Select(citiesShownScroll);
        citiesShown.selectByVisibleText(opt);
    }

    //Select the indicated city on the grid
    public void selectCityFromGrid(String citySelected){
        WebElement city = driver.findElement(By.linkText(citySelected));
        getWait().until(ExpectedConditions.elementToBeClickable(city)).click();
    }

    //Get title city name
    public String getCityName(){
        return cityName.getText();
    }

}
