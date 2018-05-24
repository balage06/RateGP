package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.datastore.entity.SerieRecord;

public interface SeriesListScreen {
    void showSeriesList(List<SerieRecord> series);
    void showSnackBarWithMessage(String message);
}
