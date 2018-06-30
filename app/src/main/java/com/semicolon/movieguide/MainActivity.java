package com.semicolon.movieguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    RecyclerView rView;

    SharedPreferences preference;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.choice_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rView = findViewById(R.id.recyclerview);
        rView.setLayoutManager(new GridLayoutManager(this, 3));

        preference = PreferenceManager.getDefaultSharedPreferences(this);
        preference.registerOnSharedPreferenceChangeListener(this);

        URL url = TMDB.buildUrl(preference, this);
        new TMDBQueryTask().execute(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        URL url = TMDB.buildUrl(sharedPreferences, this);
        new TMDBQueryTask().execute(url);
    }

    public class TMDBQueryTask extends AsyncTask<URL, Void, String> {
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String responseString = null;

            try {
                responseString = NetworkUtils.getHttpResponse(searchUrl);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            return responseString;
        }

        @Override
        protected void onPostExecute(String s) {
            if (s != null && !s.equals("")) {
                JsonObject obj = new JsonParser().parse(s).getAsJsonObject();
                JsonArray results = obj.getAsJsonArray("results");

                ArrayList<Movie> movies = new Gson().fromJson(results, new TypeToken<ArrayList<Movie>>(){}.getType());

                RecyclerViewAdapter rViewAdapter = new RecyclerViewAdapter(MainActivity.this, movies);

                if (rView.getAdapter() == null) {
                    rView.setAdapter(rViewAdapter);
                } else {
                    rView.swapAdapter(rViewAdapter, false);
                }
            }
        }
    }
}
