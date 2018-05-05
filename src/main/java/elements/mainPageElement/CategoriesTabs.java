package elements.mainPageElement;

import elements.AbstractElement;
import lombok.Getter;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CategoriesTabs extends AbstractElement
{
    public static String CATEGORIES_TABS_ID = "categories";

    @Getter(lazy = true)
    private final List<Button> option = initOption();

    public CategoriesTabs(WebElement element)
    {
        super(element);
    }

    private List<Button> initOption()
    {
        List<Button> temp = new ArrayList<>();

        for (WebElement element : getWebElement().findElements(By.tagName("li")))
        {
            if (!element.getAttribute("class").equals("separator"))
            {
                temp.add(new Button(element));
            }
        }

        return temp;
    }

    public String getSelected()
    {
        for (WebElement element : getWebElement().findElements(By.tagName("li")))
        {
            if (element.getAttribute("class").contains("selected"))
            {
                return element.getText();
            }
        }

        return null;
    }

    public void goToTab(String tabName)
    {
        for (Button button : getOption())
        {
            if (button.getText().equals(tabName))
            {
                button.click();
                return;
            }
        }
    }
}
