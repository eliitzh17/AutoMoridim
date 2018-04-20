import lombok.AccessLevel;
import lombok.Getter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.abstractPages.Page;
import utils.enums.PagesUrlsEnum;

import static java.lang.System.setProperty;
import static utils.Consts.MAIN_PAGE_URL;
import static utils.Utils.closeLinksPopup;
import static utils.Utils.createPageInstance;

@Getter(AccessLevel.PUBLIC)
public class AbstractTest
{
    protected WebDriver driver;

    @BeforeEach
    public void settings() throws InterruptedException
    {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIN_PAGE_URL);
        closeLinksPopup(driver);
    }

    public <T extends Page> T navigateTo(PagesUrlsEnum page)
    {
        driver.get(page.getUrl());

        return createPageInstance(page.getClassName(), driver);
    }

    @AfterEach
    public void quit()
    {
        driver.quit();
    }
}
