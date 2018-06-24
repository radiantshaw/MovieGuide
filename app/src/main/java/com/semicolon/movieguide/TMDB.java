package com.semicolon.movieguide;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class TMDB {
    final private static String BASE_URL = "http://api.themoviedb.org/3/discover/movie";
    final private static String PARAM_SORT_BY = "sort_by";
    final private static String PARAM_API_KEY = "api_key";
    final private static String ARG_POPULARITY = "popularity.desc";
    final private static String ARG_RATING = "vote_average.desc";
    final private static String ARG_API_KEY = "";

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
            builtUri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(PARAM_SORT_BY, ARG_POPULARITY).appendQueryParameter(PARAM_API_KEY, ARG_API_KEY).build();
        } else if (choice == Choice.RATING) {
            builtUri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(PARAM_SORT_BY, ARG_RATING).appendQueryParameter(PARAM_API_KEY, ARG_API_KEY).build();
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
