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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private TextView cptTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        this.cptTv = findViewById(R.id.tv_cpt);
        Button lessBtn = findViewById(R.id.btn_less);
        Button resetBtn = findViewById(R.id.btn_reset);
        Button addBtn = findViewById(R.id.btn_add);
        Button settingsBtn = findViewById(R.id.main_btn_settings);

        lessBtn.setOnClickListener(v -> {
            if (Integer.parseInt(cptTv.getText().toString()) > 0) {
                cptTv.setText(String.valueOf(Integer.parseInt(cptTv.getText().toString()) - 1));
            }
        });

        resetBtn.setOnClickListener(v -> cptTv.setText("0"));

        addBtn.setOnClickListener(v -> cptTv.setText(String.valueOf(Integer.parseInt(cptTv.getText().toString()) + 1)));


        settingsBtn.setOnClickListener(v -> {
            Intent intentFirstToSecond =
                    new Intent(this,
                            SecondActivity.class);
            startActivity(intentFirstToSecond);
        });
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