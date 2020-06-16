package Base;

import Pages.HomePage;
import Utils.EventReporter;
import Utils.WindowManager;
import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTest {

    private WebDriver driver;
    private Capabilities caps;
//    private EventFiringWebDriver driver;
    protected HomePage homepage;
    private String path;

    @BeforeClass()
    public void setup() {
//        ChromeBrowser();
//        FirefoxBrowser();
//        EdgeBrowser();
        IEBrowser();

    }

    public void ManagerBrowser(){
        driver.manage().window().maximize();;
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(411,731));
    }

    public void ChromeBrowser(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        caps= ((RemoteWebDriver) driver).getCapabilities();
//        driver.register(new EventReporter());
        goHome();
        //setCookies();
    }


    public void FirefoxBrowser(){
        System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
        driver = new FirefoxDriver();
        caps= ((RemoteWebDriver) driver).getCapabilities();
        goHome();
//        setCookies();
    }

    public void IEBrowser(){
        System.setProperty("webdriver.ie.driver","resources/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        caps= ((RemoteWebDriver) driver).getCapabilities();
        goHome();
//        setCookies();
    }

    public void EdgeBrowser(){
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        driver = new EdgeDriver();
        caps= ((RemoteWebDriver) driver).getCapabilities();
        goHome();
//        setCookies();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homepage=new HomePage(driver);
    }


    @AfterMethod
    public void takesScreenshot(ITestResult result){
        String DateTime = new SimpleDateFormat("yyyy-MM-dd-HH.mm").format(new Date());
        if(caps.getBrowserName().equals("chrome")){
            path="resources/screenshots/Chrome";
        } else if (caps.getBrowserName().equals("firefox")){
            path="resources/screenshots/Firefox";
        } else if (caps.getBrowserName().equals("msedge")){
            path="resources/screenshots/Edge";
        } else{
            path="resources/screenshots/IE";
        }

        if(ITestResult.FAILURE==result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File(path+"/FAIL",DateTime+"_"+result.getName()+"_"+caps.getBrowserName()+"_Fail"+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File(path+"/SUCCESS",DateTime+"_"+result.getName()+"_"+caps.getBrowserName()+"_Pass"+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-infobars");
        //options.setHeadless(true);
        return options;
    }

    private void setCookies(){
        Cookie cookie=new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

}
