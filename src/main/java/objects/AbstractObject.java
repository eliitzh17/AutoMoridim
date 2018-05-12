package objects;

import lombok.Getter;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class AbstractObject
{
    @Getter
    private WebElement webElement;

    public void wait(double s)
    {
        try
        {
            sleep((int) (s * 1000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public AbstractObject(WebElement webElement)
    {
        this.webElement = webElement;
    }
}
