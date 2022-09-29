package edu.info.aen.first_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        MaterialToolbar ViewToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(ViewToolbar);
        ActionBar toolbar = getSupportActionBar();
        if(toolbar != null){
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Settings");
        }

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        Intent intentSecondToThird =
                new Intent(this,
                        ThirdActivity.class);

        button1.setOnClickListener(v -> {
            intentSecondToThird.putExtra("clicked_value", 1);
            startActivity(intentSecondToThird);
        });

        button2.setOnClickListener(v -> {
            intentSecondToThird.putExtra("clicked_value", 2);
            startActivity(intentSecondToThird);
        });

        button3.setOnClickListener(v -> {
            intentSecondToThird.putExtra("clicked_value", 3);
            startActivity(intentSecondToThird);
        });
    }
}