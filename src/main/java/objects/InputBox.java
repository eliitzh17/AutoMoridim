package objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static java.lang.String.valueOf;

public class InputBox extends AbstractObject {

    public InputBox(WebElement webElement) {
        super(webElement);
    }

    public InputBox write(String str)
    {
        for (char sequence : str.toCharArray())
        {
            getWebElement().sendKeys(valueOf(sequence));
            wait(0.8);
        }

        return this;
    }

    public InputBox delete()
    {
        getWebElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        getWebElement().sendKeys(Keys.BACK_SPACE);

        return this;
    }

    public void focus() {
        getWebElement().sendKeys("");
    }

    public String getText()
    {
        return getWebElement().getText();
    }
}
