import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import pages.abstractPages.Page;
import utils.enums.PagesUrlsEnum;

import static java.lang.System.setProperty;
import static utils.Consts.MAIN_PAGE_URL;
import static utils.MyUtils.closeLinksPopup;
import static utils.MyUtils.createPageInstance;

@Getter(AccessLevel.PUBLIC)
public class AbstractTest
{
    private WebDriver driver;

    @BeforeEach
    public void settings()
    {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE_URL);
        closeLinksPopup(driver);
    }

    public <T extends Page> T navigateTo(PagesUrlsEnum page)
    {
        driver.get(page.getUrl());

        return createPageInstance(page.getClassName(), getDriver());
    }

    public static void sleep(double second)
    {
        try
        {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void hover(WebElement webElement)
    {
        new Actions(getDriver()).moveToElement(webElement).build().perform();
    }

    @AfterEach
    public void quit()
    {
        driver.quit();
    }
}
