package pages.filterPages;

import elements.categoriesSearch.CategoriesSearchWithTabs;
import elements.recommendMedia.Recommends;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.abstractPages.Page;

import static elements.recommendMedia.Recommends.RECOMMEND_CLASS;

public class MainPage extends Page
{
    @Getter(lazy = true)
    private final Recommends recommend = new Recommends(getDriver().findElement(By.className(RECOMMEND_CLASS)));
    @Getter(lazy = true)
    private final CategoriesSearchWithTabs categoriesSearch = new CategoriesSearchWithTabs(getDriver());

    public MainPage(WebDriver driver)
    {
        super(driver);
    }

}