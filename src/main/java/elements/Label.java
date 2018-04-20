package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends AbstractElement
{
    public Label(WebElement element)
    {
        super(element);
    }

    public Label (String liTitleCssSelector, WebDriver driver)
    {
        super(liTitleCssSelector, driver);
    }

    public String getText()
    {
        return webElement.getText();
    }
}
