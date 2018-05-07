package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.model.Event;

public interface SeriesDetailsScreen {
    void showSeriesDetails(List<Event> events);
    void showSnackBarWithMessage(String message);
}
