import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by kolchanov on 02.06.15.
 */



public class TestGoogleSearch {

    private WebDriver driver;

    @BeforeMethod
    public void startWebDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test(){

        driver.get("http://www.google.com");

        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys("Level Up");
        search.submit();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> searchString = driver.findElements(By.xpath("//a[contains(.,'Level Up') or contains(.,'level up') or contains(.,'Level UP')]"));
        for(WebElement element: searchString){
            Assert.assertNotEquals(-1, element.getText().toLowerCase().indexOf("level up"));
        }

    }

    @AfterMethod
    public void stopWebDriver(){
        driver.close();
        driver.quit();
    }

}
