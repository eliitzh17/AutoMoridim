import org.junit.jupiter.api.Test;
import pages.filterPages.GamesPage;
import pages.filterPages.MoviesPage;
import pages.filterPages.SeriesPage;

import static utils.enums.PagesUrlsEnum.MOVIES;

public class CheckMovieDetails extends AbstractTest
{
    @Test
    public void test()
    {
        MoviesPage page = navigateTo(MOVIES);

        SeriesPage suits = page.getSearchBox().enterFirstResult("Suits", driver);

        GamesPage sims4 = suits.getSearchBox().enterFirstResult("sims 4", driver);
    }
}