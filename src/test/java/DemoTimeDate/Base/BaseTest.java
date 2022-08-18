package DemoTimeDate.Base;


import DemoTimeDate.Main.TimeHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;




public class BaseTest {

    private TimeHomePage timeHomePage;
    private WebDriver driver;


    enum BrowserList{
        chrome,firefox,edge
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void setUp(String browser){

        if(browser.equalsIgnoreCase(BrowserList.chrome.toString())){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase(BrowserList.firefox.toString())){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase(BrowserList.edge.toString())){
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }else {
            System.out.println("-------------------------------");
            System.out.println("Incorrect browser. Check params");
            System.out.println("-------------------------------");
        }

       //driver.manage().window().maximize();
       timeHomePage = new TimeHomePage(driver);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        System.out.println("driver closed");
        timeHomePage.dispose();
    }

    public TimeHomePage getTimeHomePage(){
        return timeHomePage;
    }

}
