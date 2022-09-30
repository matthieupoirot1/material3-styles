package edu.info.aen.first_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RvDetailActivity extends AppCompatActivity {

    String title;
    String description;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_detail);
        Log.d("rvdetailactivity", "onCreate: started.");
        getIntentData();
    }

    private void getIntentData(){
        Log.d("rvdetailactivity", "getIntentData: ");
        if(getIntent().hasExtra("image") && getIntent().hasExtra("title") && getIntent().hasExtra("description")){
            this.image = getIntent().getIntExtra("image", 1);
            this.title = getIntent().getStringExtra("title");
            this.description = getIntent().getStringExtra("description");
            setIntentData();
        }
    }
    private void setIntentData(){
        Log.d("rvdetailactivity", "setIntentData: " + title + " " + description + " " + image);
        ((ImageView)findViewById(R.id.rv_detail_image)).setImageResource(image);
        ((TextView)findViewById(R.id.rv_detail_rv_title)).setText(title);
        ((TextView)findViewById(R.id.rv_detail_tv_subtitle)).setText(description);
    }
}