package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.abstractPages.Page;

import static java.lang.Class.forName;
import static java.lang.Thread.sleep;
import static utils.Consts.DOWNLOAD_CHAR_NUMBER;

public class MyUtils
{
    public static String deleteDownloadHebrewSentence(String str)
    {
        return str.substring(0, str.length() - (DOWNLOAD_CHAR_NUMBER + 1));
    }

    public static String deleteDirectWatchHebrewSentence(String str)
    {
        return str.substring(0, 9);
    }

    public static <T extends Page> T createPageInstance(String className, WebDriver driver)
    {
        T newPage = null;
        try
        {
            newPage = (T) forName(className).getDeclaredConstructors()[0].newInstance(driver);
        } catch (ReflectiveOperationException e)
        {
            e.printStackTrace();
        }

        return newPage;
    }

    public static void closeLinksPopup(WebDriver driver)
    {
        if (driver.findElement(By.id("boxBg")).isDisplayed())
        {
            driver.findElement(By.className("close")).click();
            try
            {
                sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static String getPageCategoryFromUrl(WebDriver driver)
    {
        return driver.getCurrentUrl().split("/")[3];
    }

    public static void hover(WebDriver driver, WebElement webElement)
    {
        new Actions(driver).moveToElement(webElement).build().perform();
    }
}
