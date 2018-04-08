package hu.balpo.rategp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.balpo.rategp.R;
import hu.balpo.rategp.network.SeriesApi;

public class MainActivity extends AppCompatActivity {

    private SeriesApi seriesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
