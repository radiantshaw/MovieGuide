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
        this.data = data;
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
        Glide.with(context).load(data.get(position).getPosterURL()).into(holder.posterThumbnail);

        holder.posterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MoreInfoActivity.class);

                intent.putExtra("title", data.get(position).getTitle());
                intent.putExtra("posterURL", data.get(position).getPosterURL());
                intent.putExtra("backdropURL", data.get(position).getBackdropURL());
                intent.putExtra("synopsis", data.get(position).getSynopsis());
                intent.putExtra("rating", String.valueOf(data.get(position).getRating()));
                intent.putExtra("releaseDate", data.get(position).getReleaseDate());

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
