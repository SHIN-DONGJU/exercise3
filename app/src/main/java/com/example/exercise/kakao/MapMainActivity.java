package com.example.exercise.kakao;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.exercise.R;

public class MapMainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_main);

        ListAdapter adapter = new MapListAdapter(this, MapListItem.DEMO_LIST_ITEMS);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        MapListItem demo = (MapListItem) getListAdapter().getItem(position);
        startActivity(new Intent(this, demo.activity));
    }

}
