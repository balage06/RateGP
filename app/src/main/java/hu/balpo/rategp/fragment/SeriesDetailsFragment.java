package hu.balpo.rategp.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.R;
import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.activity.EventDetailsActivity;
import hu.balpo.rategp.adapter.SeriesDetailsAdapter;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.presenter.SeriesDetailsPresenter;
import hu.balpo.rategp.screen.SeriesDetailsScreen;

public class SeriesDetailsFragment extends ListFragment implements SeriesDetailsScreen {

    @Inject
    SeriesDetailsPresenter seriesDetailsPresenter;

    private SeriesDetailsAdapter seriesDetailsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateGpApplication.injector.inject(this);

        seriesDetailsAdapter = new SeriesDetailsAdapter();
        setListAdapter(seriesDetailsAdapter);
        seriesDetailsPresenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_seriesdetails, container, false);
        return fragmentView;
    }

    @Override
    public void onResume() {
        long seriesId = getActivity().getIntent().getLongExtra("serieId", 0);
        List<EventRecord> events = EventRecord.find(EventRecord.class, "serie_Record = ?", String.valueOf(seriesId));
        seriesDetailsAdapter.setEvents(events);
        seriesDetailsAdapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        seriesDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showSeriesDetails(List<EventRecord> events) {

    }

    @Override
    public void showSnackBarWithMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.seriesdetails_view),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        EventRecord event = (EventRecord) seriesDetailsAdapter.getItem(position);

        Intent startIntent = new Intent(getActivity(), EventDetailsActivity.class);
        startIntent.putExtra("eventId", event.getId());
        startIntent.putExtra( "serieId", getActivity().getIntent().getLongExtra("serieId", 0));
        getActivity().startActivity(startIntent);
    }
}
