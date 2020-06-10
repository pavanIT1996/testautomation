package Alerts;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    public void testFileUpload(){
        var fileUploadPage=homepage.clickFileUpload();
        fileUploadPage.uploadFIle("F:/Pictures/Background Pictures/3D-Abstract-Lion-Wallpapers.jpg");
        fileUploadPage.clickUploadButton();
        assertEquals(fileUploadPage.getUploadedFiles(),"3D-Abstract-Lion-Wallpapers.jpg","Uploaded File Incorrect");
    }
}
