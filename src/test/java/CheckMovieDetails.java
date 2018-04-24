import org.junit.jupiter.api.Test;
import pages.filterPages.MainPage;

import static utils.enums.PagesUrlsEnum.MAIN;

public class CheckMovieDetails extends AbstractTest
{
    @Test
    public void test()
    {
        MainPage page = navigateTo(MAIN);

        page.getCategorySearch().getSearchButton().click();
    }
}