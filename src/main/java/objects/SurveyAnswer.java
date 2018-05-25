package objects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SurveyAnswer extends AbstractObject
{
    public static String SURVEY_ANSWER_CLASS_NAME = "barempty";
    public static String ANSWER_CLASS_NAME = "answer";

    @Getter(lazy = true)
    private final String answerValue = deleteVotesNumber(getWebElement().findElement(By.className(ANSWER_CLASS_NAME)).getText());

    @Getter(lazy = true)
    private final Integer votesNumber = getVoteNumber(getWebElement().findElement(By.className(ANSWER_CLASS_NAME)).getText());

    @Getter(lazy = true)
    private final Integer percent = Integer.valueOf(getWebElement().findElement(By.className("percent")).getText());

    public SurveyAnswer(WebElement webElement)
    {
        super(webElement);
    }

    private int getVoteNumber(String value)
    {
        return Integer.parseInt(value.split(" ")[value.length()-2]);
    }

    private String deleteVotesNumber(String value)
    {
        String text = value.split("[(]")[0];
        return text.substring(0, text.length() -1);
    }
}