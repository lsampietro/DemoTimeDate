package org.demos.DemoTimeDate.Test;

import org.demos.DemoTimeDate.Base.BaseTest;
import org.demos.DemoTimeDate.Main.MainWorldClock;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MWC_CitiesShownScrollTest extends BaseTest {

    MainWorldClock objMainWorldClock;

    //Open the page
    @Test(priority = 0)
    public void openPage(){
        getTimeHomePage();
        objMainWorldClock = new MainWorldClock(getTimeHomePage().getDriver());
    }

    //Select option from top menu
    @Test(priority = 1)
    @Parameters({"menu","subMenu"})
    public void selectTopMenu(String menu, String subMenu){
        System.out.println("menu: "+menu);
        System.out.println("submenu: "+subMenu);
        getTimeHomePage().selectTopMenu(menu,subMenu);
    }

    @Test(priority = 2)
    @Parameters({"expectedTitle"})
    public void confirmTitle(String expected){
        objMainWorldClock.mainTitle(expected);
    }

    //Get cities list using "Cities Shown" scroll option
    @Test(priority = 3)
    @Parameters({"opt"})
    public void getCitiesShown(String opt){
        objMainWorldClock.citiesShownOption(opt);
    }

    //Select the city indicated in @Parameters
    @Test(priority = 4)
    @Parameters({"city"})
    public void selectCity(String city) {
        objMainWorldClock.selectCityFromGrid(city);

    }

}
