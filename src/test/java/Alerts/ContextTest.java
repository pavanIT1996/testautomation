package Alerts;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextTest extends BaseTest {

    @Test
    public void testContextClick(){
        var contextPage=homepage.clickContextMenu();
        contextPage.rightClickOnHotSport();
        assertEquals(contextPage.alert_getText(), "You selected a context menu","Result Text Incorrect");
        contextPage.alert_clickToAccept();
    }
}
