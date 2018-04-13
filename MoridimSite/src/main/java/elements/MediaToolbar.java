package elements;

import enums.BottomMediaToolbarEnum;
import enums.TopMediaToolbarEnum;
import objects.AbstractObject;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class represent the toolbar that give us kind of map in the site.
 */
public class MediaToolbar extends AbstractObject {

    public final static String MEDIA_TOOLBAR_ID = "header";

    private final static String TOP_TOOLBAR_ID = "menu";
    private final static String BOTTOM_ID = "bottomMenu";

    private Toolbar topToolbar;
    private Toolbar bottomToolbar;

    public MediaToolbar(WebElement webElement) {
        super(webElement);
    }

    public void init() {

        topToolbar = new Toolbar(webElement.findElement(By.id(TOP_TOOLBAR_ID)));
        bottomToolbar = new Toolbar(webElement.findElement(By.id(BOTTOM_ID)));
    }

    public Button getButtonOf(TopMediaToolbarEnum mediaButton)
    {
        init();

        return topToolbar.get(mediaButton.getIndex());
    }

    public Button getButtonOf(BottomMediaToolbarEnum mediaButton)
    {
        init();

        return bottomToolbar.get(mediaButton.getIndex());
    }


}