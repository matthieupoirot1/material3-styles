package edu.info.aen.first_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import edu.info.aen.first_test.adapters.CouleursAdapter;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        int[] images = {R.drawable.rouge, R.drawable.vert, R.drawable.bleu, R.drawable.jaune, R.drawable.orange, R.drawable.violet, R.drawable.rose, R.drawable.marron, R.drawable.gris, R.drawable.cyan};
        String[] titles = getResources().getStringArray(R.array.couleur);
        String[] descriptions = getResources().getStringArray(R.array.description);
        RecyclerView recyclerView = findViewById(R.id.rv_couleurs);
        CouleursAdapter adapter = new CouleursAdapter(this, titles, descriptions, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}