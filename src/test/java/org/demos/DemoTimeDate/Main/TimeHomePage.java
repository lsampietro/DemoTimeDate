package org.demos.DemoTimeDate.Main;


import org.demos.DemoTimeDate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TimeHomePage extends BasePage {

   public TimeHomePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//nav[@id='nav']")
    private WebElement bar;

        public void openPage(){
            pageUrl();
        }

        public void selectTopMenu(String menu, String subMenu){
            getWait().until(ExpectedConditions.visibilityOf(bar));
            getActions().moveToElement(getDriver().findElement(By.linkText(menu))).perform();
            getDriver().findElement(By.linkText(subMenu)).click();
    }

}
