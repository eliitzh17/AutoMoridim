package pages.abstractPages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MediaPageEnum
{
    Series(VideoPage.class.getName(), "Series");

    private String className;
    private String siteName;
}
