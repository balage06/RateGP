package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.datastore.entity.ReviewRecord;

public interface ReviewListScreen {
    void showReviewList(List<ReviewRecord> reviews);
    void showSnackBarWithMessage(String message);
    long getEventId();
}
