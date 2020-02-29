package com.app.sb.sbservices.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.app.sb.sbservices.R;

public class RateUsActivity extends AppCompatActivity {
AppCompatImageView imageview;
TextView textview;
RatingBar ratebar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);

        ratebar=findViewById(R.id.ratingBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Rate Us");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
