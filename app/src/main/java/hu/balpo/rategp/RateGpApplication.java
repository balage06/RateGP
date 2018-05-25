package hu.balpo.rategp;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarApp;

import hu.balpo.rategp.screen.UIModule;
import io.fabric.sdk.android.Fabric;

public class RateGpApplication extends SugarApp {

    private static GoogleAnalytics sAnalytics;
    private static Tracker sTracker;

    public static RateGpApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerRateGpApplicationComponent.builder().uIModule(new UIModule(this)).build();

        sAnalytics = GoogleAnalytics.getInstance(this);
    }

    /**
     * Gets the default {@link Tracker} for this {@link RateGpApplication}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
        if (sTracker == null) {
            sTracker = sAnalytics.newTracker(R.xml.global_tracker);
        }

        return sTracker;
    }
}
