import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * Created by kolchanov on 24.06.15.
 */
public class TestHolder {

    public WebDriver driver;

    private String STRING_MATCH = "level up";

    public TestHolder(){
        driver = new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get("http://www.google.com");
        GoogleSearch googleSearch = new GoogleSearch(driver);
        googleSearch.searchMatching(STRING_MATCH);
    }

    @AfterMethod
    public void stopWebDriver(){
        driver.quit();
    }
}
