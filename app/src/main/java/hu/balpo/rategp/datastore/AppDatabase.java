package hu.balpo.rategp.datastore;

import java.util.List;

import hu.balpo.rategp.datastore.entity.Event;
import hu.balpo.rategp.datastore.entity.Review;
import hu.balpo.rategp.datastore.entity.Serie;

public final class AppDatabase {
    private AppDatabase(){}

    public static List<Serie> getAllSeries(){
        return Serie.listAll(Serie.class);
    }

    public static List<Event> getAllEventsBySerie(Serie serie){
        return Event.find(Event.class, "serie = ?", String.valueOf(serie.getId()));
    }

    public static List<Review> getAllReviesByEvent(Event event){
        return Review.find(Review.class, "event = ?", String.valueOf(event.getId()));
    }
}
