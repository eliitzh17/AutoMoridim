package elements;

import objects.AbstractObject;
import objects.Button;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.abstractPages.MediaPage;
import pages.specificPage.SearchResultPage;
import utils.enums.PagesUrlsEnum;

import java.util.ArrayList;
import java.util.List;

import static utils.Consts.FIRST_ITEM;
import static utils.Consts.ITEM_IN_LIST_TAG_NAME;
import static utils.Utils.createPageInstance;
import static utils.Utils.getPageCategoryFromUrl;
import static utils.enums.PagesUrlsEnum.getEnumBySpecificPageName;

public class SearchBox extends AbstractObject
{
    public final static String SEARCH_CLASS_ID = "topSearch";

    private final static String SEARCH_INPUT_CLASS_NAME = "searchInput";
    private final static String SEARCH_BUTTON_TAG_NAME = "button";

    private InputBox input;
    private Button searchButton;
    private List<Button> instanceResult;

    public SearchBox(WebElement webElement)
    {
        super(webElement);
    }

    public void init()
    {
        searchButton = new Button(webElement.findElement(By.tagName(SEARCH_BUTTON_TAG_NAME)));
        input = new InputBox(webElement.findElement(By.className(SEARCH_INPUT_CLASS_NAME)));
    }

    public void initInstanceResult()
    {
        instanceResult = new ArrayList<>();

        for (WebElement element : webElement.findElements(By.tagName(ITEM_IN_LIST_TAG_NAME)))
        {
            instanceResult.add(new Button(element));
        }
    }

    public SearchResultPage search(String str, WebDriver driver)
    {
        init();

        input.write(str);
        searchButton.click();

        return new SearchResultPage(driver);
    }

    public <T extends MediaPage> T enterFirstResult(String value, WebDriver driver)
    {
        init();

        input.write(value);
        getInstanceResult().get(FIRST_ITEM).click();

        return createPageInstance(getEnumBySpecificPageName(getPageCategoryFromUrl(driver)).getClassName(), driver);
    }

    public List<Button> getInstanceResult()
    {
        initInstanceResult();

        return instanceResult;
    }


}
