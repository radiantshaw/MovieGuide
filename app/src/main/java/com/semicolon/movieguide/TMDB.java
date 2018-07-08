package com.semicolon.movieguide;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class TMDB {
    final private static String BASE_URL_POPULAR = "https://api.themoviedb.org/3/movie/popular";
    final private static String BASE_URL_TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated";
    final private static String THUMB_BASE_URL = "http://image.tmdb.org/t/p/w185";
    final private static String BACKDROP_BASE_URL = "http://image.tmdb.org/t/p/w500";
    final private static String PARAM_API_KEY = "api_key";
    final private static String ARG_API_KEY = "";

    public static String getThumbUrl() {
        return THUMB_BASE_URL;
    }

    public static String getBackdropUrl() {
        return BACKDROP_BASE_URL;
    }

    private static Choice getChoiceFromPreferences(SharedPreferences preference, Context context) {
        Resources res = context.getResources();
        String keyChoice = res.getString(R.string.pref_choice_key);
        String valuePopular = res.getString(R.string.pref_value_popular);
        String valueHighlyRated = res.getString(R.string.pref_value_highly_rated);

        Choice choice = null;

        if (valuePopular.equals(preference.getString(keyChoice, valuePopular))) {
            choice = Choice.POPULARITY;
        } else if (valueHighlyRated.equals(preference.getString(keyChoice, valuePopular))) {
            choice = Choice.RATING;
        }

        return choice;
    }

    public static URL buildUrl(SharedPreferences preference, Context context) {
        Choice choice = getChoiceFromPreferences(preference, context);

        Uri builtUri = null;

        if (choice == Choice.POPULARITY) {
            builtUri = Uri.parse(BASE_URL_POPULAR).buildUpon().appendQueryParameter(PARAM_API_KEY, ARG_API_KEY).build();
        } else if (choice == Choice.RATING) {
            builtUri = Uri.parse(BASE_URL_TOP_RATED).buildUpon().appendQueryParameter(PARAM_API_KEY, ARG_API_KEY).build();
        }

        URL builtUrl = null;

        try {
            builtUrl = new URL(builtUri.toString());
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        }

        return builtUrl;
    }

    private enum Choice {POPULARITY, RATING}
}
