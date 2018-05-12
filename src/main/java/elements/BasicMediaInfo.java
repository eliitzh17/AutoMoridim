package elements;

import lombok.Getter;
import objects.AbstractObject;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.valueOf;
import static org.openqa.selenium.By.tagName;
import static utils.MyUtils.deleteDirectWatchHebrewSentence;
import static utils.MyUtils.deleteDownloadHebrewSentence;

public class BasicMediaInfo extends AbstractObject
{
    public static final String BASIC_MEDIA_INFO_ID = "right";

    private static final String TITLE_ID = "title";

    @Getter(lazy = true)
    private final String hebrewName = deleteDirectWatchHebrewSentence(
            getWebElement().findElement(By.id(TITLE_ID)).findElement(tagName("h1")).getText());
    @Getter(lazy = true)
    private final String englishName = deleteDownloadHebrewSentence(
            getWebElement().findElement(By.id(TITLE_ID)).findElement(tagName("h2")).getText());
    @Getter(lazy = true)
    private final int year = valueOf(
            getWebElement().findElement(By.cssSelector("span[title='שנת יציאה']")).getText());
    @Getter(lazy = true)
    private final String mediaDescription = getWebElement().findElement(By.id("plot")).getText();
    @Getter(lazy = true)
    private final int views = valueOf(
            getWebElement().findElement(By.cssSelector("span[title='צפיות']")).getText());
    @Getter(lazy = true)
    private final Button vote = new Button(getWebElement().findElement(By.className("thumbsUp")));
    @Getter(lazy = true)
    private final Button addToMyLibrary = new Button(getWebElement().findElement(By.className("favorites")));

    public BasicMediaInfo(WebElement webElement)
    {
        super(webElement);
    }
}