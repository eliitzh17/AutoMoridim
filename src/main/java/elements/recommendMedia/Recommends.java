package elements.recommendMedia;

import elements.AbstractElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.MyUtils.initWebElementList;

/**
 * This element collect list of recommend media,
 * the list is in hes own class cause i didn't find something in common for all class that hold this object
 * and there isn't a point to write all this many time.
 */
public class Recommends extends AbstractElement
{
    public static String RECOMMEND_CLASS = "recommended";

    @Getter(lazy = true)
    private final List<RecommendItem> recommendList = initWebElementList(
            getWebElement().findElements(By.tagName("li")), RecommendItem.class);

    public RecommendItem hoverAndGetRecommend(int index)
    {
        hover();

        getRecommendList().get(index);

        return getRecommendList().get(index);
    }

    public Recommends (WebDriver webDriver)
    {
        super(webDriver, By.className(RECOMMEND_CLASS));
    }

    public Recommends(WebElement webElement)
    {
        super(webElement);
    }
}
