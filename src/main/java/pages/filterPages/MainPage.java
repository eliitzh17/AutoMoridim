package pages.filterPages;

import elements.CategorySearch;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.abstractPages.Page;

import static elements.CategorySearch.CATEGORY_SEARCH_ID;

public class MainPage extends Page
{
    @Getter(lazy = true)
    private final CategorySearch categorySearch = new CategorySearch(driver.findElement(By.id(CATEGORY_SEARCH_ID)));

    public MainPage(WebDriver driver)
    {
        super(driver);
    }

}