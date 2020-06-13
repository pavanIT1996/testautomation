package JavaScript;

import Base.BaseTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollToTable(){
        homepage.clickLargeDeepDomPage().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraphs(){
        homepage.clickInfiniteScroll().scrollToParagraph(5);
    }

    @Test
    public void testDropDown(){
        var dropDownPage = homepage.clickDropDown();
        dropDownPage.addMultipleAttribute();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropDownPage::selectFromDropdown);

        var selectedOptions = dropDownPage.getSelectedOptions();
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
        assertEquals(selectedOptions.size(), optionsToSelect.size(), "Number of selected items");
    }
}
