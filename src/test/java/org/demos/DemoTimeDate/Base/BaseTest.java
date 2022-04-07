package org.demos.DemoTimeDate.Base;


import org.demos.DemoTimeDate.Main.TimeHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class BaseTest {


    private TimeHomePage timeHomePage;
    private WebDriver driver;


    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("-------------------------------");
                System.out.println("Incorrect browser. Check params");
                System.out.println("-------------------------------");
        }

       driver.manage().window().maximize();
       timeHomePage = new TimeHomePage(driver);
       timeHomePage.openPage();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("driver closed");
        timeHomePage.dispose();
    }


    public TimeHomePage getTimeHomePage(){
        return timeHomePage;
    }


}
