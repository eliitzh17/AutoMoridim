package elements;

import objects.AbstractObject;
import objects.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.Integer.valueOf;
import static org.openqa.selenium.By.tagName;

public class BasicMediaInfo extends AbstractObject {

    public static final String BASIC_MEDIA_INFO_ID = "right";

    private static final String TITLE_ID = "title";
    private static final String HEBREW_NAME_TAG_NAME = "h1";
    private static final String ENGLISH_NAME_TAG_NAME = "h2";
    private static final String YEAR_CREATION_CSS_SELECTOR = "שנת יציאה";
    private static final String DESCRIPTION_ID = "plot";
    private static final String VIEWS_NUMBER_CSS_SELECTOR = "צפיות";
    private static final String VOTE_CLASS_NAME = "thumbsUp";

    private String hebrewName;
    private String englishName;
    private int year;
    private String mediaDescription;
    private int views;
    private Button vote;
    private Button addToMyLibrary;

    public BasicMediaInfo(WebElement webElement) {
        super(webElement);
    }

    public void init()
    {
        initTitle();
        year = valueOf(webElement.findElement(By.cssSelector("span[title='" + YEAR_CREATION_CSS_SELECTOR + "']")).getText());
        mediaDescription = webElement.findElement(By.id(DESCRIPTION_ID)).getText();
        views = valueOf(webElement.findElement(By.cssSelector("span[title='" + VIEWS_NUMBER_CSS_SELECTOR + "']")).getText());
        vote = new Button(webElement.findElement(By.className(VOTE_CLASS_NAME)));
    }

    private void initTitle()
    {
        WebElement title = webElement.findElement(By.id(TITLE_ID));

        this.hebrewName = title.findElement(tagName(HEBREW_NAME_TAG_NAME)).getText();
        this.englishName = title.findElement(tagName(ENGLISH_NAME_TAG_NAME)).getText();
    }


    public String getHebrewName()
    {
        initTitle();

        return hebrewName;
    }

    public String getEnglishName()
    {
        initTitle();

        return englishName;
    }

    public int getYear() {
        init();

        return year;
    }

    public String getMediaDescription() {
        init();

        return mediaDescription;
    }

    public int getViews() {
        init();

        return views;
    }

    public Button getVote()
    {
        init();

        return vote;
    }

    public int getVoteNumber()
    {
        init();

        return valueOf(vote.getText());
    }

    public Button getAddToMyLibrary() {
        init();

        return addToMyLibrary;
    }
}