package hu.balpo.rategp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.R;
import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.adapter.ReviewListAdapter;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.presenter.ReviewListPresenter;
import hu.balpo.rategp.screen.ReviewListScreen;

public class ReviewListFragment extends ListFragment implements ReviewListScreen {

    @Inject
    ReviewListPresenter reviewListPresenter;

    private ReviewListAdapter reviewListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RateGpApplication.injector.inject(this);

        reviewListAdapter = new ReviewListAdapter();
        reviewListPresenter.attachView(this);

        long eventId = getActivity().getIntent().getLongExtra("eventId", 0);
        List<ReviewRecord> reviews = ReviewRecord.find(ReviewRecord.class, "event_Record = ?", String.valueOf(eventId));
        reviewListAdapter.setReviews(reviews);
        setListAdapter(reviewListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_reviewlist, container, false);
        return fragmentView;
    }

    @Override
    public void onDestroy() {
        reviewListPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showReviewList(List<ReviewRecord> reviews) {
        reviewListAdapter.setReviews(reviews);
        reviewListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSnackBarWithMessage(String message) {
        Snackbar.make(getActivity().findViewById(R.id.event_view),message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public long getEventId() {
        return getActivity().getIntent().getLongExtra("eventId", 0);
    }
}
