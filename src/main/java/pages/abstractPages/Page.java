package pages.abstractPages;

import elements.SearchBox;
import elements.UsersToolbar;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static elements.SearchBox.SEARCH_CLASS_ID;
import static elements.UsersToolbar.USERS_TOOLBAR_ID;

@Getter
public class Page
{
    protected WebDriver driver;

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }

    @Getter(lazy = true)
    private final SearchBox searchBox = new SearchBox(driver.findElement(By.id(SEARCH_CLASS_ID)));
    @Getter(lazy = true)
    private final UsersToolbar usersToolbar = new UsersToolbar(driver.findElement(By.id(USERS_TOOLBAR_ID)));
}
