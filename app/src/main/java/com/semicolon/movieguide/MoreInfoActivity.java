package com.semicolon.movieguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MoreInfoActivity extends AppCompatActivity {
    private ImageView backdrop, posterThumbnail;
    private TextView title, synopsis, rating, releaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        cacheViews();

        Intent intent = getIntent();

        Glide.with(this).load(intent.getExtras().getString("backdropURL")).into(backdrop);
        Glide.with(this).load(intent.getExtras().getString("posterURL")).into(posterThumbnail);

        title.setText(intent.getExtras().getString("title"));
        synopsis.setText(intent.getExtras().getString("synopsis"));
        rating.setText(intent.getExtras().getString("rating"));
        releaseDate.setText(intent.getExtras().getString("releaseDate"));
    }

    private void cacheViews() {
        backdrop = findViewById(R.id.info_backdrop);
        posterThumbnail = findViewById(R.id.info_poster_thumbnail);
        title = findViewById(R.id.info_title);
        synopsis = findViewById(R.id.info_synopsis);
        rating = findViewById(R.id.info_rating);
        releaseDate = findViewById(R.id.info_release_date);
    }
}
