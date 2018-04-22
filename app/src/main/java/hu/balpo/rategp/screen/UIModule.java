package hu.balpo.rategp.screen;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import hu.balpo.rategp.presenter.EventDetailsPresenter;
import hu.balpo.rategp.presenter.LoginPresenter;
import hu.balpo.rategp.presenter.SeriesDetailsPresenter;
import hu.balpo.rategp.presenter.SeriesListPresenter;
import hu.balpo.rategp.presenter.TopListPresenter;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context){
        this.context = context;
    }

    @Provides
    public Context context(){
        return context;
    }

    @Provides
    public LoginPresenter loginPresenter(){
        return new LoginPresenter();
    }

    @Provides
    public SeriesListPresenter seriesListPresenter(){
        return new SeriesListPresenter();
    }

    @Provides
    public TopListPresenter topListPresenter(){
        return new TopListPresenter();
    }

    @Provides
    public SeriesDetailsPresenter seriesDetailsPresenter(){
        return new SeriesDetailsPresenter();
    }

    @Provides
    public EventDetailsPresenter eventDetailsPresenter(){
        return new EventDetailsPresenter();
    }

}
