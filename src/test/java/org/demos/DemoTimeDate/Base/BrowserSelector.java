package org.demos.DemoTimeDate.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelector extends BaseTest {

    private WebDriver driver;

    public BrowserSelector(String browser){
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
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
