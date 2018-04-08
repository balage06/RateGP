package hu.balpo.rategp.presenter;

import hu.balpo.rategp.screen.SeriesListScreen;

public class SeriesListPresenter {

    protected SeriesListScreen screen;

    public void attachView(SeriesListScreen screen){
        this.screen = screen;
    }

    public void detachView(){
        this.screen = null;
    }

    public void onSeriesListUpdated(){
        this.screen.showSeriesList();
    }

    public void onSeriesListItemSelected(){
        //TODO: Navigate to the Series detail screen
    }
}
