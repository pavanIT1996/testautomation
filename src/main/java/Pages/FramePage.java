package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
    private WebDriver driver;

    private String bottomIframe="frame-bottom";
    private String topIframe="frame-top";
    private By Elementtext= By.tagName("body");

    private By nestedFrame= By.linkText("Nested Frames");

    public FramePage(WebDriver driver) {
        this.driver=driver;
    }

    public void clickNestedFrame(){
        driver.findElement(nestedFrame).click();
    }

    private void switchToFrameTop(){
        driver.switchTo().frame(topIframe);
    }

    private void switchToFrameBottom(){
        driver.switchTo().frame(bottomIframe);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }

    public String getTextFromBottom(){
        switchToFrameBottom();
        String text=driver.findElement(Elementtext).getText();
        switchToMainArea();
        return text;
    }

    public String getTextFromTopIndex(int index){
        switchToFrameTop();
        driver.switchTo().frame(index);
        String text=driver.findElement(Elementtext).getText();
        switchToMainArea();
        switchToMainArea();
        return text;
    }

//    public String getTextFromIndex(int index){
//        driver.switchTo().frame(index);
//        String text=driver.findElement(Elementtext).getText();
//        switchToMainArea();
//        return text;
//    }

}
