package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends AbstractObject
{
    private static String OPTION_TAG_NAME = "option";

    private List<Button> option;

    public void init()
    {
        if (option == null)
        {
            option = new ArrayList<>();

            for (WebElement element : getWebElement().findElements(By.tagName(OPTION_TAG_NAME)))
            {
                option.add(new Button(element));
            }
        }
    }
    public DropDown(WebElement webElement)
    {
        super(webElement);
    }

    public void select(String value)
    {
        init();

        for (Button button : option)
        {
            if (button.getText().equals(value))
            {
                select(option.indexOf(button));
                return;
            }
        }
    }

    public void select(int index)
    {
        init();

        getWebElement().click();

        option.get(index).click();
    }

    public List<Button> getOption()
    {
        return option;
    }
}