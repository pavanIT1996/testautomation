package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By hotSpot= By.id("hot-spot");
    //private By AlertBox= By.xpath(".//button[text()='Click for JS Confirm']");

    public ContextMenuPage(WebDriver driver) {
        this.driver=driver;
    }

    /**+
     * contextClick equals right-click event
     */
    public void rightClickOnHotSport(){
        WebElement hotspot2= driver.findElement(hotSpot);
        Actions actions =new Actions(driver);
        actions.contextClick(hotspot2).perform();
    }
    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

}
