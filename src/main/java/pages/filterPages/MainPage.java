package pages.filterPages;

import elements.categoriesSearch.CategoriesSearchWithTabs;
import elements.mainPageElement.siderBarElement.PoplarMedia;
import elements.mainPageElement.siderBarElement.RequestContentsBox;
import elements.mainPageElement.siderBarElement.SurveyArea;
import elements.recommendMedia.Recommends;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.abstractPages.Page;

import static elements.mainPageElement.siderBarElement.PoplarMedia.*;

public class MainPage extends Page
{
    @Getter(lazy = true)
    private final Recommends recommend = new Recommends(getDriver());
    @Getter(lazy = true)
    private final CategoriesSearchWithTabs categoriesSearch = new CategoriesSearchWithTabs(getDriver());
    @Getter(lazy = true)
    private final SurveyArea surveyArea = new SurveyArea(getDriver());
    @Getter(lazy = true)
    private final RequestContentsBox requestContents = new RequestContentsBox(getDriver());
    @Getter(lazy = true)
    private final PoplarMedia poplarMovies = new PoplarMedia(getDriver(), MOVIES_INDEX);
    @Getter(lazy = true)
    private final PoplarMedia poplarSeries = new PoplarMedia(getDriver(), SERIES_INDEX);
    @Getter(lazy = true)
    private final PoplarMedia poplarGames = new PoplarMedia(getDriver(), GAMES_INDEX);
    @Getter(lazy = true)
    private final PoplarMedia poplarProgram = new PoplarMedia(getDriver(), PROGRAM_INDEX);

    public MainPage(WebDriver driver)
    {
        super(driver);
    }
}