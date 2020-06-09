package Alerts;

import Base.BaseTest;
import Pages.HomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTest {

    @Test
    public  void testAcceptAlert(){
        var alertsPage= homepage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfuly clicked an alert","Result Text Incorrect");
    }

    @Test
    public  void testGetTextFromAlert(){
        var alertsPage=homepage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text=alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public  void testSetInputInAlert(){
        var alertsPage=homepage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text="TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(),"You entered: "+text,"Alert text incorrect");
    }
}
