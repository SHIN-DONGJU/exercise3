package com.example.exercise.kakao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.exercise.R;

public class MapListAdapter extends ArrayAdapter<MapListItem> {

    public MapListAdapter(Context context, MapListItem[] demos) {
        super(context, R.layout.activity_map_list_item_view, demos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MapListItem demo = getItem(position);


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_map_list_item_view, null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(demo.titleId);

        TextView description = (TextView) convertView.findViewById(R.id.description);
        description.setText(demo.descriptionId);

        return convertView;
    }
}
