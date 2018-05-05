package pages.specificPage;

import elements.categoriesSearch.CategoriesSearch;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.abstractPages.Page;

public class SearchResultPage extends Page
{
    @Getter(lazy = true)
    private final CategoriesSearch categoriesSearch = new CategoriesSearch(getDriver());

    public SearchResultPage(WebDriver driver)
    {
        super(driver);
    }
}
