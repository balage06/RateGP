package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class Event extends SugarRecord<Event> {
    String name;
    Serie serie;

    public Event(){}

    public Event(String name, Serie serie){
        this.name = name;
        this.serie = serie;
    }

}
