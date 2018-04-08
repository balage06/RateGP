package hu.balpo.rategp.presenter;

import hu.balpo.rategp.screen.TopListScreen;

public class TopListPresenter {

    protected TopListScreen screen;

    public void attachView(TopListScreen screen){
        this.screen = screen;
    }

    public void detachView(){
        this.screen = null;
    }

    public void onTopListUpdated(){
        this.screen.showTopList();
    }
}
