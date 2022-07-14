package DemoTimeDate.Main;

import DemoTimeDate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class StopWatch extends BasePage {

    private JavascriptExecutor js;

    @FindBy(xpath = "//button[contains(@class,'action--start')]")
    private WebElement startButton;

    @FindBy(xpath = "//button[contains(@class,'action--pause')]")
    private WebElement pauseButton;

    @FindBy(xpath = "//button[contains(@class,'action--split')]")
    private WebElement splitButton;

    @FindBy(xpath = "//button[contains(@class,'action--reset')]")
    private WebElement resetButton;

    @FindBy(xpath = "//button[contains(@class,'action--export')]")
    private WebElement exportButton;

    @FindBy(xpath = "//button[contains(text(),'Download')]")
    private  WebElement downloadFile;

    @FindBy(xpath = "//button[contains(text(),'Copy')]")
    private WebElement copyClipboard;


    public StopWatch(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Check main title of the page
    public String getMainTitle(){
        String actualTitle="";
        actualTitle = driver.findElement(By.xpath("//h1[contains(text(),'Online Stopwatch')]")).getText();
        return actualTitle;
    }

    //Click on Start button
    public void clickStartButton(){
        //scroll page down to see all buttons
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)","");

        getWait().until(ExpectedConditions.elementToBeClickable(startButton));

        if(startButton.isDisplayed() && startButton.isEnabled()) {
            startButton.click();
        }else{
            System.out.println("Start button is not available\n");
        }
    }

    //Click on Split button
    public void clickSplitButton(int sec, char yn) throws InterruptedException {
       //Always turn character option to lowercase
        char opt = Character.toLowerCase(yn);

        //The timer will be running the aprox time
        Thread.sleep(sec);

        //Yes option will click Split button. No option will not do it
        if(splitButton.isDisplayed() && splitButton.isEnabled() && opt=='y'){
            splitButton.click();
        }else if(splitButton.isDisplayed() && splitButton.isEnabled() && opt=='n'){
            System.out.println("No Split button needed for this test\n");
        }
        else{
            System.out.println("---------------------------------------------------------");
            System.out.println("Split button is not available. Check params and Test Case");
            System.out.println("---------------------------------------------------------");
        }
    }

    //Click on Pause button
    public void clickPauseButton() {
        if(pauseButton.isDisplayed() && pauseButton.isEnabled()){
            pauseButton.click();
        }else
            System.out.println("Pause button is not available.\n");
    }


    //Click on Reset button
    public void clickResetButton(){
        if(resetButton.isDisplayed() && resetButton.isEnabled()){
            resetButton.click();
        }else{
            System.out.println("Reset button is not available\n");
        }
    }

    public void clickExportButton(){
        getWait().until(ExpectedConditions.visibilityOf(exportButton));

        if(exportButton.isDisplayed() && exportButton.isEnabled()){
            exportButton.click();
        }else{
            System.out.println("Export button is not available\n");
        }
    }

    public void downloadPopUp(String copyOrDownload){
        //Option always low case in order to match
        String standardOption = copyOrDownload.toLowerCase();

        if(standardOption.equals("df")){
            getWait().until(ExpectedConditions.elementToBeClickable(downloadFile)).click();
            WebElement closeButton = driver.findElement(By.xpath("//button[contains(@class,'form--ghost fl')]"));
            getWait().until(ExpectedConditions.elementToBeClickable(closeButton)).click();
            getActions().perform();

        }else if(standardOption.equals("cc")){
            getWait().until(ExpectedConditions.elementToBeClickable(copyClipboard)).click();
            WebElement closeButton = driver.findElement(By.xpath("//button[contains(@class,'form--ghost fl')]"));
            getWait().until(ExpectedConditions.elementToBeClickable(closeButton)).click();

        }else{
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Incorrect option to copy clipboard or download file. Check params");
            System.out.println("--------------------------------------------------------------------");
        }
    }

}
