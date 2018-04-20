package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pages.abstractPages.VideoPage;
import pages.filterPages.*;
import pages.infoPages.ContactPage;
import pages.infoPages.DMCAPage;
import pages.usersPages.ForgotPasswordPage;
import pages.usersPages.LoginPage;
import pages.usersPages.RegisterPage;
import pages.usersPages.RequestsPage;

import java.util.HashMap;
import java.util.Map;

import static utils.Consts.HTML_URL_ENDS;
import static utils.Consts.MAIN_PAGE_URL;

@AllArgsConstructor
public enum PagesUrlsEnum
{
    MAIN(MAIN_PAGE_URL, "", MainPage.class.getName(), ""),
    MOVIES("סרטים", HTML_URL_ENDS, MoviesPage.class.getName(), "Movie"),
    SERIES("סדרות", HTML_URL_ENDS, SeriesPage.class.getName(), "Series"),
//    FOUR_K_MOVIES("סרטי 4K"),
    GAMES("משחקים", HTML_URL_ENDS, GamesPage.class.getName(), "Game"),
    PROGRAM("תוכנות", HTML_URL_ENDS, ProgramPage.class.getName(), "Software"),
    MUSIC("מוזיקה", HTML_URL_ENDS, MusicPage.class.getName(), "Music"),
    REQUESTS("requests", "", RequestsPage.class.getName(), ""),
    REGISTER("register", "", RegisterPage.class.getName(), ""),
    FORGOT_PASSWORD("forgotPass", "", ForgotPasswordPage.class.getName(), ""),
    LOGIN("login", "", LoginPage.class.getName(), ""),
    DMCA("DMCA", HTML_URL_ENDS, DMCAPage.class.getName(), ""),
    CONTACT("יצירת-קשר", HTML_URL_ENDS, ContactPage.class.getName(), "");

    private static final Map<String, PagesUrlsEnum> map = new HashMap<>();
    private String url;
    private String urlEnds;
    @Getter private String className;
    @Getter private String specificPageName;

    public String getUrl()
    {
        return url.equals(MAIN_PAGE_URL) ? MAIN_PAGE_URL : MAIN_PAGE_URL.concat(url).concat(urlEnds);
    }

    public static PagesUrlsEnum getEnumBySpecificPageName(String specificPageName)
    {
        if (map.isEmpty())
        {
            for (PagesUrlsEnum currentEnum : values())
            {
                map.put(currentEnum.getSpecificPageName(), currentEnum);
            }
        }

        return map.get(specificPageName);
    }
}
