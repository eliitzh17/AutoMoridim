import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageNavigator;

import static java.lang.Thread.sleep;

@Getter
public class AbstractTest {

    public static void main(String[] args) {
        AbstractTest a = new AbstractTest();
        a.getURL();
    }
    @Getter(AccessLevel.PUBLIC) String URL = "https://www.moridim.tv/";
    protected WebDriver driver;
	protected PageNavigator pageNavigator;

    @BeforeEach
    public void settings() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "c:\\Users\\Asor\\Downloads\\Project\\Resource\\chromedriver.exe");
        driver = new ChromeDriver();
        pageNavigator = new PageNavigator(driver);
        driver.manage().window().maximize();
        driver.get(URL);
        closePopup(driver);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    public void wait(int second)
    {

    }

    public static void closePopup(WebDriver driver)
    {
        if (driver.findElement(By.id("boxBg")).isDisplayed()) {
            driver.findElement(By.className("close")).click();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
