package hu.balpo.rategp.event;

import hu.balpo.rategp.model.Review;

public class PostReviewEvent {
    private Review review;
    private Throwable t;

    public PostReviewEvent(){}

    public PostReviewEvent(Review review){
        this.review = review;
    }

    public PostReviewEvent(Throwable t){this.t = t;}

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Throwable getT() {
        return t;
    }

    public void setT(Throwable t) {
        this.t = t;
    }
}
