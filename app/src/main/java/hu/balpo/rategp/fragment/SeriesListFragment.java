package hu.balpo.rategp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.R;
import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.activity.SeriesDetailsActivity;
import hu.balpo.rategp.adapter.SeriesListAdapter;
import hu.balpo.rategp.datastore.entity.SerieRecord;
import hu.balpo.rategp.presenter.SeriesListPresenter;
import hu.balpo.rategp.screen.SeriesListScreen;

public class SeriesListFragment extends ListFragment implements SeriesListScreen{

    @Inject
    SeriesListPresenter seriesListPresenter;

    private SeriesListAdapter seriesListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateGpApplication.injector.inject(this);

        seriesListAdapter = new SeriesListAdapter();
        seriesListPresenter.attachView(this);
        seriesListPresenter.syncSeriesWithBackend();

        setListAdapter(seriesListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_serieslist, container, false);
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        seriesListPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showSeriesList(List<SerieRecord> series) {
        seriesListAdapter.setSeries(series);
        seriesListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSnackBarWithMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.main_view),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        SerieRecord serie = (SerieRecord) seriesListAdapter.getItem(position);
        super.onListItemClick(l, v, position, id);
        Intent startIntent = new Intent(getActivity(), SeriesDetailsActivity.class);
        startIntent.putExtra("serieId", serie.getId());
        getActivity().startActivity(startIntent);
    }
}
