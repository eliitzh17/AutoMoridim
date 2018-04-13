package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.mediaPages.MoviesPage;

import static enums.UrlsEnum.MOVIES_PAGE;

public class PageNavigator
{
    private WebDriver driver;
    private static final String MOVIES_CSS_SELECTOR = "a[href*='סרטים']";
    public PageNavigator(WebDriver driver)
    {
        this.driver = driver;
    }

    public MoviesPage navigateToMoviesPage()
    {
//        driver.get(MOVIES_PAGE.getUrl());
        driver.findElement(By.cssSelector(MOVIES_CSS_SELECTOR)).click();

        return new MoviesPage(driver);
    }
}