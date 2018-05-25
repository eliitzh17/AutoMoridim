package elements.mainPageElement.siderBarElement;

import lombok.Getter;
import objects.AbstractObject;
import objects.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PoplarItem extends AbstractObject
{
    @Getter(lazy = true)
    private final Label title = new Label(getWebElement().findElement(By.tagName("h4")));
    @Getter(lazy = true)
    private final Label description = new Label(getWebElement().findElements(By.tagName("p")).get(0));
    @Getter(lazy = true)
    private final Integer views = Integer.valueOf(
            getWebElement().findElements(By.tagName("p")).get(1).findElements(By.tagName("b")).get(0).getText());
    @Getter (lazy = true)
    private final Integer createYear = Integer.valueOf(
            getWebElement().findElements(By.tagName("p")).get(1).findElements(By.tagName("b")).get(1).getText());

    public PoplarItem(WebElement webElement)
    {
        super(webElement);
    }
}
