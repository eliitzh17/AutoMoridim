package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.MyUtils;

public class RadioButton extends AbstractObject
{
    private static String IS_SELECTED_SCRIPT = "return document.getElementById(\"answer-6\").checked;";

    public RadioButton(WebElement webElement)
    {
        super(webElement);
    }

    public void select()
    {
        getWebElement().click();
    }

    public boolean isSelected(WebDriver driver)
    {
       return (boolean) MyUtils.executeJS(this.getWebElement(), driver, IS_SELECTED_SCRIPT);
    }

    public String getValue()
    {
        return getWebElement().getText();
    }
}
