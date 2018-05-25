import elements.mainPageElement.siderBarElement.PoplarItem;
import elements.mainPageElement.siderBarElement.PoplarMedia;
import org.junit.jupiter.api.Test;
import pages.filterPages.MainPage;

import static utils.enums.PagesUrlsEnum.MAIN;

public class CheckMovieDetails extends AbstractTest
{
    @Test
    public void test()
    {
        MainPage mainPage = navigateTo(MAIN);
        mainPage.getRecommend()
                .hoverAndGetRecommend(1)
                .getCreationYear();
        System.out.println(mainPage.getRecommend().getRecommendList().get(1).getCreationYear().getText());
        printPoplarDetails(mainPage.getPoplarMovies());
        printPoplarDetails(mainPage.getPoplarProgram());
        printPoplarDetails(mainPage.getPoplarSeries());
        printPoplarDetails(mainPage.getPoplarGames());
    }

    public void printPoplarDetails(PoplarMedia poplarMedia)
    {
        System.out.println(poplarMedia.getTitle().getText());

        for (int i = 0; i < poplarMedia.getPoplarMediaList().size(); i++)
        {
            PoplarItem poplarItem = poplarMedia.hoverItemAndGet(i);

            System.out.println(poplarItem.getCreateYear());
            System.out.println(poplarItem.getDescription());
            System.out.println(poplarItem.getTitle());
            System.out.println(poplarItem.getViews());
        }
    }
}