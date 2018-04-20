package utils;

import pages.abstractPages.VideoPage;
import utils.parametersObjects.ExceptedMediaInfo;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class AssertionUtils
{
    public static void assertMovieInformation(VideoPage movieSite, ExceptedMediaInfo exceptedMovieInfo)
    {
        assertTrue(movieSite.getBasicMediaInfo().getHebrewName().contains(exceptedMovieInfo.getHebrewName()));
        assertEquals(movieSite.getBasicMediaInfo().getEnglishName(), exceptedMovieInfo.getEnglishName());
        assertEquals(movieSite.getYearCreation(), exceptedMovieInfo.getCreationYear());
        assertTrue(movieSite.getCategories().equals(exceptedMovieInfo.getGenres()));
        assertEquals(movieSite.getVideoLength().getMinuteAmount(), exceptedMovieInfo.getMediaLength());
        assertEquals(movieSite.getLastActivity(),
                     exceptedMovieInfo.getLastActivity().getSiteSyntax(exceptedMovieInfo.getLastActivityNumber()));
        assertEquals(movieSite.getBasicMediaInfo().getMediaDescription(), exceptedMovieInfo.getDescription());
        assertTrue(movieSite.getBasicMediaInfo().getViews() >= exceptedMovieInfo.getViews());
        assertEquals(movieSite.getVoteNumber(), exceptedMovieInfo.getVotes());
    }
}
