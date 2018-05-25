package objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class InputBox extends AbstractObject
{

    public InputBox(WebElement webElement)
    {
        super(webElement);
    }

    public InputBox write(String str)
    {
        getWebElement().sendKeys(str);

        return this;
    }

    public InputBox delete()
    {
        getWebElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getWebElement().sendKeys(Keys.BACK_SPACE);

        return this;
    }

    public void focus()
    {
        getWebElement().sendKeys("");
    }

    public String getText()
    {
        return getWebElement().getText();
    }

    public void clear()
    {
        getWebElement().clear();
    }
}
