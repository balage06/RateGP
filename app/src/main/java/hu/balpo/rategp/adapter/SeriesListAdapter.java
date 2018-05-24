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
import hu.balpo.rategp.datastore.entity.SerieRecord;

public class SeriesListAdapter extends BaseAdapter {

    private List<SerieRecord> series = new ArrayList<>();

    public SeriesListAdapter(){}

    public SeriesListAdapter(List<SerieRecord> series){
        this.series = series;
    }

    public void setSeries(List<SerieRecord> series){
        this.series = series;
    }

    @Override
    public int getCount() {
        return series.size();
    }

    @Override
    public Object getItem(int position) {
        return series.get(position);
    }

    @Override
    public long getItemId(int position) {
        return series.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SerieRecord serie = series.get(position);

        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.fragment_row_serieslist, null);

        TextView title = itemView.findViewById(R.id.row1);
        title.setText(serie.getName());

        TextView details = itemView.findViewById(R.id.row2);

        List<EventRecord> events = EventRecord.find(EventRecord.class, "serie_Record = ?",String.valueOf(serie.getId()));

        details.setText("Events: " + events.size());
        return itemView;
    }
}
