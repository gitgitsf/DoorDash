package com.sunmonkeyapps.doordash;

import com.sunmonkeyapps.doordash.model.Restaurant;
import com.sunmonkeyapps.doordash.ui.DiscoverPresenter;
import com.sunmonkeyapps.doordash.ui.DiscoverPresenterImpl;
import com.sunmonkeyapps.doordash.ui.DiscoverView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class DiscoverPresenterImplTest {

    private DiscoverPresenter presenter;
    private static double LAT = 37.422740;
    private static double LNG = -122.139956;

    private static int REQUEST_OFFSET = 0;
    private static int REQUEST_LIMIT = 50;

    @Mock
    private DiscoverView view;

    private List<Restaurant> mockedRestaurants;
    private List<Restaurant> mockedRestaurantZero;

    List<Restaurant> restaurantList = new ArrayList<>();

    @Mock
    Restaurant  restaurantA;
    @Mock
    Restaurant  restaurantB;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);// required for the "@Mock" annotations

        // Make presenter a mock while using mock
//        presenter = Mockito.spy(new DiscoverPresenterImpl());
        presenter =  new DiscoverPresenterImpl();
        presenter.setView(view);

        restaurantList.add(restaurantA);
        restaurantList.add(restaurantB);
    }

    @Test
    public void handleGetRestaurantsFromApi() throws Exception {

        mockedRestaurants = Arrays.asList(restaurantA, restaurantB);
        presenter.getRestaurantsFromApi();
        view.showPorgressBar();

        view.showRestaurantFromApi(mockedRestaurants);
        verify(view).showRestaurantFromApi(mockedRestaurants);

        view.hidePorgressBar();
        assertEquals("Api returns more than 1 restaurants", 2, mockedRestaurants.size());
    }

    @Test
    public void testGetRestaurantsFromApiWithNoData() throws Exception {

        mockedRestaurantZero = Arrays.asList();
        presenter.getRestaurantsFromApi();
        view.showPorgressBar();

        view.showRestaurantFromApi(mockedRestaurants);
        verify(view).showRestaurantFromApi(any());

        view.hidePorgressBar();
        assertEquals("Api returns no restaurants", 0, mockedRestaurantZero.size());
    }


}
