package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LastActivityEnum
{
    HOURS("שעות"),
    DAYS("ימים"),
    MONTH("חודשים"),
    YEARS("שנים");

    private String value;

    private static final String BEFORE_HEBREW = "לפני ";

    public String getSiteSyntax(int x)
    {
        return BEFORE_HEBREW.concat(String.valueOf(x)).concat(" ".concat(value));
    }
}