package utils.parametersObjects;

import lombok.Builder;
import lombok.Data;
import utils.enums.LastActivityEnum;

import java.util.List;

@Builder(builderClassName = "ExceptedMediaInfoBuilder")
@Data
public class ExceptedMediaInfo
{
    private String hebrewName;
    private String englishName;
    private int creationYear;
    private List<String> genres;
    private int mediaLength;
    private LastActivityEnum lastActivity;
    private int lastActivityNumber;
    private String description;
    private int views;
    private int votes;
}