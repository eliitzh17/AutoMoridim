package utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BottomMediaToolbarEnum {

    MOVIES_TO_WATCH_ONLINE("סרטים לצפייה ישירה", 0),
    MOVIES_TO_DOWNLOAD("סרטים להורדה", 1),
    MOVIES_WITH_SUBTITLE("סרטים עם תרגום מובנה", 2),
    MOVIES_IN_4K("סרטים באיכות 4K", 3),
    DUBBED_MOVIES("סרטים מדובבים", 4),
    MOVIES_FROM_2018("סרטים משנת 2018", 5),
    SERIES_TO_WATCH_ONLINE("סדרות לצפייה ישירה", 6);

    private String name;
    private int index;
}
