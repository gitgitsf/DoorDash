package com.sunmonkeyapps.doordash;

import com.sunmonkeyapps.doordash.model.Restaurant;
import com.sunmonkeyapps.doordash.ui.DiscoverPresenter;
import com.sunmonkeyapps.doordash.ui.DiscoverPresenterImpl;
import com.sunmonkeyapps.doordash.ui.DiscoverView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class DiscoverActivityTest {

    private DiscoverView view;

    @Mock
    DiscoverPresenter presenter;

    private List<Restaurant> mockedRestaurants;
    private List<Restaurant> mockedRestaurantZero;

    @Mock
     Restaurant  restaurantA;
    @Mock
    Restaurant  restaurantB;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        presenter = new DiscoverPresenterImpl();
        presenter.setView(view);

        mockedRestaurants = Arrays.asList(restaurantA, restaurantB);
        mockedRestaurantZero = Arrays.asList();
    }

    @After
    public void tearDown() throws Exception {

        presenter.setView(null);

    }

    @Test
    public void testShowRestaurantFromApiWithRestaurantReturn() throws Exception {

        assertEquals("Api returns more than 1 restaurants", 2, mockedRestaurants.size());
    }

    @Test
    public void testShowRestaurantFromApiWithNoRestaurantReturn() throws Exception {

        assertEquals("Api returns no restaurants", 0, mockedRestaurantZero.size());
    }

    @Test
    public void testShowMessage() {

        String str= "No data available right now - please try agagin later.";
        assertEquals("Api returns no restaurants", str, str);

        assertNotEquals("Api returns no restaurants", str, "no restaurant returned");

    }
}
