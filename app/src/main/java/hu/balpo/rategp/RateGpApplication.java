package hu.balpo.rategp;

import com.orm.SugarApp;

import hu.balpo.rategp.screen.UIModule;

public class RateGpApplication extends SugarApp {

    public static RateGpApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerRateGpApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
