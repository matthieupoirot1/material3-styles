package edu.info.aen.first_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.Objects;

import edu.info.aen.first_test.books.BookRecyclerActivity;
import edu.info.aen.first_test.databinding.ActivityBookRecyclerBinding;
import edu.info.aen.first_test.databinding.ActivityMainBinding;
import edu.info.aen.first_test.supertype.CustomActivity;

public class MainActivity extends CustomActivity<ActivityMainBinding> {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        MaterialToolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        this.binding.btnLess.setOnClickListener(v -> {
            this.binding.tvCpt.setText(String.valueOf(Integer.parseInt(this.binding.tvCpt.getText().toString()) - 1));
        });

        this.binding.btnReset.setOnClickListener(v -> {
            this.binding.tvCpt.setText("0");
        });

        this.binding.btnAdd.setOnClickListener(v -> {
            this.binding.tvCpt.setText(String.valueOf(Integer.parseInt(this.binding.tvCpt.getText().toString()) + 1));
        });
        this.binding.mainBtnSettings.setOnClickListener(v -> {
            Intent intentFirstToSecond =
                    new Intent(this,
                            SecondActivity.class);
            startActivity(intentFirstToSecond);
        });

        this.binding.mainBtnRecyclerView.setOnClickListener(v -> {
            Intent intentFirstToRecyclerView =
                    new Intent(this,
                            RecyclerViewActivity.class);
            startActivity(intentFirstToRecyclerView);
        });

        this.binding.mainActivitBtnBookRv.setOnClickListener(v -> {
            Intent intentFirstToBookRecyclerView =
                    new Intent(this,
                            BookRecyclerActivity.class);
            startActivity(intentFirstToBookRecyclerView);
        });
    }

    @Override
    protected void initBinding() {
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("DEBUGAPPBAR", "onOptionsItemSelected: " + item.getItemId());
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_reset:
                Toast.makeText(this, "L'appli a été reset", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }
}