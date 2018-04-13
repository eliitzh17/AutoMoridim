package enums;

import lombok.Getter;

@Getter
public enum UrlsEnum {


    MOVIES_PAGE("https://www.moridim.tv/%D7%A1%D7%A8%D7%98%D7%99%D7%9D.html");

    private String url;

    public String getUrl()
    {
        return this.url;
    }
    UrlsEnum(String url) {
        this.url = url;
    }
}
