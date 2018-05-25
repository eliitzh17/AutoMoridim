package pages.abstractPages;

import lombok.Getter;
import objects.Button;
import objects.Label;
import objects.MediaLength;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MyUtils;

import java.util.List;

public class VideoPage extends MediaPage
{
    private static final String CATEGORIES_END_VALUE_CSS_SELECTOR = "אנרים";
    private static final String CATEGORY_TAG_NAME = "span";

    @Getter(lazy = true)
    private final List<Label> categories = MyUtils.initWebElementList(getDriver().findElement(
            By.cssSelector("li[title$='" + CATEGORIES_END_VALUE_CSS_SELECTOR + "']")).findElements(
            By.tagName(CATEGORY_TAG_NAME)), Label.class);
    @Getter(lazy = true)
    private final Label yearCreation = new Label("יציאה", getDriver());
    @Getter(lazy = true)
    private final Label lastActivity = new Label(getDriver().findElement(By.xpath(".//div[1]/p/b")));
    @Getter(lazy = true)
    private final MediaLength videoLength = new MediaLength("אורך", getDriver());
    @Getter(lazy = true)
    private final Button imdbRating = new Button(getDriver().findElement(By.id("imdbRating")));
    @Getter(lazy = true)
    private final Label voteNumber = new Label("צפיות", getDriver());

    public VideoPage(WebDriver driver)
    {
        super(driver);
    }
}