package hu.balpo.rategp.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import hu.balpo.rategp.R;
import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.presenter.LoginPresenter;
import hu.balpo.rategp.screen.LoginScreen;

public class LoginActivity extends AppCompatActivity implements LoginScreen{

    @Inject
    protected LoginPresenter loginPresenter;

    private View loginView;
    private EditText username;
    private EditText password;
    private ProgressBar progressBar;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginView = findViewById(R.id.loginView);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.login_progessBar);
        loginButton = findViewById(R.id.loginButton);

        RateGpApplication.injector.inject(this);

        loginPresenter.attachView(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLoginButtonPressed(username.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        this.loginPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showLoginButton() {
        loginButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginButton() {
        loginButton.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSnackBarWithMessage(String message) {
        Snackbar.make(loginView,message,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void switchToMainActivity() {
        Intent startMainIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(startMainIntent);
        LoginActivity.this.finish();
    }
}
