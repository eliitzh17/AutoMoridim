import org.junit.jupiter.api.Test;
import pages.abstractPages.MediaPageEnum;
import pages.abstractPages.VideoPage;
import pages.mediaPages.MoviesPage;
import parametersObjects.ExceptedMediaInfo;

import java.util.Arrays;
import java.util.List;

import static pages.abstractPages.MediaPageEnum.Series;
import static utils.AssertionUtils.assertMovieInformation;

public class CheckMovieDetails extends AbstractTest
{
    private static final String ENGLISH_NAME = "Game of Thrones";
    private static final String HEBREW_NAME = "משחקי הכס";
    private static final int YEAR = 2014;
    private static final List<String> genreList = Arrays.asList("הרפתקאה", "דרמה", "פנטזיה");
    private static final String movieDescription = "הסדרה מתבססת על סדרת הספרים רבי המכר של ג'ורג' מרטין \"שיר של אש ושל קרח\" כאשר כל עונה מספרת את עלילת אחד הספרים בסדרה. העלילה מתארת את מאבקן של משפחות האצולה השונות בממלכת וסטרוז, המזכירה את בריטניה של ימי הביניים, ומתמקדת במיוחד במשפחת סטארק השולטת בצפון הממלכה וקורותיה לאחר שהמלך רוברט ברתיאון מבקש מלורד אדארד סטארק, ראש המשפחה, לשמש כסגנו. אמנם הסדרה משתייכת לז'אנר הפנטזיה ומתרחשת בעולם 'ימי-ביניימי' עתיר חרבות, אבירים, טירות וממלכות אך עולם הקסם והעל-טבעי מוצנע מאוד ומוזכר רק ברמזים, האנשים הם מרכז העלילה והתככים והאנטריגות ביניהם מוצגים בריאליזם בוטה עתיר אלימות ומיניות.";
    private static final int NUMBER_OF_VIEWS = 138613;

    private static final String MOVIE_NAME = "game of thrones";

    @Test
    public void test()
    {
        ExceptedMediaInfo exceptedMovieInfo = createExpectedObject();
        MoviesPage moviesPage = pageNavigator.navigateToMoviesPage();
        wait(2);
        VideoPage gameOfThrones = moviesPage.getSearchBox().enterFirstResult(MOVIE_NAME, moviesPage);
        assertMovieInformation(gameOfThrones, exceptedMovieInfo);
    }

    private ExceptedMediaInfo createExpectedObject()
    {
        return ExceptedMediaInfo.builder()
                .hebrewName(HEBREW_NAME)
                .englishName(ENGLISH_NAME)
                .creationYear(YEAR)
                .genres(genreList)
                .description(movieDescription)
                .views(NUMBER_OF_VIEWS).build();
    }
}