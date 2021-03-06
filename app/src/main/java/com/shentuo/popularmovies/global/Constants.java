package com.shentuo.popularmovies.global;

import com.shentuo.popularmovies.BuildConfig;

/**
 * Created by ShentuoZhan on 13/3/17.
 */

public class Constants {
    public static final String REQUEST_API_KEY = BuildConfig.API_KEY;
    public static final String RESULT_KEY = "results";
    public static final String EXTRA_KEY = "poster_detail";
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/";
    public static final String BASE_VIDEO_URL_PREFIX = "https://www.youtube.com/watch?v=";
    public static final String YOUTUBE_VIDEO_URL_PREFIX = "vnd.youtube://";
    public static String IMAGE_SIZE = "w185";//"w92", "w154", "w185", "w342", "w500", "w780", or "original"
    public static String THUMBNAIL_SIZE = "w154";
    public static int WIDTH_DIVIDER = 185;

}
