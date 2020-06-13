package Navigation;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigator(){
        homepage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTo(){
        homepage.clickMultipleWindow().clickHere();
        getWindowManager().switchToTab("New Window");

    }

    @Test
    public void testSwitchTo2(){
        var buttonPage = homepage.clickDynamicLoading().rightClickxample1();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");

    }
}
