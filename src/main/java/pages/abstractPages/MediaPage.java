package pages.abstractPages;

import elements.BasicMediaInfo;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static elements.BasicMediaInfo.BASIC_MEDIA_INFO_ID;
import static org.omg.CORBA.ORB.init;
import static org.openqa.selenium.By.id;

/**
 * This class represent all a basic specific media page from 'game of thrones' until 'idm' download manager.
 */
public class MediaPage extends Page
{
    @Getter(lazy = true)
    private final BasicMediaInfo basicMediaInfo = new BasicMediaInfo(driver.findElement(id(BASIC_MEDIA_INFO_ID)));

    public MediaPage(WebDriver driver)
    {
        super(driver);
    }
}