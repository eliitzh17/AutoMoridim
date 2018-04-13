package pages.abstractPages;


import elements.SearchBox;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.SearchBox.*;

public abstract class Page {

    protected WebDriver driver;
    private SearchBox searchBox;

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }

    public void init()
    {
        searchBox = new SearchBox(driver.findElement(By.id(SEARCH_CLASS_ID)));
    }

    public SearchBox getSearchBox()
    {
        init();

        return searchBox;
    }
}
