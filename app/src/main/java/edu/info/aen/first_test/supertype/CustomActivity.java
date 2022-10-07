package edu.info.aen.first_test.supertype;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

import com.google.android.material.appbar.MaterialToolbar;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.databinding.ActivityBookRecyclerBinding;

public abstract class CustomActivity<T extends ViewBinding> extends AppCompatActivity {
    protected T binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        setContentView(binding.getRoot());
        MaterialToolbar ViewToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(ViewToolbar);
        ActionBar toolbar = getSupportActionBar();
        if (toolbar != null) {
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Settings");
        }
    }

    protected abstract void initBinding();
}