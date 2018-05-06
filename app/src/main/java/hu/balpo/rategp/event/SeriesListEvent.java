package hu.balpo.rategp.event;

import java.util.List;

import hu.balpo.rategp.model.Serie;

public class SeriesListEvent {
    private List<Serie> series;
    private Throwable t;

    public SeriesListEvent(){}
    public SeriesListEvent(Throwable t){
        this.t = t;
    }
    public SeriesListEvent(List<Serie> series){
        this.series = series;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public Throwable getT() {
        return t;
    }

    public void setT(Throwable t) {
        this.t = t;
    }
}
