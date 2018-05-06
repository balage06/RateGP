package hu.balpo.rategp.interactor;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.event.LoginEvent;
import hu.balpo.rategp.model.ApiResponse;
import hu.balpo.rategp.network.AuthenticationInterceptor;
import hu.balpo.rategp.network.api.UserApi;
import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {
    @Inject
    AuthenticationInterceptor authenticationInterceptor;

    @Inject
    UserApi userApi;

    public LoginInteractor(){
        RateGpApplication.injector.inject(this);
    }

    public void performLogin(String username, String password){
        authenticationInterceptor.setCredentials(Credentials.basic(username,password));

        final Call<ApiResponse> login = userApi.login();
        login.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                LoginEvent loginEvent = new LoginEvent();
                if(response.body().getCode() == 200){
                    loginEvent.setSuccess(true);
                } else {
                    loginEvent.setSuccess(false);
                }
                EventBus.getDefault().post(loginEvent);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new LoginEvent(false));
            }
        });
    }
}
