package elements.categoriesSearch;

import elements.mainPageElement.CategoriesTabs;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.mainPageElement.CategoriesTabs.CATEGORIES_TABS_ID;

public class CategoriesSearchWithTabs extends CategoriesSearch
{
    @Getter(lazy = true)
    private final CategoriesTabs categoriesTabs = new CategoriesTabs(
            getWebElement().findElement(By.id(CATEGORIES_TABS_ID)));

    public CategoriesSearchWithTabs(WebDriver driver)
    {
        super(driver.findElement(By.id(CATEGORIES_SEARCH_ID)));
    }
}
