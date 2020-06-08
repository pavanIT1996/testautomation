package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderContainer= By.className("sliderContainer");
    private By inputSlider= By.tagName("input");
    private By valueSlider= By.tagName("span");

    private int value2;

    public HorizontalSliderPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickSlider(){
        WebElement slider=driver.findElement(sliderContainer);
        slider.click();
    }

    public void enterSlider(int value) {
        value2=value*2;
        value=0;
        while (value2>value) {
            driver.findElement(inputSlider).sendKeys(Keys.ARROW_RIGHT);
            value++;
        }
    }

    public String getValue(){
        return driver.findElement(valueSlider).getText();
    }

}
