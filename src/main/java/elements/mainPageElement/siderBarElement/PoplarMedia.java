package elements.mainPageElement.siderBarElement;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static utils.MyUtils.initWebElementList;

public class PoplarMedia extends AbstractSideBar
{
    public static final int MOVIES_INDEX = 3;
    public static final int SERIES_INDEX = 4;
    public static final int GAMES_INDEX = 5;
    public static final int PROGRAM_INDEX = 6;

    @Getter(lazy = true)
    private final List<PoplarItem> poplarMediaList = initWebElementList(
            getWebElement().findElement(By.className("images")).findElements(By.tagName("li")), PoplarItem.class);

    public PoplarItem hoverItemAndGet(int index)
    {
        hover();

        return getPoplarMediaList().get(index);
    }

    public PoplarMedia(WebDriver driver, int sideBarIndex)
    {
        super(driver, sideBarIndex);
    }
}
