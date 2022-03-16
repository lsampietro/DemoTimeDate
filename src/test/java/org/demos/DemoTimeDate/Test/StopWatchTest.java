package org.demos.DemoTimeDate.Test;

import org.demos.DemoTimeDate.Base.BaseTest;
import org.demos.DemoTimeDate.Main.StopWatch;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StopWatchTest extends BaseTest {

    StopWatch objStopWatch;

    @Test(priority = 0)
    public void openPage(){
        getTimeHomePage();
        objStopWatch = new StopWatch(getTimeHomePage().getDriver());
    }

    @Test(priority = 1)
    @Parameters({"menu","subMenu"})
    public void selectTopMenu(String menu, String subMenu){
        System.out.println("Menu: "+menu);
        System.out.println("Submenu: "+subMenu);
        getTimeHomePage().selectTopMenu(menu,subMenu);
    }

    @Test(priority = 2)
    public void selectStartTime(){
        objStopWatch.clickStartButton();
    }

    @Test(priority = 3)
    @Parameters({"expectedTitle"})
    public void confirmTitle(String expected){
      objStopWatch.mainTitle(expected);
    }

    @Test(priority = 4)
    @Parameters({"copyClipboard","downloadTxtFile","yesOrNo"})
    public void downloadFile(String copyClipboard, String downloadTxtFile, char yn) throws InterruptedException {

        //Mili-seconds to let run the timer (Aprox)
        int sec = 5000;
        objStopWatch.clickSplitButton(sec,yn);
        objStopWatch.clickPauseButton();
        objStopWatch.clickExportButton();
        objStopWatch.downloadPopUp(copyClipboard);
    }

}
