package hu.balpo.rategp.presenter;

import hu.balpo.rategp.screen.SeriesDetailsScreen;

public class SeriesDetailsPresenter {

    protected SeriesDetailsScreen screen;

    public void attachView(SeriesDetailsScreen screen){
        this.screen = screen;
    }

    public void detachView(){
        this.screen = null;
    }

    public void onSeriesDetailsLoaded(){
        this.screen.showSeriesDetails();
    }
}
