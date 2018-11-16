package com.sunmonkeyapps.doordash.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.sunmonkeyapps.doordash.R;
import com.sunmonkeyapps.doordash.adapter.RestaurantAdapter;
import com.sunmonkeyapps.doordash.app.Constants;
import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.List;

public class DiscoverActivity extends AppCompatActivity  implements DiscoverView {

    private static final String TAG = "DiscoverActivity";

    DiscoverPresenter mPresenter;

    RecyclerView.LayoutManager layoutManager;
    RecyclerView rvRestaurant;
    ProgressBar progressBar;

    List<Restaurant> mRestaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        // Change the activity title on toolbar here  
        setTitle(getResources().getString(R.string.discover_name));

        initLayout();

        mPresenter = new DiscoverPresenterImpl();
        mPresenter.setView(this);
        mPresenter.getRestaurantsFromApi();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.setView(null);

    }

    @Override
    public void showRestaurantFromApi(List<Restaurant> restaurantList) {

        Log.d(TAG, "showRestaurantFromApi: ");

        if (restaurantList !=null) {
            Log.d(TAG, "showRestaurantFromApi: " + restaurantList.size());

            rvRestaurant.setAdapter(new RestaurantAdapter(restaurantList));
            rvRestaurant.getAdapter().notifyDataSetChanged();

        } else {
            Toast.makeText(this, Constants.NO_DATA_FROM_API, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPorgressBar() {
        Log.d(TAG, "showPorgressBar: ");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidePorgressBar() {

        progressBar.setVisibility(View.GONE);
    }

    private void initLayout() {

        rvRestaurant = (RecyclerView) findViewById(R.id.rvRestaurants);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        layoutManager =new LinearLayoutManager(this);
        rvRestaurant.setHasFixedSize(true );
        rvRestaurant.setLayoutManager(layoutManager);

    }
}
