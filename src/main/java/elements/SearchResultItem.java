package elements;

import lombok.Getter;
import objects.Button;
import objects.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstractPages.MediaPage;

import java.util.List;

import static utils.MyUtils.*;
import static utils.enums.PagesUrlsEnum.getEnumBySpecificPageName;

public class SearchResultItem extends AbstractElement
{
    public static final String SEARCH_RESULT_ITEM_CLASS_NAME = "download";

    @Getter(lazy = true)
    private final Button titleButton = new Button(getWebElement().findElement(By.partialLinkText("")));
    @Getter(lazy = true)
    private final Label hebrewName = new Label(getWebElement().findElements(By.tagName("h4")).get(0));
    @Getter(lazy = true)
    private final Label englishName = new Label(getWebElement().findElements(By.tagName("h4")).get(1));
    @Getter(lazy = true)
    private final List<Label> categoriesList = initWebElementList(
            getWebElement().findElement(By.className("text")).findElements(By.tagName("p")), Label.class);
    @Getter(lazy = true)
    private final Label subtitleContext = new Label(getWebElement().findElement(By.className("blueBar")));
    @Getter(lazy = true)
    private final Label bestQuality = new Label(getWebElement().findElement(By.className("orangeBar")));
    @Getter(lazy = true)
    private final Label description = new Label(
            getWebElement().findElement(By.className("text")).findElements(By.tagName("p")).get(2));
    @Getter(lazy = true)
    private final int imdbRate = Integer.valueOf(initBottomElement(0).getText());
    @Getter(lazy = true)
    private final int creationYear = Integer.valueOf(initBottomElement(1).getText());
    @Getter(lazy = true)
    private final Label lastActivity = new Label(initBottomElement(2));
    @Getter(lazy = true)
    private final int voteNumber = Integer.valueOf(initBottomElement(3).getText());

    public SearchResultItem(WebElement element)
    {
        super(element);
    }

    private WebElement initBottomElement(int index)
    {
        return getWebElement().findElement(By.className("bottom")).findElements(By.tagName("b")).get(index);
    }

    public <T extends MediaPage> T navigate(WebDriver driver)
    {
        getTitleButton().click();

        return createPageInstance(getEnumBySpecificPageName(getPageCategoryFromUrl(driver)).getClassName(), driver);
    }
}
