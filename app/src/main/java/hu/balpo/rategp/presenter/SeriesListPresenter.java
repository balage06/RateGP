package hu.balpo.rategp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.event.SeriesListEvent;
import hu.balpo.rategp.interactor.MainInteractor;
import hu.balpo.rategp.model.Serie;
import hu.balpo.rategp.screen.SeriesListScreen;

public class SeriesListPresenter {

    @Inject
    MainInteractor mainInteractor;

    protected SeriesListScreen screen;

    public void attachView(SeriesListScreen screen){
        this.screen = screen;
        RateGpApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    public void detachView(){
        this.screen = null;
        EventBus.getDefault().unregister(this);
    }

    public void onSeriesListUpdated(List<Serie> series){
        this.screen.showSeriesList(series);
    }

    public void onSeriesListItemSelected(){
        //TODO: Navigate to the Series detail screen
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSeriesListEventReceived(final SeriesListEvent seriesListEvent){
        if(seriesListEvent.getT() != null){
            this.screen.showSnackBarWithMessage("Failed to synchronize series with the backend.");
        } else {
            this.screen.showSeriesList(seriesListEvent.getSeries());
        }
    }

    public void syncSeriesWithBackend(){
        mainInteractor.getSeriesList();
    }
}
