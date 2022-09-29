package edu.info.aen.first_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        MaterialToolbar ViewToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(ViewToolbar);
        ActionBar toolbar = getSupportActionBar();
        Intent intent = getIntent();
        int value = intent.getIntExtra("clicked_value",0);
        if(toolbar != null){
            //shows back button
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Activity 3 - Option " + value);
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(value));
    }
}