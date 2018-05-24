package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;

public interface EventDetailsScreen {
    void showEventDetails(EventRecord event, List<ReviewRecord> reviews);
    void refreshReviewList();
    long getEventId();
}
