package elements.mainPageElement.siderBarElement;

import elements.AbstractElement;
import lombok.Getter;
import objects.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSideBar extends AbstractElement
{
    @Getter(lazy = true)
    private final Label title = new Label(getWebElement().findElement(By.tagName("h4")));

    /**
     * This constructor get webElement and index of side bar and init the element by the index.
     * No need to 'findElement', just pass the webElement.
     * Index start from 1.
     * */
    public AbstractSideBar(WebDriver driver, int sideBarIndex)
    {
        super(driver.findElements(By.className("siderBar")).get(sideBarIndex - 1));
        this.driver = driver;
    }
}
