package elements;

import lombok.Getter;
import objects.AbstractObject;
import objects.Button;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstractPages.MediaPage;
import pages.specificPage.SearchResultPage;

import java.util.List;

import static java.lang.String.valueOf;
import static utils.Consts.FIRST_ITEM;
import static utils.Consts.ITEM_IN_LIST_TAG_NAME;
import static utils.MyUtils.*;
import static utils.enums.PagesUrlsEnum.getEnumBySpecificPageName;

public class SearchBox extends AbstractObject
{
    public final static String SEARCH_CLASS_ID = "topSearch";

    @Getter(lazy = true)
    private final InputBox searchBox = new InputBox(getWebElement().findElement(By.className("searchInput")));
    @Getter(lazy = true)
    private final Button searchButton = new Button(getWebElement().findElement(By.tagName("button")));

    public SearchBox(WebElement webElement)
    {
        super(webElement);
    }

    public SearchResultPage search(String str, WebDriver driver)
    {
        write(str);
        getSearchButton().click();

        return new SearchResultPage(driver);
    }

    public <T extends MediaPage> T enterFirstResult(String value, WebDriver driver)
    {
        write(value);
        getInstanceResult().get(FIRST_ITEM).click();

        return createPageInstance(getEnumBySpecificPageName(getPageCategoryFromUrl(driver)).getClassName(), driver);
    }

    // Because its instance result, so almost there isn't reason to save it in local variable.
    public List<Button> getInstanceResult()
    {
        return initWebElementList(getWebElement().findElements(By.tagName(ITEM_IN_LIST_TAG_NAME)),
                                  Button.class);
    }

    // Rewrite this method (method in searchBox object) cause the instance result delay.
    public void write(String str)
    {
        for (char sequence : str.toCharArray())
        {
            getSearchBox().write(valueOf(sequence));
            wait(0.8);
        }
    }

    public void clear()
    {
        getSearchBox().getWebElement().clear();
    }
}