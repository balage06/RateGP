package hu.balpo.rategp.interactor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.datastore.entity.SerieRecord;
import hu.balpo.rategp.model.Event;
import hu.balpo.rategp.model.Review;
import hu.balpo.rategp.model.Serie;

@Singleton
public class DataStoreInteractor {

    @Inject
    public DataStoreInteractor(){}

    public static void clearDataStore(){
        ReviewRecord.deleteAll(ReviewRecord.class);
        EventRecord.deleteAll(EventRecord.class);
        SerieRecord.deleteAll(SerieRecord.class);
    }

    public static void saveSeriesListToDataStore(List<Serie> series){
        for(Serie serie : series){
            SerieRecord s = new SerieRecord(serie.getId(), serie.getName());
            s.save();
            for(Event event : serie.getEvents()){
                EventRecord e = new EventRecord(event.getId(),event.getName(),s);
                e.save();
                for(Review review : event.getRatings()){
                    ReviewRecord r = new ReviewRecord(review.getId(),review.getRating(), review.getComment(), review.getUsername(), e);
                    r.save();
                }
            }
        }
    }

    public static List<SerieRecord> getAllSeries(){
        return SerieRecord.listAll(SerieRecord.class);
    }

    public static List<EventRecord> getAllEventsBySerie(SerieRecord serie){
        return EventRecord.find(EventRecord.class, "serie = ?", String.valueOf(serie.getId()));
    }

    public static List<ReviewRecord> getAllReviesByEvent(EventRecord event){
        return ReviewRecord.find(ReviewRecord.class, "event = ?", String.valueOf(event.getId()));
    }
}
