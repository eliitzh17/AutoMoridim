import org.junit.jupiter.api.Test;
import pages.filterPages.MoviesPage;
import pages.filterPages.SeriesPage;
import utils.enums.LastActivityEnum;
import utils.parametersObjects.ExceptedMediaInfo;

import static java.util.Arrays.asList;
import static utils.AssertionUtils.assertMovieInformation;
import static utils.enums.LastActivityEnum.DAYS;
import static utils.enums.PagesUrlsEnum.MOVIES;

public class CheckMovieDetails extends AbstractTest
{
    @Test
    public void test()
    {
        MoviesPage page = navigateTo(MOVIES);

        SeriesPage suits = page.getSearchBox().enterFirstResult("Suits", driver);

        assertMovieInformation(suits, exceptedInfo());
    }

    private ExceptedMediaInfo exceptedInfo()
    {
        return ExceptedMediaInfo.builder().hebrewName("חליפות").englishName("Suits").creationYear(2011).description(
                "מייק רוס הוא אדם עצלן אך מבריק שנשר מהקולג'. בזכות כישורי הרחוב המצוינים שלו, מייק מועסק באחת באחת מחברות עורכי הדין הבכירות שבמנהטן ניו יורק. מייק והמעסיק שלו יצטרכו להסתיר מפני אחרים את העובדה שלמייק אין רישיון עורך דין ושהוא כלל לא סיים את לימודיו.")
                .genres(asList("קומדיה", "דרמה")).mediaLength(45).lastActivity(DAYS).lastActivityNumber(3).votes(75676).build();
    }
}