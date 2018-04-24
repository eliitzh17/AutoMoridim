package elements;

import lombok.Getter;
import objects.Button;
import objects.DropDown;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;

public class CategorySearch extends AbstractElement
{
    public static String CATEGORY_SEARCH_ID = "search";

    @Getter(lazy = true) private final InputBox searchBox = new InputBox(webElement.findElement(id("searchInput")));
    @Getter(lazy = true) private final DropDown categories = new DropDown(webElement.findElement(name("table")));
    @Getter(lazy = true) private final DropDown type = new DropDown(webElement.findElement(name("type")));
    @Getter(lazy = true) private final Button searchButton = new Button(webElement.findElement(By.tagName("button")));

    public CategorySearch(WebElement element)
    {
        super(element);
    }
}
