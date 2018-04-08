package hu.balpo.rategp.presenter;

import hu.balpo.rategp.screen.EventDetailsScreen;

public class EventDetailsPresenter {
    protected EventDetailsScreen screen;

    public void attachView(EventDetailsScreen screen){
        this.screen = screen;
    }

    public void detachView(){
        this.screen = null;
    }

    public void onEventDetailsLoaded(){
        this.screen.showEventDetails();
    }

    public void onEventReviewSubmit(){
        this.screen.refreshReviewList();
    }
}
