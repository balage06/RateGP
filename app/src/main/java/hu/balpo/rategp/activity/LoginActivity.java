package hu.balpo.rategp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.balpo.rategp.R;
import hu.balpo.rategp.network.AuthApi;
import hu.balpo.rategp.presenter.LoginPresenter;
import hu.balpo.rategp.screen.LoginScreen;

public class LoginActivity extends AppCompatActivity implements LoginScreen{

    private LoginPresenter loginPresenter;
    private AuthApi authApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        this.loginPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showLoginButton() {

    }

    @Override
    public void hideLoginButton() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
