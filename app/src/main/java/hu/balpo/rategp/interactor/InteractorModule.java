package hu.balpo.rategp.interactor;

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
}
