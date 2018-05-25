package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class SerieRecord extends SugarRecord<SerieRecord> {
    long serieId;
    String name;

    public SerieRecord(){}

    public SerieRecord(long serieId, String name){
        this.serieId = serieId;
        this.name = name;
    }

    public long getSerieId() {
        return serieId;
    }

    public void setSerieId(long serieId) {
        this.serieId = serieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
