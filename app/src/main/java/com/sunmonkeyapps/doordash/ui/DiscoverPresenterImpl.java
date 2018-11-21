package com.sunmonkeyapps.doordash.ui;

import android.util.Log;

import com.sunmonkeyapps.doordash.api.RestaurantApi;
import com.sunmonkeyapps.doordash.app.Constants;
import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DiscoverPresenterImpl implements DiscoverPresenter {

    private static final String TAG = "DiscoverPresenterImpl";

    DiscoverView view;
    List<Restaurant> mRestaurantList = new ArrayList<>();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    @Override
    public void setView(DiscoverView view) {

        this.view = view;
    }


    @Override
    public void getRestaurantsFromApi() {

        Retrofit retrofit = createRetrofitObjectForRxJava();
        final RestaurantApi restaurantApi = retrofit.create(RestaurantApi.class);

        view.showPorgressBar();

        compositeDisposable.add(
                restaurantApi.getRestaurantsUsingRxJava(Constants.LAT, Constants.LNG, Constants.REQUEST_OFFSET, Constants.REQUEST_LIMIT)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(this::handleResponse, this::handleError)
        );

    }

    private void handleResponse(List<Restaurant> restaurants) {
        Log.d(TAG, "handleResponse: ");

        view.hidePorgressBar();

        if (restaurants == null) {
            Log.e(TAG, "handleResponse: " + Constants.NO_DATA_FROM_API );
            compositeDisposable.clear();
            view.showRestaurantFromApi(mRestaurantList);
        } else {
            mRestaurantList.addAll(restaurants);
            compositeDisposable.clear();
            view.showRestaurantFromApi(mRestaurantList);
        }
    }

    private void handleError(Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());

        view.hidePorgressBar();
        view.showMessage(t.getMessage());
        return;
    }

    public Retrofit createRetrofitObjectForRxJava() {

        // for RxJava add:  addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_RESTAURANT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
