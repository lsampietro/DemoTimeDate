package DemoTimeDate.Main;

import org.testng.annotations.DataProvider;

public class DataProviderFeatures
{
    //Time Zones - International meeting Planner
    //First field: The number of the location to be selected (Ex. Location 9 only insert the 9)
    //Second field: The Option value of the select list (get it from html code)
    //Third field: How to select the Option value (using Search Button, Dropdown or Zone button)
    @DataProvider(name="intMeetPlanDP")
    public static Object[][] dataProviderMethod()
    {
        return new Object[][]{
                {1,"700","dropdown"},
                {9,"sa_act","zoneButton"},
                {4,"20","searchButton"},
        };
    }

}
