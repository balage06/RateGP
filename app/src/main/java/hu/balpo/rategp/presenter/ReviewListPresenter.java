package hu.balpo.rategp.presenter;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.event.PostReviewEvent;
import hu.balpo.rategp.interactor.DataStoreInteractor;
import hu.balpo.rategp.interactor.MainInteractor;
import hu.balpo.rategp.screen.ReviewListScreen;

public class ReviewListPresenter {

    @Inject
    MainInteractor mainInteractor;

    @Inject
    DataStoreInteractor dataStoreInteractor;

    protected ReviewListScreen screen;

    public void attachView(ReviewListScreen screen){
        this.screen = screen;
        RateGpApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    public void detachView(){
        this.screen = null;
        EventBus.getDefault().unregister(this);
    }

    public void onSeriesListUpdated(List<ReviewRecord> reviews){
        this.screen.showReviewList(reviews);
    }

    public void onSeriesListItemSelected(){
        //TODO: Navigate to the Series detail screen
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSeriesListEventReceived(final PostReviewEvent postReviewEvent){
        if(postReviewEvent.getT() != null){
            this.screen.showSnackBarWithMessage("Failed to post your review. Please try again.");
        } else {
            EventRecord eventRecord = EventRecord.findById(EventRecord.class, this.screen.getEventId());
            ReviewRecord newReview = new ReviewRecord(0, postReviewEvent.getReview().getRating(),postReviewEvent.getReview().getComment(),postReviewEvent.getReview().getUsername(), eventRecord);
            newReview.save();

            List<ReviewRecord> reviews = ReviewRecord.find(ReviewRecord.class, "event_Record = ?", String.valueOf(eventRecord.getId()));

            this.screen.showReviewList(reviews);
            this.screen.showSnackBarWithMessage("Review added successfully.");
        }
    }
}
