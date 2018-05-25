package elements.mainPageElement.siderBarElement;

import lombok.Getter;
import objects.Button;
import objects.DropDown;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.filterPages.MainPage;
import pages.usersPages.RequestsPage;
import utils.enums.RequestContentsEnum;

import static utils.MyUtils.waitUntilPageReady;

public class RequestContentsBox extends AbstractSideBar
{
    public static final Integer SIDE_BAR_INDEX = 2;

    @Getter(lazy = true)
    private final DropDown contentType = new DropDown(getWebElement().findElement(By.name("table")));
    @Getter(lazy = true)
    private final InputBox contentName = new InputBox(getWebElement().findElement(By.name("name")));
    @Getter(lazy = true)
    private final InputBox moreDetails = new InputBox(getWebElement().findElement(By.name("details")));
    @Getter(lazy = true)
    private final Button requestPageButton = new Button(getWebElement().findElement(By.linkText("פינת הבקשות")));
    @Getter(lazy = true)
    private final Button sendButton = new Button(getWebElement().findElement(By.className("button")));

    public RequestContentsBox(WebDriver driver)
    {
        super(driver, SIDE_BAR_INDEX);
    }

    public void fillRequestFilled(RequestContentsEnum requestContents, String contentName, String contentDetail)
    {
        getContentType().select(requestContents.name());
        getContentName().write(contentName);
        getMoreDetails().write(contentDetail);
        getSendButton().click();
    }

    public RequestsPage makeValidRequest(RequestContentsEnum requestContents, String contentName, String contentDetail,
                                         WebDriver driver)
    {
        fillRequestFilled(requestContents, contentName, contentDetail);
        waitUntilPageReady(driver);

        return new RequestsPage(driver);
    }

    public MainPage makeInvalidRequest(RequestContentsEnum requestContents, String contentName, String contentDetail,
                                       WebDriver driver)
    {
        fillRequestFilled(requestContents, contentName, contentDetail);
        waitUntilPageReady(driver);

        return new MainPage(driver);
    }
}