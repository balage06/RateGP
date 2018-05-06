package hu.balpo.rategp.network;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class AuthenticationInterceptor implements Interceptor {
    private String credentials;

    @Inject
    public AuthenticationInterceptor(){}

    public void setCredentials(String credentials){
        this.credentials = credentials;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization", credentials);

        Request request = builder.build();
        return chain.proceed(request);
    }
}