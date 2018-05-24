package hu.balpo.rategp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.Base64;
import java.util.List;

import javax.inject.Inject;

import hu.balpo.rategp.R;
import hu.balpo.rategp.RateGpApplication;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.datastore.entity.SerieRecord;
import hu.balpo.rategp.interactor.MainInteractor;
import hu.balpo.rategp.model.Review;
import hu.balpo.rategp.network.AuthenticationInterceptor;
import hu.balpo.rategp.presenter.EventDetailsPresenter;
import hu.balpo.rategp.screen.EventDetailsScreen;

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsScreen{

    @Inject
    protected EventDetailsPresenter eventDetailsPresenter;

    @Inject
    protected AuthenticationInterceptor authenticationInterceptor;

    @Inject
    MainInteractor mainInteractor;

    private TextView eventTitle;

    private Button sendReviewBtn;
    private AppCompatRatingBar eventRatingBar;
    private AppCompatRatingBar eventReviewRatingBar;
    private EditText eventReviewEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);

        RateGpApplication.injector.inject(this);
        eventDetailsPresenter.attachView(this);

        eventTitle = findViewById(R.id.event_title);

        sendReviewBtn = findViewById(R.id.event_review_sendBtn);
        eventRatingBar = findViewById(R.id.event_ratingBar);
        eventReviewRatingBar = findViewById(R.id.event_review_ratingBar);
        eventReviewEditText = findViewById(R.id.event_review_editText);

        long serieId = getIntent().getLongExtra("serieId", 0);
        long eventId = getIntent().getLongExtra("eventId", 0);
        final SerieRecord serie = SerieRecord.findById(SerieRecord.class, serieId);
        final EventRecord event =  EventRecord.findById(EventRecord.class, eventId);

        sendReviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Review newReview = new Review();
                newReview.setComment(eventReviewEditText.getText().toString());
                newReview.setRating((int)eventReviewRatingBar.getRating());
                newReview.setUsername(authenticationInterceptor.getUsername());
                mainInteractor.postReview(serie.getSerieId(), event.getEventId(), newReview);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        long eventId = getIntent().getLongExtra("eventId", 0);
        final EventRecord event =  EventRecord.findById(EventRecord.class, eventId);
        List<ReviewRecord> reviews = ReviewRecord.find(ReviewRecord.class, "event_Record = ?", String.valueOf(event.getId()));
        eventDetailsPresenter.onEventDetailsLoaded(event, reviews);
    }

    @Override
    protected void onDestroy() {
        eventDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showEventDetails(EventRecord event, List<ReviewRecord> reviews) {
        eventTitle.setText(event.getName());
        if(reviews.size() > 0){
            float numOfReviews = 0.0f;
            float sumOfReviews = 0.0f;
            for(ReviewRecord r : reviews){
                sumOfReviews += r.getRating();
                numOfReviews += 1.0f;
            }
            eventRatingBar.setRating(sumOfReviews / numOfReviews);
        }
    }

    @Override
    public void refreshReviewList() {

    }

    @Override
    public long getEventId() {
        return getIntent().getLongExtra("eventId", 0);
    }
}
