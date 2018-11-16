package com.sunmonkeyapps.doordash.ui.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sunmonkeyapps.doordash.R;
import com.sunmonkeyapps.doordash.app.Constants;

public class RestaurantDetailActivity extends AppCompatActivity {

    private static final String TAG = "RestaurantDetailActivit";
    int restaurantId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);


//        setTitle(getResources().getString(R.string.detail_name));

        int restaurantId=getIntent().getIntExtra(Constants.RESTAURANT_ID,0);

    }
}
