package elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MyUtils;

public class AbstractElement
{
    private WebElement webElement;
    @Getter
    protected WebDriver driver;
    @Getter
    private By by;

    public AbstractElement(WebElement element)
    {
        this.webElement = element;
    }

    public AbstractElement(WebDriver driver, By by)
    {
        this.driver = driver;
        this.by = by;
    }

    public AbstractElement(String liTitleCssSelector, WebDriver driver)
    {
        webElement = driver.findElement(By.cssSelector("[title*='" + liTitleCssSelector + "']"));
    }

    public WebElement getWebElement()
    {
        if (webElement == null)
        {
            webElement = driver.findElement(by);
        }

        return webElement;
    }

    protected void sleep(double second)
    {
        try
        {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void hover()
    {
        MyUtils.hoverElement(getDriver(), getWebElement());
    }
}
