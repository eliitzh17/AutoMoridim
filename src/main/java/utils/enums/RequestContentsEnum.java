package utils.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RequestContentsEnum
{
    MOVIE("סרט"), SERIES("סדרה"), GAME("משחק"), SOFTWARE("תוכנה");

    private String name;
}
