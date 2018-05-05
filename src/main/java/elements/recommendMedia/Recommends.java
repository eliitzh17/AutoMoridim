package elements.recommendMedia;

import elements.AbstractElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This element collect list of recommend media,
 * the list is in hes own class cause i didn't find something in common for all class that hold this object
 * and there isn't a point to write all this many time.
 */
public class Recommends extends AbstractElement
{
    public static String RECOMMEND_CLASS = "recommended";

    @Getter(lazy = true)
    private final List<RecommendItem> recommendList = initList();

    public Recommends(WebElement element)
    {
        super(element);
    }

    private List<RecommendItem> initList()
    {
        List<RecommendItem> tempList = new ArrayList<>();

        for (WebElement element : getWebElement().findElements(By.tagName("li")))
        {
            tempList.add(new RecommendItem(element));
        }

        return tempList;
    }
}
