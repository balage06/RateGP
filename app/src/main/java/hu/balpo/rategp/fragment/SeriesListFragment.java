package hu.balpo.rategp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import hu.balpo.rategp.presenter.SeriesListPresenter;
import hu.balpo.rategp.screen.SeriesListScreen;

public class SeriesListFragment extends Fragment implements SeriesListScreen{

    private SeriesListPresenter seriesListPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        seriesListPresenter = new SeriesListPresenter();
        seriesListPresenter.attachView(this);
    }

    @Override
    public void onDestroy() {
        seriesListPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showSeriesList() {

    }
}
