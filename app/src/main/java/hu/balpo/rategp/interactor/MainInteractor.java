package hu.balpo.rategp.interactor;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.event.PostReviewEvent;
import hu.balpo.rategp.event.SeriesListEvent;
import hu.balpo.rategp.model.Review;
import hu.balpo.rategp.model.Serie;
import hu.balpo.rategp.network.api.SeriesApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor {

    @Inject
    SeriesApi seriesApi;

    public MainInteractor(){
        RateGpApplication.injector.inject(this);
    }

    public void getSeriesList(){
        Call<List<Serie>> seriesList = seriesApi.getSeriesList();
        seriesList.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Call<List<Serie>> call, Response<List<Serie>> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new SeriesListEvent(response.body()));
                } else{
                    EventBus.getDefault().post(new SeriesListEvent(new Throwable("fail")));
                }
            }

            @Override
            public void onFailure(Call<List<Serie>> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new SeriesListEvent(t));
            }
        });
    }

    public void postReview(long seriesId, long eventId, final Review review){
        Call<Void> postReview = seriesApi.postReviewForEvent(seriesId,eventId, review);
        postReview.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    EventBus.getDefault().post(new PostReviewEvent(review));
                } else {
                    EventBus.getDefault().post(new PostReviewEvent(new Throwable("fail")));
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                EventBus.getDefault().post(new PostReviewEvent(t));
            }
        });
    }
}
