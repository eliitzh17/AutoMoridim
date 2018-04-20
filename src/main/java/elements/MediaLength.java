package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.parseInt;

public class MediaLength extends Label
{
    private String hours;
    private String minute;

    public MediaLength(WebElement element)
    {
        super(element);
    }

    public MediaLength (String liTitleCssSelector, WebDriver driver)
    {
        super(liTitleCssSelector, driver);
    }

    public void init()
    {
         hours = hours == null ? webElement.getText().split(":")[0] : hours;
            minute = minute == null ? webElement.getText().split(":")[1] : minute;
    }

    public String getHours()
    {
        init();

        return hours;
    }

    public String getMinute()
    {
        init();

        return minute;
    }

    public int getMinuteAmount()
    {
        init();

        return parseInt(minute) + (parseInt(hours) * 60);
    }
}
