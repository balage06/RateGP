package hu.balpo.rategp.screen;

public interface LoginScreen {
    void showLoginButton();
    void hideLoginButton();
    void showProgressBar();
    void hideProgressBar();
    void showSnackBarWithMessage(String message);
    void switchToMainActivity();
}
