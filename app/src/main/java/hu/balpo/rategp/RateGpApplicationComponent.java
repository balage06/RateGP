package hu.balpo.rategp;

import javax.inject.Singleton;

import dagger.Component;
import hu.balpo.rategp.activity.LoginActivity;
import hu.balpo.rategp.activity.MainActivity;
import hu.balpo.rategp.interactor.InteractorModule;
import hu.balpo.rategp.interactor.LoginInteractor;
import hu.balpo.rategp.network.NetworkModule;
import hu.balpo.rategp.presenter.LoginPresenter;
import hu.balpo.rategp.screen.UIModule;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface RateGpApplicationComponent {
    void inject(LoginActivity loginActivity);
    void inject(LoginInteractor loginInteractor);
    void inject(LoginPresenter loginPresenter);
    void inject(MainActivity mainActivity);
}
