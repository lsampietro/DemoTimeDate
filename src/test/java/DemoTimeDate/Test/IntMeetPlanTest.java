package DemoTimeDate.Test;
import DemoTimeDate.Base.BaseTest;
import DemoTimeDate.Main.DataProviderFeatures;
import DemoTimeDate.Main.IntMeetPlan;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class IntMeetPlanTest extends BaseTest {

      IntMeetPlan objIntMeetPlan;

   //Open the page
   @Test(priority = 0)
   @Parameters({"url"})
   public void openPage(String url){
           objIntMeetPlan = new IntMeetPlan(getTimeHomePage().getDriver());
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
    public void confirmTitle(String expected) {
        String actualTitle = objIntMeetPlan.getMainTitle();
        Assert.assertEquals(actualTitle, expected, "Title does not match");
    }

    //Set date
    @Test(priority = 3)
    @Parameters({"date"})
    public void testCalendar(String date) {
       objIntMeetPlan.clickCalendarOption();
       objIntMeetPlan.findDateOnCalendar(date);
    }

    //Select Locations using dropdown, search buttin and zone button
    @Test(priority = 4,dataProvider = "intMeetPlanDP",  dataProviderClass = DataProviderFeatures.class)
    public void zones(int locNumber, String paramNeeded, String selectionType) {

            if (selectionType == "searchButton") {
                objIntMeetPlan.mainLocation(locNumber);
                objIntMeetPlan.getLocationSearchButtons(paramNeeded);
            }else if (selectionType == "dropdown") {
                objIntMeetPlan.mainLocation(locNumber);
                objIntMeetPlan.getLocationDropdown(paramNeeded);
            } else if (selectionType == "zoneButton") {
                objIntMeetPlan.mainLocation(locNumber);
                objIntMeetPlan.getLocationZonesButtons(paramNeeded);
            } else {
                System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("ERROR: '"+selectionType+"'" + " incorrect selection type in Location "+locNumber+", check the DataProvider class");
                System.out.println("--------------------------------------------------------------------------------------");
            }
    }

    //Get the final table
   @Test(priority = 5)
    public void getTimeTable(){
       objIntMeetPlan.getTimetable();
    }
}
