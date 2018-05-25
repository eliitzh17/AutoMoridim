package objects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.MyUtils;

import java.util.List;

public class DropDown extends AbstractObject
{
    private static String OPTION_TAG_NAME = "option";

    @Getter(lazy = true)
    private final List<Button> option = MyUtils.initWebElementList(
            getWebElement().findElements(By.tagName(OPTION_TAG_NAME)), Button.class);

    public DropDown(WebElement webElement)
    {
        super(webElement);
    }

    public void select(String value)
    {
        for (Button button : getOption())
        {
            if (button.getText().equals(value))
            {
                select(getOption().indexOf(button));
                return;
            }
        }
    }

    public void select(int index)
    {
        getWebElement().click();

        getOption().get(index).click();
    }
}