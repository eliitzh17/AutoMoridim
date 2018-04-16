package objects;

import org.openqa.selenium.WebElement;

public class Button extends AbstractObject
{
    public Button(WebElement webElement)
    {
        super(webElement);
    }

    public void click() { webElement.click();}

    public String getText()
    {
        return webElement.getText();
    }
}
