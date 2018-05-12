import org.junit.jupiter.api.Test;
import pages.filterPages.MainPage;
import pages.filterPages.SeriesPage;
import utils.AssertionUtils;
import utils.parametersObjects.ExceptedMediaInfo;

import java.util.Arrays;

import static utils.enums.LastActivityEnum.DAYS;
import static utils.enums.PagesUrlsEnum.MAIN;

public class CheckMovieDetails extends AbstractTest
{
    ExceptedMediaInfo exceptedMediaInfo = ExceptedMediaInfo.builder().mediaLength(45).creationYear(2011).description(
            "מייק רוס הוא אדם עצלן אך מבריק שנשר מהקולג'. בזכות כישורי הרחוב המצוינים שלו, מייק מועסק באחת באחת מחברות עורכי הדין הבכירות שבמנהטן ניו יורק. מייק והמעסיק שלו יצטרכו להסתיר מפני אחרים את העובדה שלמייק אין רישיון עורך דין ושהוא כלל לא סיים את לימודיו.\n" + "\n").englishName(
            "Suits").hebrewName("חליפות").genres(Arrays.asList("דרמה", "קומדיה")).lastActivity(DAYS).lastActivityNumber(
            11).views(77188).votes(67).build();

    @Test
    public void test()
    {
        MainPage page = navigateTo(MAIN);
        SeriesPage suits = page.getTopSearch().enterFirstResult("suits", getDriver());

        suits.getBasicMediaInfo();
        AssertionUtils.assertVideoInformation(suits, exceptedMediaInfo);
    }
}