package org.demos.DemoTimeDate.Base;


import org.demos.DemoTimeDate.Main.TimeHomePage;

import org.testng.annotations.*;

public class BaseTest {

    protected BrowserSelector myDriver;
    private TimeHomePage timeHomePage;



    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){
       myDriver = new BrowserSelector(browser);
       timeHomePage = new TimeHomePage(myDriver.getDriver());
       timeHomePage.openPage();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        System.out.println("driver closed");
        timeHomePage.dispose();
    }


    public TimeHomePage getTimeHomePage(){
        return timeHomePage;
    }


}
