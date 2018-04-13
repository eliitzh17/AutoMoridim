package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class AbstractObject {

    protected WebElement webElement;

    public void wait(double s)
    {
        try {
            sleep((int) (s * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public AbstractObject(WebElement webElement)
    {
        this.webElement = webElement;
    }
}
