package pages.abstractPages;


import elements.SearchBox;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public abstract class Page
{
    protected WebDriver driver;

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }

    private SearchBox searchBox;

    public void init()
    {
        searchBox = new SearchBox(driver.findElement(By.id(SearchBox.SEARCH_CLASS_ID)));
    }

    public SearchBox getSearchBox()
    {
        init();

        return this.searchBox;
    }
}
