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
    @Getter
    private WebDriver driver;

    @Getter(lazy = true)
    private final SearchBox topSearch = new SearchBox(getDriver().findElement(By.id(SEARCH_CLASS_ID)));
    @Getter(lazy = true)
    private final UsersToolbar usersToolbar = new UsersToolbar(getDriver().findElement(By.id(USERS_TOOLBAR_ID)));

    public Page(WebDriver driver)
    {
        this.driver = driver;
    }
}
