package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractElement
{
    protected WebElement webElement;

    public AbstractElement (WebElement element)
    {
        this.webElement = element;
    }

    public AbstractElement (String liTitleCssSelector, WebDriver driver)
    {
        webElement = driver.findElement(By.cssSelector("[title*='" + liTitleCssSelector + "']"));
    }
}
