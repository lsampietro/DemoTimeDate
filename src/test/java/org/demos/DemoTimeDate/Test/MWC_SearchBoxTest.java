package org.demos.DemoTimeDate.Test;

import org.demos.DemoTimeDate.Base.BaseTest;
import org.demos.DemoTimeDate.Main.MainWorldClock;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MWC_SearchBoxTest extends BaseTest {

    MainWorldClock objMainWorldClock;

    //Open the page
    @Test(priority = 0)
    public void openPage(){
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


    //Searching city using search text box
    @Test(priority = 3)
    @Parameters({"city"})
    public void searchCity(String city){
        objMainWorldClock.searchCityBox(city);
    }


    //Select a city from grid. Check name of the city
    @Test(priority = 4)
    @Parameters({"cityToSelect","expectedName"})
    public void selectCitySearched(String cityToSelect, String expectedName)  {
        objMainWorldClock.selectCityFromGrid(cityToSelect);
        String actualCity = objMainWorldClock.getCityName();
        Assert.assertEquals(expectedName,actualCity);
    }

}
