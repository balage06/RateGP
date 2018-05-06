package hu.balpo.rategp.screen;

import java.util.List;

import hu.balpo.rategp.model.Serie;

public interface SeriesListScreen {
    void showSeriesList(List<Serie> series);
    void showSnackBarWithMessage(String message);
}
