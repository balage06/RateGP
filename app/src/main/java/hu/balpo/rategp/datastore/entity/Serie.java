package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class Serie extends SugarRecord<Serie> {
    String name;

    public Serie(){}

    public Serie(String name){
        this.name = name;
    }
}
