package pages.abstractPages;

import elements.Label;
import elements.MediaLength;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class VideoPage extends MediaPage
{
    private static final String CATEGORIES_END_VALUE_CSS_SELECTOR = "אנרים";
    private static final String CATEGORY_TAG_NAME = "span";
    private static final String YEAR_CREATION_TITLE = "יציאה";
    private static final String LAST_ACTIVITY_XPATH = ".//div[1]/p/b";
    private static final String VIDEO_LENGTH_TITLE = "אורך";
    private static final String IAMB_RATTING_ID = "imdbRating";
    private static final String VOTE_TITLE = "צפיות";

    private List<String> categories;
    private Label yearCreation;
    private Label lastActivity;
    private MediaLength videoLength;
    private Button imdbRating;
    private Label voteNumber;

    public VideoPage(WebDriver driver)
    {
        super(driver);
    }

    public void init()
    {
        super.init();

        initCategories();
        yearCreation = yearCreation == null ? new Label(YEAR_CREATION_TITLE, driver) : yearCreation;
        lastActivity = lastActivity == null ? new Label(
                driver.findElement(By.xpath(LAST_ACTIVITY_XPATH))) : lastActivity;
        videoLength = videoLength == null ? new MediaLength(VIDEO_LENGTH_TITLE, driver) : videoLength;
        imdbRating = imdbRating == null ? new Button(driver.findElement(By.id(IAMB_RATTING_ID))) : imdbRating;
        voteNumber = voteNumber == null ? new Label(VOTE_TITLE, driver) : voteNumber;
    }

    private void initCategories()
    {
        if (categories == null)
        {
            categories = new ArrayList<>();

            for (WebElement element : driver.findElement(
                    By.cssSelector("li[title$='" + CATEGORIES_END_VALUE_CSS_SELECTOR + "']")).findElements(
                    By.tagName(CATEGORY_TAG_NAME)))
            {
                categories.add(element.getText());
            }
        }
    }

    public List<String> getCategories()
    {
        init();

        return categories;
    }

    public int getYearCreation()
    {
        init();

        return Integer.parseInt(yearCreation.getText());
    }

    public MediaLength getVideoLength()
    {
        init();

        return videoLength;
    }

    public Button getImdbRating()
    {
        init();

        return imdbRating;
    }

    public String getLastActivity()
    {
        init();

        return lastActivity.getText();
    }

    public int getVoteNumber()
    {
        init();

        return Integer.parseInt(voteNumber.getText());
    }
}
