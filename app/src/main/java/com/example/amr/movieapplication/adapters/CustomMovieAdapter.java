package com.example.amr.movieapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amr.movieapplication.R;
import com.example.amr.movieapplication.models.ModelMovie;

import java.util.ArrayList;

public class CustomMovieAdapter extends ArrayAdapter<ModelMovie> {
    Context context;
    public CustomMovieAdapter(@NonNull Context context,  @NonNull ArrayList<ModelMovie> objects) {
        super(context, 0, objects);
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ModelMovie modelMovie = getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_row , parent , false);
        TextView titleMovie = convertView.findViewById(R.id.title_movie);
        ImageView posterMovie = convertView.findViewById(R.id.img_movie);

        titleMovie.setText(modelMovie.getTitle());
        posterMovie.setImageResource(modelMovie.getPoster());

        return convertView;
    }
}
