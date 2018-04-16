package pages.abstractPages;

import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class VideoPage extends MediaPage
{
    private static final String CATEGORIES_END_VALUE_CSS_SELECTOR = "אנרים";
    private static final String CATEGORY_TAG_NAME = "span";

    private List<String> categories;
    private int videoLength;
    private Button imdbRating;

    public VideoPage(WebDriver driver)
    {
        super(driver);
    }

    public void init()
    {
        super.init();

        initCategories();
    }

    private void initCategories()
    {

        if (categories == null)
        {

            categories = new ArrayList<String>();

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

    public int getVideoLength()
    {
        init();

        return videoLength;
    }

    public Button getImdbRating()
    {
        init();

        return imdbRating;
    }
}
