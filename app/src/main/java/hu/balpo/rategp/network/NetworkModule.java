package hu.balpo.rategp.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.balpo.rategp.network.api.EventApi;
import hu.balpo.rategp.network.api.SeriesApi;
import hu.balpo.rategp.network.api.UserApi;
import hu.balpo.rategp.network.auth.HttpBasicAuth;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    public static final String BASE_URL = "http://192.168.2.100:8091/api";

    @Provides
    @Singleton
    public Retrofit.Builder retrofit(){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());
    }

    @Provides
    @Singleton
    public SeriesApi seriesApi(Retrofit.Builder retrofitBuilder){
        return retrofitBuilder.baseUrl(BASE_URL).build().create(SeriesApi.class);
    }

    @Provides
    @Singleton
    public EventApi eventApi(Retrofit.Builder retrofitBuilder){
        return retrofitBuilder.baseUrl(BASE_URL).build().create(EventApi.class);
    }

    @Provides
    @Singleton
    public UserApi userApi(Retrofit.Builder retrofitBulder){
        return retrofitBulder.baseUrl(BASE_URL).build().create(UserApi.class);
    }
}
