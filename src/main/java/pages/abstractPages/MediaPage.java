package pages.abstractPages;

import elements.BasicMediaInfo;
import org.openqa.selenium.WebDriver;

import static elements.BasicMediaInfo.BASIC_MEDIA_INFO_ID;
import static org.openqa.selenium.By.id;

/**
 * This class represent all a basic specific media page from 'game of thrones' until 'idm' download manager.
 */
public class MediaPage extends Page
{
    public MediaPage(WebDriver driver)
    {
        super(driver);
    }

    protected BasicMediaInfo basicMediaInfo;

    public void init()
    {
        super.init();

        basicMediaInfo = new BasicMediaInfo(driver.findElement(id(BASIC_MEDIA_INFO_ID)));
    }

    public BasicMediaInfo getBasicMediaInfo()
    {
        init();

        return basicMediaInfo;
    }
}