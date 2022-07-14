package DemoTimeDate.Main;


import DemoTimeDate.Base.BasePage;
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
    private WebElement mainBar;


        public void openPage(String url){
            pageUrl(url);
        }

        public void selectTopMenu(String menu, String subMenu){
            getWait().until(ExpectedConditions.visibilityOf(mainBar));
            getActions().moveToElement(getDriver().findElement(By.linkText(menu))).perform();

            WebElement aux = getDriver().findElement(By.linkText(subMenu));
            getWait().until(ExpectedConditions.elementToBeClickable(aux)).click();
    }

}
