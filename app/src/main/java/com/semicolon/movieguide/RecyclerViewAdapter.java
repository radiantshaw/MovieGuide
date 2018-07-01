package com.semicolon.movieguide;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Movie> data;

    public RecyclerViewAdapter(Context context, ArrayList<Movie> data) {
        this.context = context;

        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview_poster_thumbnail, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Movie movie = data.get(position);

        String posterURL = TMDB.getThumbUrl() + movie.getPosterURL();
        if (!posterURL.endsWith(".jpg")) {
            posterURL = "https://dummyimage.com/185x278/d6d6d6/2e2e2e&text=Image+not+available!";
        }

        Glide.with(context).load(posterURL).into(holder.posterThumbnail);

        holder.posterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoreInfoActivity.class);

                String notAvailable = "N/A";

                String title = movie.getTitle();
                if (title == null || title.equals("")) {
                    title = notAvailable;
                }

                String posterURL = TMDB.getThumbUrl() + movie.getPosterURL();
                if (!posterURL.endsWith(".jpg")) {
                    posterURL = "https://dummyimage.com/185x278/d6d6d6/2e2e2e&text=Image+not+available!";
                }

                String backdropURL = TMDB.getBackdropUrl() + movie.getBackdropURL();
                if (!backdropURL.endsWith(".jpg")) {
                    backdropURL = "https://dummyimage.com/500x281/d6d6d6/2e2e2e&text=Image+not+available!";
                }

                String synopsis = movie.getSynopsis();
                if (synopsis == null || synopsis.equals("")) {
                    synopsis = notAvailable;
                }

                String rating = String.valueOf(movie.getRating());
                if (rating.equals("")) {
                    rating = notAvailable;
                }

                String releaseDate = movie.getReleaseDate();
                if (releaseDate == null || releaseDate.equals("")) {
                    releaseDate = notAvailable;
                }

                intent.putExtra("title", title);
                intent.putExtra("posterURL", posterURL);
                intent.putExtra("backdropURL", backdropURL);
                intent.putExtra("synopsis", synopsis);
                intent.putExtra("rating", rating);
                intent.putExtra("releaseDate", releaseDate);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterThumbnail;
        private CardView posterCard;

        public ViewHolder(View itemView) {
            super(itemView);

            posterThumbnail = itemView.findViewById(R.id.poster_thumbnail);
            posterCard = itemView.findViewById(R.id.poster_card);
        }
    }
}
