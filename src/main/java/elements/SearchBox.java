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

import java.util.ArrayList;
import java.util.List;

import static utils.Consts.FIRST_ITEM;
import static utils.Consts.ITEM_IN_LIST_TAG_NAME;
import static utils.MyUtils.createPageInstance;
import static utils.MyUtils.getPageCategoryFromUrl;
import static utils.enums.PagesUrlsEnum.getEnumBySpecificPageName;

public class SearchBox extends AbstractObject
{
    public final static String SEARCH_CLASS_ID = "topSearch";

    @Getter(lazy = true)
    private final InputBox input = new InputBox(getWebElement().findElement(By.className("searchInput")));
    @Getter(lazy = true)
    private final Button searchButton = new Button(getWebElement().findElement(By.tagName("button")));

    private List<Button> instanceResult;

    public SearchBox(WebElement webElement)
    {
        super(webElement);
    }

    public void initInstanceResult()
    {
        instanceResult = new ArrayList<>();

        for (WebElement element : getWebElement().findElements(By.tagName(ITEM_IN_LIST_TAG_NAME)))
        {
            instanceResult.add(new Button(element));
        }
    }

    public SearchResultPage search(String str, WebDriver driver)
    {
        getInput().write(str);
        getSearchButton().click();

        return new SearchResultPage(driver);
    }

    public <T extends MediaPage> T enterFirstResult(String value, WebDriver driver)
    {
        getInput().write(value);
        getInstanceResult().get(FIRST_ITEM).click();

        return createPageInstance(getEnumBySpecificPageName(getPageCategoryFromUrl(driver)).getClassName(), driver);
    }

    public List<Button> getInstanceResult()
    {
        initInstanceResult();

        return instanceResult;
    }
}