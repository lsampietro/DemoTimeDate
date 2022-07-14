package DemoTimeDate.Test;

import DemoTimeDate.Base.BaseTest;
import DemoTimeDate.Main.StopWatch;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StopWatchTest extends BaseTest {

    StopWatch objStopWatch;

    //Open the page
    @Test(priority = 0)
    @Parameters({"url"})
    public void openPage(String url){
        objStopWatch = new StopWatch(getTimeHomePage().getDriver());
        getTimeHomePage().openPage(url);
    }

    //Select menu and sub menu
    @Test(priority = 1)
    @Parameters({"menu","subMenu"})
    public void selectTopMenu(String menu, String subMenu){
        getTimeHomePage().selectTopMenu(menu,subMenu);
    }


    //Click on Start button
    @Test(priority = 2)
    public void selectStartTime(){
        objStopWatch.clickStartButton();
    }

    //Confirm title
    @Test(priority = 3)
    @Parameters({"expectedTitle"})
    public void confirmTitle(String expected){
      String actualTitle = objStopWatch.getMainTitle();
      Assert.assertEquals(actualTitle,expected, "Title does not match");
    }

    //Click on split, pause and export buttons. Copy result to clipboard
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
