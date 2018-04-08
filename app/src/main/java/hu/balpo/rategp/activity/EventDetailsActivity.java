package hu.balpo.rategp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hu.balpo.rategp.R;
import hu.balpo.rategp.network.SeriesApi;
import hu.balpo.rategp.presenter.EventDetailsPresenter;
import hu.balpo.rategp.screen.EventDetailsScreen;

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsScreen{

    private SeriesApi seriesApi;
    private EventDetailsPresenter eventDetailsPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);

        eventDetailsPresenter = new EventDetailsPresenter();
        eventDetailsPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        eventDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showEventDetails() {

    }

    @Override
    public void refreshReviewList() {

    }
}
