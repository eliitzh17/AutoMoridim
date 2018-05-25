package elements.mainPageElement.siderBarElement;

import lombok.Getter;
import objects.Button;
import objects.Label;
import objects.RadioButton;
import objects.SurveyAnswer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MyUtils;

import java.util.List;

import static java.lang.Integer.parseInt;

public class SurveyArea extends AbstractSideBar
{
    public static final Integer SIDE_BAR_INDEX = 1;

    @Getter(lazy = true)
    private final Label question = new Label(getWebElement().findElement(By.className("question")));
    @Getter(lazy = true)
    private final List<RadioButton> votesOptions = MyUtils.initWebElementList(
            getWebElement().findElements(By.tagName("label")), RadioButton.class);
    @Getter(lazy = true)
    private final Button showResultButton = new Button(
            getWebElement().findElement(By.cssSelector("[alt='הראה תוצאות']")));
    @Getter(lazy = true)
    private final Button voteInThisSurveyButton = new Button(
            getWebElement().findElement(By.cssSelector("[alt='הצבע בסקר זה']")));
    @Getter(lazy = true)
    private final Button voteButton = new Button(getWebElement().findElement(By.cssSelector("[value='הצבע']")));
    @Getter(lazy = true)
    private final int numberOfVotes = getNumericValue(getWebElement().findElement(By.className("total")).getText());
    @Getter(lazy = true)
    private final List<SurveyAnswer> surveyAnswers = MyUtils.initWebElementList(
            getWebElement().findElements(By.className("barempty")), SurveyAnswer.class);

    private int getNumericValue(String value)
    {
        return parseInt(value.split(" ")[1]);
    }

    public SurveyArea(WebDriver driver)
    {
        super(driver, SIDE_BAR_INDEX);
    }

    public void changeView()
    {
        if (getShowResultButton().getWebElement().isDisplayed())
        {
            getShowResultButton().click();
        } else
        {
            getVoteInThisSurveyButton().click();
        }
    }

    public void vote(int index)
    {
        getVotesOptions().get(index).select();

        getVoteButton().click();
    }

    public void vote(String value)
    {
        for (int i = 0; i < getSurveyAnswers().size()-1; i++)
        {
            if (getVotesOptions().get(i).getValue().equals(value))
            {
                vote(i);
            }
        }
    }
}
