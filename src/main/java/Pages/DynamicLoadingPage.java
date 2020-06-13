package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {

    private WebDriver driver;
    //private String linkXpath_Format=".//a[contains(text(),'%s'";
    private By link_Example1= By.xpath("//*[@id=\"content\"]/div/a[1]");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver=driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample1Page rightClickxample1(){
        driver.findElement(link_Example1).sendKeys(Keys.CONTROL,Keys.ENTER);
        return new DynamicLoadingExample1Page(driver);
    }




}
