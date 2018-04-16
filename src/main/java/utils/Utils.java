package utils;

import org.openqa.selenium.WebDriver;
import pages.abstractPages.Page;

import static java.lang.Class.forName;
import static utils.Consts.DOWNLOAD_CHAR_NUMBER;

public class Utils
{

    public static String deleteDownloadHebrewSentence(String str)
    {
        return str.substring(0, str.length() - (DOWNLOAD_CHAR_NUMBER + 1));
    }
    
    public static String deleteStraightWatchHebrewSentence(String str)
    {
        return str.substring(0, 9);
    }

    public static <T extends Page> T createInstance(String className, WebDriver driver)
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

    public static String getPageCategoryFromUrl(Page page)
    {
        return page.getDriver().getCurrentUrl().split("/")[3];
    }
}
