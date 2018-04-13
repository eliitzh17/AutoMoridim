package parametersObjects;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ExceptedMediaInfo
{
    private String hebrewName;
    private String englishName;
    private int creationYear;
    private String lastActivity;
    private String description;
    private List<String> genres;
    private int views;
    private int votes;
}