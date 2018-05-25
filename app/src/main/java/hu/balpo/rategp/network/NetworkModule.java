package hu.balpo.rategp.network;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.balpo.rategp.network.api.EventApi;
import hu.balpo.rategp.network.api.SeriesApi;
import hu.balpo.rategp.network.api.UserApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Module
public class NetworkModule {

    public static final String BASE_URL = "http://86.101.245.85:8080/api/";

    @Provides
    @Singleton
    AuthenticationInterceptor provideAuthorizationInterceptor(){
        return new AuthenticationInterceptor();
    }

    @Provides
    @Singleton
    public static OkHttpClient getClient(AuthenticationInterceptor authenticationInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(authenticationInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public static Retrofit.Builder getService(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client);
    }

    @Provides
    @Singleton
    public SeriesApi seriesApi(Retrofit.Builder retrofitBuilder){
        return retrofitBuilder.build().create(SeriesApi.class);
    }

    @Provides
    @Singleton
    public EventApi eventApi(Retrofit.Builder retrofitBuilder){
        return retrofitBuilder.build().create(EventApi.class);
    }

    @Provides
    @Singleton
    public UserApi userApi(Retrofit.Builder retrofitBulder){
        return retrofitBulder.build().create(UserApi.class);
    }
}
