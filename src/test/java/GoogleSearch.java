import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by kolchanov on 02.06.15.
 */
public class GoogleSearch {

        @FindBy(name = "q")
        private WebElement searchBox;

        @FindBy(xpath = "//a[contains(.,'Level Up') or contains(.,'level up') or contains(.,'Level UP')]")
        @CacheLookup
        private List<WebElement> searchString;

        public GoogleSearch(WebDriver driver) {

            PageFactory.initElements(driver, this);

        }

        public void searchMatching( String match) {
            searchBox.sendKeys(match);
            for (WebElement element : searchString) {
                Assert.assertTrue(element.getText().toLowerCase().contains(match));
            }
        }

}
