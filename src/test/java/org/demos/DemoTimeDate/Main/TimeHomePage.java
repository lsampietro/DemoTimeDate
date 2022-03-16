package org.demos.DemoTimeDate.Main;


import org.demos.DemoTimeDate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimeHomePage extends BasePage {

   public TimeHomePage(WebDriver driver){
        super(driver);
    }


        public void openPage(){
            pageUrl();
        }

        public void selectTopMenu(String menu, String subMenu){
            getActions().moveToElement(getDriver().findElement(By.linkText(menu))).perform();
            getDriver().findElement(By.linkText(subMenu)).click();

    }


}
