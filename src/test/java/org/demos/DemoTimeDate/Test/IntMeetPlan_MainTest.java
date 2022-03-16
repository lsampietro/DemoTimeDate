package org.demos.DemoTimeDate.Test;
import org.demos.DemoTimeDate.Base.BaseTest;
import org.demos.DemoTimeDate.Main.DataProviderFeatures;
import org.demos.DemoTimeDate.Main.IntMeetPlanMain;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IntMeetPlan_MainTest extends BaseTest {

      IntMeetPlanMain objIntMeetPlanMain;

   //Open the page
   @Test(priority = 0)
   public void openPage(){
           getTimeHomePage();
           objIntMeetPlanMain = new IntMeetPlanMain(getTimeHomePage().getDriver());
       }

    @Test(priority = 1)
    @Parameters({"menu","subMenu"})
    public void selectTopMenu(String menu, String subMenu){
        System.out.println("Menu: "+menu);
        System.out.println("Submenu: "+subMenu);
        getTimeHomePage().selectTopMenu(menu,subMenu);
    }

    @Test(priority = 2)
    @Parameters({"expectedTitle"})
    public void confirmTitle(String expected){
        objIntMeetPlanMain.mainTitle(expected);
    }

    @Test(priority = 3)
    @Parameters({"date"})
    public void testCalendar(String date) {
       objIntMeetPlanMain.clickCalendarOption();
       objIntMeetPlanMain.findDateOnCalendar(date);
    }

    @Test(priority = 4,dataProvider = "intMeetPlanDP",  dataProviderClass = DataProviderFeatures.class)
    public void zones(int locNumber, String paramNeeded, String selectionType) {

            if (selectionType == "searchButton") {
                objIntMeetPlanMain.mainLocation(locNumber);
                objIntMeetPlanMain.getLocationSearchButtons(paramNeeded);
            }else if (selectionType == "dropdown") {
                objIntMeetPlanMain.mainLocation(locNumber);
                objIntMeetPlanMain.getLocationDropdown(paramNeeded);
            } else if (selectionType == "zoneButton") {
                objIntMeetPlanMain.mainLocation(locNumber);
                objIntMeetPlanMain.getLocationZonesButtons(paramNeeded);
            } else {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("ERROR: '"+selectionType+"'" + " incorrect selection type in Location "+locNumber+", check the DataProvider class");
                System.out.println("--------------------------------------------------------------------------------------");
            }
    }

   @Test(priority = 5)
    public void getTimeTable(){
       objIntMeetPlanMain.getTimetable();
    }
}
