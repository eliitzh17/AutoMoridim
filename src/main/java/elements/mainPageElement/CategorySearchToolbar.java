package elements.mainPageElement;

import elements.AbstractElement;
import lombok.Getter;
import objects.Button;
import objects.DropDown;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;

public class CategorySearchToolbar extends AbstractElement
{
    public static String CATEGORY_SEARCH_ID = "search";

    @Getter(lazy = true)
    private final InputBox searchBox = new InputBox(getWebElement().findElement(id("searchInput")));
    @Getter(lazy = true)
    private final DropDown categories = new DropDown(getWebElement().findElement(name("table")));
    @Getter(lazy = true)
    private final DropDown type = new DropDown(getWebElement().findElement(name("type")));
    @Getter(lazy = true)
    private final Button searchButton = new Button(getWebElement().findElement(By.tagName("button")));

    public CategorySearchToolbar(WebElement element)
    {
        super(element);
    }
}
