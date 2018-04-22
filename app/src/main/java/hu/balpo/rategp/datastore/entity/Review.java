package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class Review extends SugarRecord<Review> {
    int rating;
    String comment;
    String username;
    Event event;

    public Review(){}

    public Review(int rating, String comment, String username, Event event){
        this.rating = rating;
        this.comment = comment;
        this.username = username;
        this.event = event;
    }
}
