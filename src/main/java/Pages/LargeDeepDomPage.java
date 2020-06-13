package Pages;

import org.openqa.selenium.*;

public class LargeDeepDomPage {
    private WebDriver driver;

    private By table=By.id("large-table");

    public LargeDeepDomPage(WebDriver driver) {
        this.driver=driver;
    }

    public void scrollToTable(){
        WebElement tableElement=driver.findElement(table);
        String script="arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script,tableElement);
    }
}
