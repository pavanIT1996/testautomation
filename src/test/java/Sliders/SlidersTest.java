package Sliders;

import Base.BaseTest;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class SlidersTest extends BaseTest {

    @Test
    public void testSlider(){
        var SliderPage = homepage.clickHorizontalSlider();
        SliderPage.clickSlider();
        SliderPage.enterSlider(4);
    }

}
