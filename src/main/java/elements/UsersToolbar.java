package elements;

import lombok.Getter;
import objects.AbstractObject;
import objects.Button;
import objects.InputBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.usersPages.LoginPage;
import pages.usersPages.MemberPage;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.name;

public class UsersToolbar extends AbstractObject
{
    public static final String USERS_TOOLBAR_ID = "topBar";

    @Getter(lazy = true)
    private final Button register = new Button(getWebElement().findElement(cssSelector("[href='register']")));
    @Getter(lazy = true)
    private final Button forgetPassword = new Button(getWebElement().findElement(cssSelector("[href='forgotPass']")));
    @Getter(lazy = true)
    private final InputBox username = new InputBox(getWebElement().findElement(By.id("head_username")));
    @Getter(lazy = true)
    private final InputBox password = new InputBox(getWebElement().findElement(By.id("head_password")));
    @Getter(lazy = true)
    private final Button login = new Button(getWebElement().findElement(name("login")));

    public UsersToolbar(WebElement webElement)
    {
        super(webElement);
    }

    private void fillDetailsAndClick(String userName, String password)
    {
        getUsername().write(userName);
        getPassword().write(password);
        getLogin().click();
    }

    public MemberPage login(String userName, String password, WebDriver driver)
    {
        fillDetailsAndClick(userName, password);

        return new MemberPage(driver);
    }

    public LoginPage loginWrongDetails(String userName, String password, WebDriver driver)
    {
        fillDetailsAndClick(userName, password);

        return new LoginPage(driver);
    }
}