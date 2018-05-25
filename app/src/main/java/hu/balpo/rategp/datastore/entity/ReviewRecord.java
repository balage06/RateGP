package hu.balpo.rategp.datastore.entity;

import com.orm.SugarRecord;

public class ReviewRecord extends SugarRecord<ReviewRecord> {
    long reviewId;
    int rating;
    String comment;
    String username;
    EventRecord eventRecord;

    public ReviewRecord(){}

    public ReviewRecord(long reviewId, int rating, String comment, String username, EventRecord eventRecord){
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.username = username;
        this.eventRecord = eventRecord;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EventRecord getEventRecord() {
        return eventRecord;
    }

    public void setEventRecord(EventRecord eventRecord) {
        this.eventRecord = eventRecord;
    }
}
