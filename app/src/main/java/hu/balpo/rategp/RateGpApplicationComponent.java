package hu.balpo.rategp;

import javax.inject.Singleton;

import dagger.Component;
import hu.balpo.rategp.activity.EventDetailsActivity;
import hu.balpo.rategp.activity.LoginActivity;
import hu.balpo.rategp.activity.MainActivity;
import hu.balpo.rategp.fragment.ReviewListFragment;
import hu.balpo.rategp.fragment.SeriesDetailsFragment;
import hu.balpo.rategp.fragment.SeriesListFragment;
import hu.balpo.rategp.interactor.InteractorModule;
import hu.balpo.rategp.interactor.LoginInteractor;
import hu.balpo.rategp.interactor.MainInteractor;
import hu.balpo.rategp.interactor.SeriesDetailsInteractor;
import hu.balpo.rategp.network.NetworkModule;
import hu.balpo.rategp.presenter.EventDetailsPresenter;
import hu.balpo.rategp.presenter.LoginPresenter;
import hu.balpo.rategp.presenter.ReviewListPresenter;
import hu.balpo.rategp.presenter.SeriesDetailsPresenter;
import hu.balpo.rategp.presenter.SeriesListPresenter;
import hu.balpo.rategp.screen.UIModule;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface RateGpApplicationComponent {
    void inject(LoginActivity loginActivity);
    void inject(LoginInteractor loginInteractor);
    void inject(LoginPresenter loginPresenter);
    void inject(MainActivity mainActivity);
    void inject(SeriesListFragment seriesListFragment);
    void inject(MainInteractor mainInteractor);
    void inject(SeriesListPresenter seriesListPresenter);
    void inject(SeriesDetailsPresenter seriesDetailsPresenter);
    void inject(SeriesDetailsFragment seriesDetailsFragment);
    void inject(SeriesDetailsInteractor seriesDetailsInteractor);
    void inject(EventDetailsActivity eventDetailsActivity);
    void inject(EventDetailsPresenter eventDetailsPresenter);
    void inject(ReviewListFragment reviewListFragment);
    void inject(ReviewListPresenter reviewListPresenter);
}
