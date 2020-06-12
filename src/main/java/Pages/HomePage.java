package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    //private By formAuthenticationLInk = By.linkText("Form Authentication");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    public LoginPage clickFormAuthentication() {
        //driver.findElement(formAuthenticationLInk).click();
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown() {
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public HoversPage clickHovers(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return  new KeyPressesPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSlider(){
        clickLink("Horizontal Slider");
        return  new HorizontalSliderPage(driver);
    }

    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return  new AlertsPage(driver);
    }

    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return  new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAd(){
        clickLink("Entry Ad");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return  new EntryAdPage(driver);
    }

    public ContextMenuPage clickContextMenu(){
        clickLink("Context Menu");
        return  new ContextMenuPage(driver);
    }

    public WYSIWYGPage clickWYSIWYG(){
        clickLink("WYSIWYG Editor");
        return new WYSIWYGPage(driver);
    }

    public FramePage clickFrames(){
        clickLink("Frames");
        return new FramePage(driver);
    }

    public DynamicLoadingPage clickDynamicLoading(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    private void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
