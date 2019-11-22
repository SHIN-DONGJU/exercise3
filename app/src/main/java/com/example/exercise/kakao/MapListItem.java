package com.example.exercise.kakao;

import androidx.fragment.app.FragmentActivity;

import com.example.exercise.R;
import com.example.exercise.kakao.map.CameraActivity;
import com.example.exercise.kakao.map.EventsActivity;
import com.example.exercise.kakao.map.LocationActivity;
import com.example.exercise.kakao.map.MarkerActivity;
import com.example.exercise.kakao.map.PolygonActivity;


public class MapListItem {
	public final int titleId;
	public final int descriptionId;

	public final Class<? extends FragmentActivity> activity;

	public MapListItem(int titleId, int descriptionId,
                       Class<? extends FragmentActivity> activity) {
		this.titleId = titleId;
		this.descriptionId = descriptionId;
		this.activity = activity;
	}

	public static final MapListItem[] DEMO_LIST_ITEMS = {
			new MapListItem(R.string.map_view_demo_title,
					R.string.map_view_demo_desc, MapViewActivity.class),
			new MapListItem(R.string.marker_demo_title,
					R.string.marker_demo_desc, MarkerActivity.class),
			new MapListItem(R.string.polygon_demo_title,
					R.string.polygon_demo_desc, PolygonActivity.class),
			new MapListItem(R.string.location_demo_title,
					R.string.location_demo_desc, LocationActivity.class),
			new MapListItem(R.string.camera_demo_title,
					R.string.camera_demo_desc, CameraActivity.class),
			new MapListItem(R.string.events_demo_title,
					R.string.events_demo_desc, EventsActivity.class)
	};
}
