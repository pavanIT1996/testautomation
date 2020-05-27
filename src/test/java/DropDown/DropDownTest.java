package DropDown;

import Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDownTest extends BaseTest {
    @Test
    public void testSelectOption(){
        var dropDownpPage=homepage.clickDropDown();
        String option="Option 1";
        dropDownpPage.selectFromDropdown(option);
        var selectedOptions=dropDownpPage.getSelectedOptions();
        assertEquals(selectedOptions.size(),1,"Incorrect Number Of Selections");
        assertTrue(selectedOptions.contains(option),"Option Not Selected");
    }
}
