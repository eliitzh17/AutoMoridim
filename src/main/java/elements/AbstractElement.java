package elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractElement
{
    @Getter
    private WebElement webElement;

    public AbstractElement (WebElement element)
    {
        this.webElement = element;
    }

    public AbstractElement (String liTitleCssSelector, WebDriver driver)
    {
        webElement = driver.findElement(By.cssSelector("[title*='" + liTitleCssSelector + "']"));
    }

    protected void sleep (double second)
    {
        try
        {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
