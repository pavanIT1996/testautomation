package Base;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homepage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

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

    @AfterClass
    public void teardown(){
        driver.quit();
    }

//    public static void main(String args[]) {
//        BaseTest Test= new BaseTest();
//        Test.setup();
//    }

}