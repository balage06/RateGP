package hu.balpo.rategp.interactor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    public LoginInteractor provideLoginInteractor(){
        return new LoginInteractor();
    }

    @Provides
    public MainInteractor mainInteractor(){
        return new MainInteractor();
    }

    @Provides
    @Singleton
    public DataStoreInteractor dataStoreInteractor() {return new DataStoreInteractor();}

    @Provides
    public SeriesDetailsInteractor seriesDetailsInteractor(){return new SeriesDetailsInteractor();}
}
