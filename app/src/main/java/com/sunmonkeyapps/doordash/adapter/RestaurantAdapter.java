package com.sunmonkeyapps.doordash.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunmonkeyapps.doordash.R;
import com.sunmonkeyapps.doordash.app.Constants;
import com.sunmonkeyapps.doordash.model.Restaurant;
import com.sunmonkeyapps.doordash.ui.detail.RestaurantDetailActivity;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {


    static List<Restaurant> mRestaurantList;
    Restaurant mRestaurant;
    Context mContext;

    public RestaurantAdapter(List<Restaurant> restaurants) {

        mRestaurantList = restaurants;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);

        mContext = view.getContext();
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int position) {

        mRestaurant = mRestaurantList.get(position);

        RestaurantViewHolder item = restaurantViewHolder;

        // show restaurant image
        String imageUrl = mRestaurant.getCoverImgUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(mContext).load(imageUrl).into(item.ivRestaurant);
        }

        item.tvName.setText(mRestaurant.getName());
        item.tvDescription.setText(mRestaurant.getDescription());
        item.tvStatus.setText(mRestaurant.getStatus());

    }

    @Override
    public int getItemCount() {
        return mRestaurantList == null ? 0 : mRestaurantList.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        ImageView ivRestaurant;
        TextView tvName;
        TextView tvDescription;
        TextView tvStatus;

        public RestaurantViewHolder(View itemView) {
            super(itemView);

            ivRestaurant = (ImageView) itemView.findViewById(R.id.ivRestaurant);
            tvName =(TextView)itemView.findViewById(R.id.tvName);
            tvDescription = (TextView)itemView.findViewById(R.id.tvDescription);
            tvStatus = (TextView) itemView.findViewById(R.id.tvStatus);

            //handle onClick on the item
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Restaurant restaurant= new Restaurant();
            restaurant= mRestaurantList.get(getAdapterPosition());
            int restaurantId = restaurant.getId();

            Intent intent = new Intent(itemView.getContext(), RestaurantDetailActivity.class);
            intent.putExtra(Constants.RESTAURANT_ID, restaurantId);
            // Launch Restaurant detail activity
            itemView.getContext().startActivity(intent);


        }
    }
}
