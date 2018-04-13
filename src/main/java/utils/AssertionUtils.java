package utils;

import parametersObjects.ExceptedMediaInfo;
import pages.abstractPages.VideoPage;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AssertionUtils
{
    public static void assertMovieInformation(VideoPage movieSite, ExceptedMediaInfo exceptedMovieInfo)
    {
        assertTrue(movieSite.getBasicMediaInfo().getHebrewName().contains(exceptedMovieInfo.getHebrewName()));
        assertTrue(movieSite.getBasicMediaInfo().getEnglishName().contains(exceptedMovieInfo.getEnglishName()));
        assertTrue(movieSite.getBasicMediaInfo().getMediaDescription().equals(exceptedMovieInfo.getDescription()));
        assertEquals(movieSite.getBasicMediaInfo().getYear(), exceptedMovieInfo.getCreationYear());
        assertTrue(movieSite.getBasicMediaInfo().getViews() > exceptedMovieInfo.getViews());
        assertTrue(movieSite.getCategories().equals(exceptedMovieInfo.getGenres()));
    }
}
