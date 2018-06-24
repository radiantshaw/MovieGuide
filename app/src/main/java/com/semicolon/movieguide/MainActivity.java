package com.semicolon.movieguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    ArrayList<Movie> data;

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

        setupExampleData();

        RecyclerView rView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter rViewAdapter = new RecyclerViewAdapter(this, data);
        rView.setLayoutManager(new GridLayoutManager(this, 3));
        rView.setAdapter(rViewAdapter);

        SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
        preference.registerOnSharedPreferenceChangeListener(this);

        URL url = TMDB.buildUrl(preference, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    private void setupExampleData() {
        data = new ArrayList<>();

        data.add(new Movie("Jurassic World: Fallen Kingdom", "http://image.tmdb.org/t/p/w185/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg", "http://image.tmdb.org/t/p/w500/gBmrsugfWpiXRh13Vo3j0WW55qD.jpg", "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.", 6.8F,"2018-06-06"));
        data.add(new Movie("Deadpool 2", "http://image.tmdb.org/t/p/w185/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg", "http://image.tmdb.org/t/p/w500/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg", "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.", 7.7F,"2018-05-15"));
        data.add(new Movie("Incredibles 2", "http://image.tmdb.org/t/p/w185/hL9Uz2vq93vi20oxZEBBaSs4w8U.jpg", "http://image.tmdb.org/t/p/w500/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg", "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.", 7.6F,"2018-06-14"));
        data.add(new Movie("Thor: Ragnarok", "http://image.tmdb.org/t/p/w185/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg", "http://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg", "Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.", 7.4F,"2017-10-25"));
        data.add(new Movie("Jurassic World: Fallen Kingdom", "http://image.tmdb.org/t/p/w185/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg", "http://image.tmdb.org/t/p/w500/gBmrsugfWpiXRh13Vo3j0WW55qD.jpg", "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.", 6.8F,"2018-06-06"));
        data.add(new Movie("Deadpool 2", "http://image.tmdb.org/t/p/w185/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg", "http://image.tmdb.org/t/p/w500/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg", "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.", 7.7F,"2018-05-15"));
        data.add(new Movie("Incredibles 2", "http://image.tmdb.org/t/p/w185/hL9Uz2vq93vi20oxZEBBaSs4w8U.jpg", "http://image.tmdb.org/t/p/w500/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg", "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.", 7.6F,"2018-06-14"));
        data.add(new Movie("Thor: Ragnarok", "http://image.tmdb.org/t/p/w185/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg", "http://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg", "Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.", 7.4F,"2017-10-25"));
        data.add(new Movie("Jurassic World: Fallen Kingdom", "http://image.tmdb.org/t/p/w185/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg", "http://image.tmdb.org/t/p/w500/gBmrsugfWpiXRh13Vo3j0WW55qD.jpg", "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.", 6.8F,"2018-06-06"));
        data.add(new Movie("Deadpool 2", "http://image.tmdb.org/t/p/w185/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg", "http://image.tmdb.org/t/p/w500/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg", "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.", 7.7F,"2018-05-15"));
        data.add(new Movie("Incredibles 2", "http://image.tmdb.org/t/p/w185/hL9Uz2vq93vi20oxZEBBaSs4w8U.jpg", "http://image.tmdb.org/t/p/w500/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg", "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.", 7.6F,"2018-06-14"));
        data.add(new Movie("Thor: Ragnarok", "http://image.tmdb.org/t/p/w185/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg", "http://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg", "Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.", 7.4F,"2017-10-25"));
        data.add(new Movie("Jurassic World: Fallen Kingdom", "http://image.tmdb.org/t/p/w185/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg", "http://image.tmdb.org/t/p/w500/gBmrsugfWpiXRh13Vo3j0WW55qD.jpg", "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.", 6.8F,"2018-06-06"));
        data.add(new Movie("Deadpool 2", "http://image.tmdb.org/t/p/w185/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg", "http://image.tmdb.org/t/p/w500/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg", "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.", 7.7F,"2018-05-15"));
        data.add(new Movie("Incredibles 2", "http://image.tmdb.org/t/p/w185/hL9Uz2vq93vi20oxZEBBaSs4w8U.jpg", "http://image.tmdb.org/t/p/w500/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg", "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.", 7.6F,"2018-06-14"));
        data.add(new Movie("Thor: Ragnarok", "http://image.tmdb.org/t/p/w185/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg", "http://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg", "Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.", 7.4F,"2017-10-25"));
        data.add(new Movie("Jurassic World: Fallen Kingdom", "http://image.tmdb.org/t/p/w185/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg", "http://image.tmdb.org/t/p/w500/gBmrsugfWpiXRh13Vo3j0WW55qD.jpg", "A volcanic eruption threatens the remaining dinosaurs on the island of Isla Nublar, where the creatures have freely roamed for several years after the demise of an animal theme park known as Jurassic World. Claire Dearing, the former park manager, has now founded the Dinosaur Protection Group, an organization dedicated to protecting the dinosaurs. To help with her cause, Claire has recruited Owen Grady, a former dinosaur trainer who worked at the park, to prevent the extinction of the dinosaurs once again.", 6.8F,"2018-06-06"));
        data.add(new Movie("Deadpool 2", "http://image.tmdb.org/t/p/w185/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg", "http://image.tmdb.org/t/p/w500/3P52oz9HPQWxcwHOwxtyrVV1LKi.jpg", "Wisecracking mercenary Deadpool battles the evil and powerful Cable and other bad guys to save a boy's life.", 7.7F,"2018-05-15"));
        data.add(new Movie("Incredibles 2", "http://image.tmdb.org/t/p/w185/hL9Uz2vq93vi20oxZEBBaSs4w8U.jpg", "http://image.tmdb.org/t/p/w500/mabuNsGJgRuCTuGqjFkWe1xdu19.jpg", "Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.", 7.6F,"2018-06-14"));
        data.add(new Movie("Thor: Ragnarok", "http://image.tmdb.org/t/p/w185/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg", "http://image.tmdb.org/t/p/w500/kaIfm5ryEOwYg8mLbq8HkPuM1Fo.jpg", "Thor is on the other side of the universe and finds himself in a race against time to get back to Asgard to stop Ragnarok, the prophecy of destruction to his homeworld and the end of Asgardian civilization, at the hands of an all-powerful new threat, the ruthless Hela.", 7.4F,"2017-10-25"));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        URL url = TMDB.buildUrl(sharedPreferences, this);
    }
}
