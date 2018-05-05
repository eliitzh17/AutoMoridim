import org.junit.jupiter.api.Test;
import pages.filterPages.MainPage;

import static utils.enums.PagesUrlsEnum.MAIN;

public class CheckMovieDetails extends AbstractTest
{
    @Test
    public void test()
    {
        MainPage page = navigateTo(MAIN);

        System.out.println(page.getCategoriesSearch().getSearchResult().size());
        page.getCategoriesSearch().getLoadMoreButton().click();
        System.out.println(page.getCategoriesSearch().getSearchResult().size());

        page.getRecommend().getRecommendList().get(1).navigate(getDriver());

    }
}