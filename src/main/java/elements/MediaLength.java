package elements;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class MediaLength extends Label
{
    @Getter(lazy = true) private final String hours = webElement.getText().split(":")[0];
    @Getter(lazy = true) private final String minute = webElement.getText().split(":")[1];

    public MediaLength(WebElement element)
    {
        super(element);
    }

    public MediaLength (String liTitleCssSelector, WebDriver driver)
    {
        super(liTitleCssSelector, driver);
    }

    public int getMinuteAmount()
    {
        return parseInt(getMinute()) + (parseInt(getHours()) * 60);
    }
}
