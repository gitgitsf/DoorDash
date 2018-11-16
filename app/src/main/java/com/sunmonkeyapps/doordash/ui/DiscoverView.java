package com.sunmonkeyapps.doordash.ui;

import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.List;

public interface DiscoverView {

    public void showRestaurantFromApi(List<Restaurant> restaurantList);

    public void showMessage(String message);

    public void showPorgressBar();
    public void hidePorgressBar();


}
