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
    private Integer creationYear;
    private List<String> genres;
    private Integer mediaLength;
    private LastActivityEnum lastActivity;
    private Integer lastActivityNumber;
    private String description;
    private Integer views;
    private Integer votes;
}