package hu.balpo.rategp.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.event.LoginEvent;
import hu.balpo.rategp.interactor.LoginInteractor;
import hu.balpo.rategp.screen.LoginScreen;

public class LoginPresenter {

    @Inject
    LoginInteractor loginInteractor;

    protected LoginScreen screen;

    public void attachView(LoginScreen screen){
        this.screen = screen;
        RateGpApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    public void detachView(){
        this.screen = null;
        EventBus.getDefault().unregister(this);
    }

    public void onLoginButtonPressed(String username, String password){
        this.screen.hideLoginButton();
        this.screen.showProgressBar();
        loginInteractor.performLogin(username, password);
    }

    public void onLoginFailure(){
        this.screen.hideProgressBar();
        this.screen.showLoginButton();
        this.screen.showSnackBarWithMessage("Login error. Please try again.");
    }

    public void onLoginSuccess(){
        this.screen.switchToMainActivity();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoginEventReceived(final LoginEvent event){
        if(event.isSuccess()){
            onLoginSuccess();
        } else{
            onLoginFailure();
        }
    }
}
