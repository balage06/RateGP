package hu.balpo.rategp.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.balpo.rategp.R;
import hu.balpo.rategp.datastore.entity.ReviewRecord;

public class ReviewListAdapter extends BaseAdapter {

    private List<ReviewRecord> reviews = new ArrayList<>();

    public ReviewListAdapter(){}

    public ReviewListAdapter(List<ReviewRecord> reviews){
        this.reviews = reviews;
    }

    public void setReviews(List<ReviewRecord> reviews){
        this.reviews = reviews;
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int position) {
        return reviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reviews.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ReviewRecord review = reviews.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.fragment_row_reviewlist, null);

        TextView title = itemView.findViewById(R.id.row1);
        title.setText(review.getUsername());

        AppCompatRatingBar rating = itemView.findViewById(R.id.row_ratingBar);
        rating.setRating(review.getRating());

        TextView details = itemView.findViewById(R.id.row2);
        details.setText(review.getComment());
        return itemView;
    }
}
