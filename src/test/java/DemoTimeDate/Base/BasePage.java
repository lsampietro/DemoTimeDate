package DemoTimeDate.Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.Selector;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions act;



    public BasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        act = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    public void pageUrl(String url){
      driver.get(url);
    }


    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions(){
        return act;
    }

    public  WebDriver getDriver() {
        return this.driver;
    }


    public void dispose() {
        if (driver != null) {
            driver.quit();
        }
    }
}
