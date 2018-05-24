package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.datastore.entity.SerieRecord;

public interface ReviewListScreen {
    void showReviewList(List<ReviewRecord> reviews);
    void showSnackBarWithMessage(String message);
    long getEventId();
}
