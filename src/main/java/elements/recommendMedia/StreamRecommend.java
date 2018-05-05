package elements.recommendMedia;

import lombok.Getter;
import objects.Label;
import org.openqa.selenium.WebElement;

public class StreamRecommend extends RecommendItem
{
    @Getter(lazy = true)
    private final Label imdbRatting = initContentLineDetails(3);

    public StreamRecommend(WebElement element)
    {
        super(element);
    }
}
