package com.semicolon.movieguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Movie> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupExampleData();

        RecyclerView rView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter rViewAdapter = new RecyclerViewAdapter(this, data);
        rView.setLayoutManager(new GridLayoutManager(this, 3));
        rView.setAdapter(rViewAdapter);
    }

    private void setupExampleData() {
        data = new ArrayList<>();

        data.add(new Movie("One", "https://dummyimage.com/400x600/000/fff&text=1", "First movie", 2.5F, "1/1/1"));
        data.add(new Movie("Two", "https://dummyimage.com/400x600/000/fff&text=2", "Second movie", 4.3F, "2/2/2"));
        data.add(new Movie("Three", "https://dummyimage.com/400x600/000/fff&text=3", "Third movie", 1.2F, "3/3/3"));
        data.add(new Movie("Four", "https://dummyimage.com/400x600/000/fff&text=4", "Fourth movie", 3.6F, "4/4/4"));
        data.add(new Movie("One", "https://dummyimage.com/400x600/000/fff&text=1", "First movie", 2.5F, "1/1/1"));
        data.add(new Movie("Two", "https://dummyimage.com/400x600/000/fff&text=2", "Second movie", 4.3F, "2/2/2"));
        data.add(new Movie("Three", "https://dummyimage.com/400x600/000/fff&text=3", "Third movie", 1.2F, "3/3/3"));
        data.add(new Movie("Four", "https://dummyimage.com/400x600/000/fff&text=4", "Fourth movie", 3.6F, "4/4/4"));
        data.add(new Movie("One", "https://dummyimage.com/400x600/000/fff&text=1", "First movie", 2.5F, "1/1/1"));
        data.add(new Movie("Two", "https://dummyimage.com/400x600/000/fff&text=2", "Second movie", 4.3F, "2/2/2"));
        data.add(new Movie("Three", "https://dummyimage.com/400x600/000/fff&text=3", "Third movie", 1.2F, "3/3/3"));
        data.add(new Movie("Four", "https://dummyimage.com/400x600/000/fff&text=4", "Fourth movie", 3.6F, "4/4/4"));
        data.add(new Movie("One", "https://dummyimage.com/400x600/000/fff&text=1", "First movie", 2.5F, "1/1/1"));
        data.add(new Movie("Two", "https://dummyimage.com/400x600/000/fff&text=2", "Second movie", 4.3F, "2/2/2"));
        data.add(new Movie("Three", "https://dummyimage.com/400x600/000/fff&text=3", "Third movie", 1.2F, "3/3/3"));
        data.add(new Movie("Four", "https://dummyimage.com/400x600/000/fff&text=4", "Fourth movie", 3.6F, "4/4/4"));
        data.add(new Movie("One", "https://dummyimage.com/400x600/000/fff&text=1", "First movie", 2.5F, "1/1/1"));
        data.add(new Movie("Two", "https://dummyimage.com/400x600/000/fff&text=2", "Second movie", 4.3F, "2/2/2"));
        data.add(new Movie("Three", "https://dummyimage.com/400x600/000/fff&text=3", "Third movie", 1.2F, "3/3/3"));
        data.add(new Movie("Four", "https://dummyimage.com/400x600/000/fff&text=4", "Fourth movie", 3.6F, "4/4/4"));
    }
}
