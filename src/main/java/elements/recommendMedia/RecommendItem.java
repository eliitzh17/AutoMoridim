package elements.recommendMedia;

import elements.AbstractElement;
import lombok.Getter;
import objects.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstractPages.MediaPage;

import java.util.List;

import static utils.MyUtils.createPageInstance;
import static utils.MyUtils.getPageCategoryFromUrl;
import static utils.enums.PagesUrlsEnum.getEnumBySpecificPageName;

public class RecommendItem extends AbstractElement
{
    @Getter(lazy = true)
    private final Label movieName = new Label(getWebElement().findElement(By.xpath("./a/div/span/h3")));
    private final Label description = new Label(getWebElement().findElement(By.xpath("./a/div/span")));

    @Getter(lazy = true)
    private final Label views = initContentLineDetails(2);
    @Getter(lazy = true)
    private final Label creationYear = initContentLineDetails(1);

    protected Label initContentLineDetails(int indexFromLast)
    {
        List<WebElement> elements = getWebElement().findElement(By.className("contentLineDetails")).findElements(
                By.tagName("span"));

        return new Label(elements.get(elements.size() - indexFromLast));
    }


    public RecommendItem(WebElement element)
    {
        super(element);
    }

    public <T extends MediaPage> T navigate(WebDriver driver)
    {
        getWebElement().click();

        return createPageInstance(getEnumBySpecificPageName(getPageCategoryFromUrl(driver)).getClassName(), driver);
    }

    public String getDescription()
    {
        return description.getText().split("\n")[1];
    }
}
