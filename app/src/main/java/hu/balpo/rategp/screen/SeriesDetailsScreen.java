package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.datastore.entity.EventRecord;

public interface SeriesDetailsScreen {
    void showSeriesDetails(List<EventRecord> events);
    void showSnackBarWithMessage(String message);
}
