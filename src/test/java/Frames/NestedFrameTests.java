package Frames;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFrameTests extends BaseTest {

    @Test
    public void clickNestedFrame(){
        var nestedFramePage=homepage.clickFrames();
        nestedFramePage.clickNestedFrame();
        String Left=nestedFramePage.getTextFromTopIndex(0);
        String Middle=nestedFramePage.getTextFromTopIndex(1);
        String Right=nestedFramePage.getTextFromTopIndex(2);
        String Bottom=nestedFramePage.getTextFromBottom();

        assertEquals(nestedFramePage.getTextFromTopIndex(0),Left,"Word Incorrect");
        assertEquals(nestedFramePage.getTextFromTopIndex(1),Middle,"Word Incorrect");
        assertEquals(nestedFramePage.getTextFromTopIndex(2),Right,"Word Incorrect");
        assertEquals(nestedFramePage.getTextFromBottom(),Bottom,"Word Incorrect");
    }
}
