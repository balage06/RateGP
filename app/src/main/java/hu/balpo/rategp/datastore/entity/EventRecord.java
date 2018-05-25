package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class EventRecord extends SugarRecord<EventRecord> {
    long eventId;
    String name;
    SerieRecord serieRecord;

    public EventRecord(){}

    public EventRecord(long eventId, String name, SerieRecord serieRecord){
        this.eventId = eventId;
        this.name = name;
        this.serieRecord = serieRecord;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SerieRecord getSerieRecord() {
        return serieRecord;
    }

    public void setSerieRecord(SerieRecord serieRecord) {
        this.serieRecord = serieRecord;
    }
}
