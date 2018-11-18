package com.sunmonkeyapps.doordash.ui;

import android.util.Log;

import com.sunmonkeyapps.doordash.api.RestaurantApi;
import com.sunmonkeyapps.doordash.app.Constants;
import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscoverPresenterImpl implements DiscoverPresenter  {

    private static final String TAG = "DiscoverPresenterImpl";

    DiscoverView view;
    List<Restaurant> mRestaurantList = new ArrayList<>();



    @Override
    public void setView(DiscoverView view) {

        this.view = view;
    }

    @Override
    public void getRestaurantsFromApi() {

        Retrofit retrofit = createRetrofitObject();
        final RestaurantApi restaurantApi = retrofit.create(RestaurantApi.class);


        view.showPorgressBar();
        Call<List<Restaurant>> call =restaurantApi.getRestaurants(Constants.LAT, Constants.LNG, Constants.REQUEST_OFFSET, Constants.REQUEST_LIMIT);

        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {

                view.hidePorgressBar();

                if (response.body() == null) {
                    Log.e(TAG, "onResponse: No data return from api "  );
                    view.showRestaurantFromApi(mRestaurantList);

                } else {
                    List<Restaurant> list = response.body();
                    mRestaurantList.addAll(list);
                    view.showRestaurantFromApi(mRestaurantList);
                }
                return;
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );
                view.hidePorgressBar();
                view.showMessage(t.getMessage());
                return;

            }
        });

    }

    public  Retrofit createRetrofitObject() {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_RESTAURANT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


}
