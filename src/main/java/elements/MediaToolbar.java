package elements;

import lombok.Getter;
import utils.enums.BottomMediaToolbarEnum;
import utils.enums.TopMediaToolbarEnum;
import objects.AbstractObject;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * This class represent the toolbar that give us kind of map in the site.
 */
public class MediaToolbar extends AbstractObject
{
    public final static String MEDIA_TOOLBAR_ID = "header";

    @Getter(lazy = true)
    private final Toolbar topToolbar = new Toolbar(webElement.findElement(By.id("menu")));
    @Getter(lazy = true)
    private final Toolbar bottomToolbar = new Toolbar(webElement.findElement(By.id("bottomMenu")));

    public MediaToolbar(WebElement webElement)
    {
        super(webElement);
    }

    public Button getButtonOf(TopMediaToolbarEnum mediaButton)
    {
        return getTopToolbar().get(mediaButton.getIndex());
    }

    public Button getButtonOf(BottomMediaToolbarEnum mediaButton)
    {
        return getBottomToolbar().get(mediaButton.getIndex());
    }
}