package com.sunmonkeyapps.doordash.ui.detail;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sunmonkeyapps.doordash.R;
import com.sunmonkeyapps.doordash.api.RestaurantApi;
import com.sunmonkeyapps.doordash.app.Constants;
import com.sunmonkeyapps.doordash.model.Restaurant;
import com.sunmonkeyapps.doordash.ui.DiscoverPresenterImpl;
import com.sunmonkeyapps.doordash.util.UiUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RestaurantDetailFragment extends Fragment {

    private static final String TAG = "RestaurantDetailFrag";

    int restaurantId=0;
    Context mContext;

    ProgressDialog pDialog;

    @Nullable @BindView(R.id.ivRestaurant)
    ImageView ivRestaurant;

    @Nullable @BindView(R.id.tvName)
    TextView tvName;

    @Nullable @BindView(R.id.tvDescription)
    TextView tvDescription;

    @Nullable @BindView(R.id.tvStatus)
    TextView tvStatus;

    @Nullable @BindView(R.id.tvRate)
    TextView tvRate;


    @Nullable @BindView(R.id.tvYelpReviewCount)
    TextView tvYelpReviewCount;

    @Nullable @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @Nullable @BindView(R.id.tvAddress)
    TextView tvAddress;

    @Nullable @BindView(R.id.tvPhone)
    TextView tvPhone;

    private Unbinder unbinder;


    public RestaurantDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //retrieve the restaurant id
        restaurantId = getArguments().getInt(Constants.RESTAURANT_ID);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        mContext = view.getContext();

        unbinder = ButterKnife.bind(this, view);

        // fill the view with the restaurant data
        getDataFromApiAndUpdateView();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void getDataFromApiAndUpdateView() {
        Log.d(TAG, "getDataFromApi: ");

        Retrofit retrofit = DiscoverPresenterImpl.createRetrofitObject();
        final RestaurantApi restaurantApi = retrofit.create(RestaurantApi.class);

        showProgressBar();
        
        Call<Restaurant> call = restaurantApi.getArestaurant(restaurantId);
        call.enqueue(new Callback<Restaurant>() {
            @Override
            public void onResponse(Call<Restaurant> call, Response<Restaurant> response) {

                if (response.body() == null) {
                    Log.e(TAG, "onResponse: No data return from api "  );
                    showErrorMessageOnDetailScreen(Constants.NO_DATA_FROM_API);

                } else {
                    Restaurant mRestaurant = response.body();;
                    showRestaurantDataFromApi(mRestaurant);
                }
            }

            @Override
            public void onFailure(Call<Restaurant> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage() );

                showErrorMessageOnDetailScreen(t.getMessage());
            }
        });
    }

    private void showErrorMessageOnDetailScreen(String message) {
        //to do show in tvName
        hideProgressBar();
        tvName.setText(message);
    }

    private void showRestaurantDataFromApi( Restaurant mRestaurant) {

        hideProgressBar();

        String imageUrl = mRestaurant.getCoverImgUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            Glide.with(mContext).load(imageUrl).into(ivRestaurant);
        }

        tvName.setText(mRestaurant.getName());
        tvDescription.setText(mRestaurant.getDescription());

        //todo - status is not dispalyed with same data as in Discover screen???
        tvStatus.setText(mRestaurant.getStatus());

        tvRate.setText(mRestaurant.getYelpRating()+"");
        tvYelpReviewCount.setText(mRestaurant.getYelpReviewCount() + " Yelp Review");
        ratingBar.setRating((float) mRestaurant.getYelpRating());

        // show address, the label is showed in xml layout
        tvAddress.setText(mRestaurant.getAddress().getPrintableAddress());

        // show phone # 12343214567 - ignore 1 reformat to (234) 321-4567
        tvPhone.setText(UiUtil.formatPhone(mRestaurant.getPhoneNumber() + ""));
    }

    private void showProgressBar() {
        Log.d(TAG, "showProgressBar: ");
        // Create a progress dialog
        pDialog = new ProgressDialog(mContext);
        // Set progress dialog title
//        pDialog.setTitle("Restaurant");
        // Set progress dialog message
        pDialog.setMessage("Loading...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        // Show progressbar
        pDialog.show();
    }

    private void hideProgressBar() {
        Log.d(TAG, "hideProgressBar: ");
        pDialog.dismiss();
    }

}
