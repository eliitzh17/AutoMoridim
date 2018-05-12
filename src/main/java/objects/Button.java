package objects;

import org.openqa.selenium.WebElement;

public class Button extends AbstractObject
{
    public Button(WebElement webElement)
    {
        super(webElement);
    }

    public void click() { getWebElement().click();}

    public String getText()
    {
        return getWebElement().getText();
    }
}
