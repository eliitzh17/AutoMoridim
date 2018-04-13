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
            webElement.sendKeys(valueOf(sequence));
            wait(0.5);
        }

        return this;
    }

    public InputBox delete()
    {
        webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        webElement.sendKeys(Keys.BACK_SPACE);

        return this;
    }

    public void focus() {
        webElement.sendKeys("");
    }
}
