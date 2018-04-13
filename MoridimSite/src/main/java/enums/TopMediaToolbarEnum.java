package enums;


public enum TopMediaToolbarEnum {

    MAIN("ראשי", 0),
    MOVIES("סרטים", 1),
    SERIES("סדרות", 2),
    FOUR_K_MOVIES("סרטי 4K", 3),
    GAMES("משחקים", 4),
    PROGRAM("תוכנות", 5),
    MUSIC("מוזיקה", 6);

    private String name;
    private int index;

    TopMediaToolbarEnum(String hebrewName, int location) {
        this.name = hebrewName;
        this.index = location;
    }

    public String getName()
    {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
