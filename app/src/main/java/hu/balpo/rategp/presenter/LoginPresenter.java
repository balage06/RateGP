package hu.balpo.rategp.presenter;

import hu.balpo.rategp.screen.LoginScreen;

public class LoginPresenter {

    protected LoginScreen screen;

    public void attachView(LoginScreen screen){
        this.screen = screen;
    }

    public void detachView(){
        this.screen = null;
    }

    public void onLoginButtonPressed(){
        this.screen.hideLoginButton();
        this.screen.showProgressBar();
    }

    public void onLoginFailure(){
        this.screen.hideProgressBar();
        this.screen.showLoginButton();
    }

    public void onLoginSuccess(){
        //TODO
    }
}
