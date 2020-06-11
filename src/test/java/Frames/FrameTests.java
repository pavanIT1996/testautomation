package Frames;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTest {

    @Test
    public void testWysiwyg(){
        var editorPage=homepage.clickWYSIWYG();
        editorPage.clearTextArea();
        String text1="Hello ";
        String text2="World!";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),text1+text2,"Text Frame word Incorrect");

    }
}
