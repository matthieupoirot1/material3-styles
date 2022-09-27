package edu.info.aen.first_test;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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
        if(toolbar != null) toolbar.setDisplayHomeAsUpEnabled(true);
    }
}