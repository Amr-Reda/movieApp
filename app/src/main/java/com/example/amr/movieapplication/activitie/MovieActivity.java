package com.example.amr.movieapplication.activitie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.amr.movieapplication.R;
import com.example.amr.movieapplication.adapters.CustomMovieAdapter;
import com.example.amr.movieapplication.models.ModelMovie;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    GridView gridViewMovies;
    ArrayList<ModelMovie> arrayListMovies;
    CustomMovieAdapter customMovieAdapter;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences = getSharedPreferences("pref_file" , MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gridViewMovies = findViewById(R.id.grid_movies);
        arrayListMovies = new ArrayList<>();

        ModelMovie modelMovie1 = new ModelMovie();
        modelMovie1.setTitle("Find Nemo");
        modelMovie1.setPoster(R.drawable.find_nemo);
        arrayListMovies.add(modelMovie1);

        ModelMovie modelMovie2 = new ModelMovie();
        modelMovie2.setTitle("Tangled");
        modelMovie2.setPoster(R.drawable.tangled);
        arrayListMovies.add(modelMovie2);

        ModelMovie modelMovie3 = new ModelMovie();
        modelMovie3.setTitle("Shrek");
        modelMovie3.setPoster(R.drawable.shrek);
        arrayListMovies.add(modelMovie3);

        ModelMovie modelMovie4 = new ModelMovie();
        modelMovie4.setTitle("Moana");
        modelMovie4.setPoster(R.drawable.mona);
        arrayListMovies.add(modelMovie4);

        ModelMovie modelMovie5 = new ModelMovie();
        modelMovie5.setTitle("Mulan");
        modelMovie5.setPoster(R.drawable.mulan);
        arrayListMovies.add(modelMovie5);

        ModelMovie modelMovie6 = new ModelMovie();
        modelMovie6.setTitle("Big Hero");
        modelMovie6.setPoster(R.drawable.big_hero);
        arrayListMovies.add(modelMovie6);

        customMovieAdapter = new CustomMovieAdapter(MovieActivity.this , arrayListMovies);
        gridViewMovies.setAdapter(customMovieAdapter);


        gridViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String email = sharedPreferences.getString("emailKey" , "no email");
                Toast.makeText(MovieActivity.this , email  , Toast.LENGTH_LONG).show();
            }
        });






    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(MovieActivity.this);
        menuInflater.inflate(R.menu.main_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Intent intent = new Intent(MovieActivity.this , LoginActivity.class);
                startActivity(intent);
                editor.clear();
                editor.commit();
                editor.apply();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
