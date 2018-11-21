package com.sunmonkeyapps.doordash.api;

import com.sunmonkeyapps.doordash.model.Restaurant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestaurantApi {

    // retrieve for a given lat & lng
    @GET("v2/restaurant")
    Call<List<Restaurant>> getRestaurants(
         @Query("lat") double lat,
         @Query("lng") double lng,
         @Query("offset") int offset,
         @Query("limit") int limit

    );

    // retrieve for a given lat & lng
    @GET("v2/restaurant")
    io.reactivex.Observable<List<Restaurant>> getRestaurantsUsingRxJava(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("offset") int offset,
            @Query("limit") int limit

    );

    // retrieve a restaurant for the given restraurant id
    @GET("v2/restaurant/{restaurantId}")
    Call<Restaurant> getArestaurant(
            @Path("restaurantId") int restaurantId
    );

    // retrieve a restaurant for the given restraurant id -using RxJava
    @GET("v2/restaurant/{restaurantId}")
    io.reactivex.Observable<Restaurant> getArestaurantUsingRxJava(
            @Path("restaurantId") int restaurantId
    );


}
