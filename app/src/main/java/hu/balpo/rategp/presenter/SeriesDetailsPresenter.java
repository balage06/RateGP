package hu.balpo.rategp.presenter;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.interactor.SeriesDetailsInteractor;
import hu.balpo.rategp.screen.SeriesDetailsScreen;

public class SeriesDetailsPresenter {

    @Inject
    SeriesDetailsInteractor seriesDetailsInteractor;

    protected SeriesDetailsScreen screen;

    public void attachView(SeriesDetailsScreen screen){
        this.screen = screen;
        RateGpApplication.injector.inject(this);
    }

    public void detachView(){
        this.screen = null;
    }

    public void onSeriesDetailsLoaded(List<EventRecord> events){
        this.screen.showSeriesDetails(events);
    }
}
