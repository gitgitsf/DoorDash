package com.sunmonkeyapps.doordash.api;

import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantApi {

    @GET("v2/restaurant")
    Call<List<Restaurant>> getRestaurants(
         @Query("lat") double lat,
         @Query("lng") double lng,
         @Query("offset") int offset,
         @Query("limit") int limit

    );

}
