package hu.balpo.rategp.interactor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.balpo.rategp.datastore.entity.Event;
import hu.balpo.rategp.datastore.entity.Review;
import hu.balpo.rategp.datastore.entity.Serie;

@Singleton
public class DataStoreInteractor {

    @Inject
    public DataStoreInteractor(){}

    public static void clearDataStore(){
        Review.deleteAll(Review.class);
        Event.deleteAll(Event.class);
        Serie.deleteAll(Serie.class);
    }

    public static void saveSeriesListToDataStore(List<hu.balpo.rategp.model.Serie> series){
        for(hu.balpo.rategp.model.Serie serie : series){
            Serie s = new Serie(serie.getName());
            s.save();
            for(hu.balpo.rategp.model.Event event : serie.getEvents()){
                Event e = new Event(event.getName(),s);
                e.save();
                for(hu.balpo.rategp.model.Review review : event.getRatings()){
                    Review r = new Review(review.getRating(), review.getComment(), review.getUsername(), e);
                    r.save();
                }
            }
        }
    }

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
