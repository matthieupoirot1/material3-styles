package edu.info.aen.first_test.livedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.info.aen.first_test.R;
import edu.info.aen.first_test.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {

    ActivityLiveDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLiveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}