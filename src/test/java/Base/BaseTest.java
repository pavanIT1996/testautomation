package Base;

import Pages.HomePage;
import Utils.WindowManager;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BaseTest {

    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout()
        goHome();

        homepage=new HomePage(driver);

        //driver.manage().window().maximize();;
        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(411,731));

//		WebElement Inputslink= driver.findElement(By.linkText("Shifting Content"));
//		Inputslink.click();
//
//		WebElement Inputslink2= driver.findElement(By.linkText("Example 1: Menu Element"));
//		Inputslink2.click();
//
//		List<WebElement> links= driver.findElements(By.tagName("li"));
//		System.out.println(links.size());
//
//		System.out.println(driver.getTitle());

    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }

//    public static void main(String args[]) {
//        BaseTest Test= new BaseTest();
//        Test.setup();
//    }

    @AfterMethod
    public void takesScreenshot(ITestResult result){
        String DateTime = new SimpleDateFormat("yyyy-MM-dd-HH.mm").format(new Date());
        if(ITestResult.FAILURE==result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("resources/screenshots/Failures/"+DateTime+"_"+result.getName()+"_Fail"+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("resources/screenshots/Success/"+DateTime+"_"+result.getName()+"_Pass"+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }


}
