package utils;

import static utils.Consts.DOWNLOAD_CHAR_NUMBER;

public class StringUtils {

    public static String deleteDownloadHebrewWord(String str)
    {
        return str.substring(0, str.length() - (DOWNLOAD_CHAR_NUMBER + 1));
    }
}
