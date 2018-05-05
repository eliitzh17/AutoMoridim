package elements.categoriesSearch;

import elements.AbstractElement;
import elements.SearchResultItem;
import elements.mainPageElement.CategorySearchToolbar;
import lombok.Getter;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static elements.SearchResultItem.SEARCH_RESULT_ITEM_CLASS_NAME;
import static elements.mainPageElement.CategorySearchToolbar.CATEGORY_SEARCH_ID;

public class CategoriesSearch extends AbstractElement
{
    public static final String CATEGORIES_SEARCH_ID = "right";

    @Getter(lazy = true)
    private final CategorySearchToolbar searchToolbar = new CategorySearchToolbar(
            getWebElement().findElement(By.id(CATEGORY_SEARCH_ID)));
    private List<SearchResultItem> searchResult;
    @Getter(lazy = true)
    private final Button loadMoreButton = new Button(getWebElement().findElement(By.className("loadMore")));

    public CategoriesSearch(WebElement element)
    {
        super(element);
    }

    public CategoriesSearch(WebDriver driver)
    {
        super(driver.findElement(By.id(CATEGORIES_SEARCH_ID)));
    }

    private void initList()
    {
        if (searchResult == null)
        {
            searchResult = new ArrayList<>();
        }

        sleep(1);

        for (WebElement element : getWebElement().findElements(By.className(SEARCH_RESULT_ITEM_CLASS_NAME)))
        {
            if (!this.contains(element))
            {
                searchResult.add(new SearchResultItem(element));
            }
        }
    }

    private boolean contains(final WebElement element)
    {
        return searchResult.stream().anyMatch(thisElement -> thisElement.getWebElement().equals(element));
    }

    public List<SearchResultItem> getSearchResult()
    {
        initList();

        return searchResult;
    }
}
