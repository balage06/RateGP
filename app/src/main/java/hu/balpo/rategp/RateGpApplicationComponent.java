package hu.balpo.rategp;

import javax.inject.Singleton;

import dagger.Component;
import hu.balpo.rategp.activity.LoginActivity;
import hu.balpo.rategp.activity.MainActivity;
import hu.balpo.rategp.network.NetworkModule;
import hu.balpo.rategp.screen.UIModule;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface RateGpApplicationComponent {
    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
}
