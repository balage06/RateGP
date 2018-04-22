package hu.balpo.rategp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import hu.balpo.rategp.R;
import hu.balpo.rategp.presenter.SeriesDetailsPresenter;
import hu.balpo.rategp.screen.SeriesDetailsScreen;

public class SeriesDetailsActivity  extends AppCompatActivity implements SeriesDetailsScreen{

    private SeriesDetailsPresenter seriesDetailsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seriesdetails);

        seriesDetailsPresenter = new SeriesDetailsPresenter();
        seriesDetailsPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        seriesDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showSeriesDetails() {

    }
}
