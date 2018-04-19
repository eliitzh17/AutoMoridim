package elements;

import objects.AbstractObject;
import objects.Button;
import objects.InputBox;
import org.openqa.selenium.WebElement;
import pages.usersPages.ForgotPasswordPage;

import static org.openqa.selenium.By.cssSelector;

public class UsersToolbar extends AbstractObject {

    public static final String USERS_TOOLBAR_ID = "topBar";

    private static final String REGISTER_CSS_HREF = "register";
    private static final String FORGOT_PASSWORD_CASS_HREF = "forgotPass";
    private static final String USER_NAME_ID = "head_username";
    private static final String PASSWORD_ID = "head_password";
    private static final String LOGIN_NAME = "login";

    private Button register;
    private Button forgetPassword;
    private InputBox username;
    private InputBox password;
    private Button login;

    public UsersToolbar(WebElement webElement)
    {
        super(webElement);
    }

    public void init()
    {
        register = new Button(webElement.findElement(cssSelector(REGISTER_CSS_HREF)));
        forgetPassword = new Button(webElement.findElement(cssSelector(FORGOT_PASSWORD_CASS_HREF)));
//        username = new InputBox(webElement.findElement(id(USER_NAME_ID)));
//        password = new InputBox(webElement.findElement(id(PASSWORD_ID)));
//        login = new Button(webElement.findElement(name(LOGIN_NAME)));
    }

    public void login(String userName, String password)
    {
        this.username.write(userName);
        this.password.write(password);
        this.login.click();
    }
//
//    public ForgotPasswordPage forgotPassword()
//    {
//        forgetPassword.click();
//
//        return new ForgotPasswordPage();
//    }

    public Button getRegister() {
        init();

        return register;
    }

    public Button getForgetPassword() {
        init();

        return forgetPassword;
    }

    public InputBox getUsername() {
        init();

        return username;
    }

    public InputBox getPassword() {
        init();

        return password;
    }

    public Button getLogin() {
        init();

        return login;
    }
}