package DemoTimeDate.Test;

import DemoTimeDate.Base.BaseTest;
import DemoTimeDate.Main.MainWorldClock;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MWC_CitiesShownScrollTest extends BaseTest {

    MainWorldClock objMainWorldClock;

    //Open the page
    @Test(priority = 0)
    @Parameters({"url"})
    public void openPage(String url){
        objMainWorldClock = new MainWorldClock(getTimeHomePage().getDriver());
        getTimeHomePage().openPage(url);
    }

    //Select menu and sub menu
    @Test(priority = 1)
    @Parameters({"menu","subMenu"})
    public void selectTopMenu(String menu, String subMenu){
        getTimeHomePage().selectTopMenu(menu,subMenu);
    }

    //Compare titles
    @Test(priority = 2)
    @Parameters({"expectedTitle"})
    public void confirmTitle(String expected){
        String actualTitle = objMainWorldClock.getMainTitle();
        Assert.assertEquals(actualTitle,expected, "Title does not match");
    }

    //Get cities list using "Cities Shown" scroll option
    @Test(priority = 3)
    @Parameters({"opt"})
    public void getCitiesShown(String opt){
        objMainWorldClock.citiesShownOption(opt);
    }

    //Select the city indicated by @Parameters
    @Test(priority = 4)
    @Parameters({"city"})
    public void selectCity(String city) {
        objMainWorldClock.selectCityFromGrid(city);
    }

}
