package elements;

import objects.AbstractObject;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utils.Consts.ITEM_IN_LIST_TAG_NAME;

public class Toolbar extends AbstractObject{

    private List<Button> buttons;

    public Toolbar(WebElement webElement) {
        super(webElement);
    }

    public void init()
    {
        if (buttons == null)
        {
            buttons = new ArrayList<Button>();

            for (WebElement element : getWebElement().findElements(By.tagName(ITEM_IN_LIST_TAG_NAME)))
            {
                buttons.add(new Button(element));
            }
        }
    }

    public Button get(int index)
    {
        init();

        return buttons.get(index);
    }

    public List<Button> getButtons()
    {
        init();

        return buttons;
    }
}
