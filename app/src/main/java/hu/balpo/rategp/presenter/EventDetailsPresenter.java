package hu.balpo.rategp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.event.PostReviewEvent;
import hu.balpo.rategp.screen.EventDetailsScreen;

public class EventDetailsPresenter {
    protected EventDetailsScreen screen;

    public void attachView(EventDetailsScreen screen){
        this.screen = screen;
        RateGpApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    public void detachView(){
        this.screen = null;
        EventBus.getDefault().unregister(this);
    }

    public void onEventDetailsLoaded(EventRecord event, List<ReviewRecord> reviews){
        this.screen.showEventDetails(event, reviews);
    }

    public void onEventReviewSubmit(){
        this.screen.refreshReviewList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSeriesListEventReceived(final PostReviewEvent postReviewEvent){
        if(postReviewEvent.getT() != null){
        } else {
            EventRecord eventRecord = EventRecord.findById(EventRecord.class, this.screen.getEventId());
            List<ReviewRecord> reviews = ReviewRecord.find(ReviewRecord.class, "event_Record = ?", String.valueOf(eventRecord.getId()));
            this.screen.showEventDetails(eventRecord, reviews);
        }
    }
}
