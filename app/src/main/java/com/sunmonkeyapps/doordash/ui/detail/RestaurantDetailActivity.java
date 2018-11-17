package com.sunmonkeyapps.doordash.ui.detail;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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

        int restaurantId = getIntent().getIntExtra(Constants.RESTAURANT_ID,0);

        // set Fragmentclass Arguments
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.RESTAURANT_ID, restaurantId);
        RestaurantDetailFragment fragment = new RestaurantDetailFragment( );
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flRestaurantDetail, fragment);
        transaction.commit();

    }
}
