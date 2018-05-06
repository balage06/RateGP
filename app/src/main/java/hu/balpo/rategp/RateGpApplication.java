package hu.balpo.rategp;

import android.app.Application;

import com.orm.SugarApp;

import hu.balpo.rategp.network.NetworkModule;
import hu.balpo.rategp.screen.UIModule;

public class RateGpApplication extends SugarApp {

    public static RateGpApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerRateGpApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
