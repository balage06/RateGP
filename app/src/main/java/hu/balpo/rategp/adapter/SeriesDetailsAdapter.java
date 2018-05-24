package hu.balpo.rategp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.balpo.rategp.R;
import hu.balpo.rategp.datastore.entity.EventRecord;
import hu.balpo.rategp.datastore.entity.ReviewRecord;
import hu.balpo.rategp.model.Event;

public class SeriesDetailsAdapter extends BaseAdapter {

    private List<EventRecord> events = new ArrayList<>();

    public SeriesDetailsAdapter(){}

    public SeriesDetailsAdapter(List<EventRecord> events){
        this.events = events;
    }

    public void setEvents(List<EventRecord> events){
        this.events = events;
    }

    @Override
    public int getCount() {
        return this.events.size();
    }

    @Override
    public Object getItem(int position) {
        return this.events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.events.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final EventRecord event = events.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.fragment_row_seriesdetails, null);

        TextView title = itemView.findViewById(R.id.row1);
        title.setText(event.getName());

        TextView details = itemView.findViewById(R.id.row2);

        List<ReviewRecord> reviews = ReviewRecord.find(ReviewRecord.class, "event_Record = ?", String.valueOf(event.getId()));
        details.setText("Reviews: " + reviews.size());
        return itemView;
    }
}
