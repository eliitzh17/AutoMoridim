package pages.abstractPages;

import elements.BasicMediaInfo;
import elements.recommendMedia.Recommends;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.BasicMediaInfo.BASIC_MEDIA_INFO_ID;
import static elements.recommendMedia.Recommends.RECOMMEND_CLASS;
import static org.openqa.selenium.By.id;

/**
 * This class represent all a basic specific media page from 'game of thrones' until 'idm' download manager.
 */
public class MediaPage extends Page
{
    @Getter(lazy = true)
    private final BasicMediaInfo basicMediaInfo = new BasicMediaInfo(getDriver().findElement(id(BASIC_MEDIA_INFO_ID)));
    @Getter(lazy = true)
    private final Recommends recommend = new Recommends(getDriver().findElement(By.className(RECOMMEND_CLASS)));

    public MediaPage(WebDriver driver)
    {
        super(driver);
    }
}