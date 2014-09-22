package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends Activity {
	GoogleMap map;
	ImageView imBuild, imRoom;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeMap();
		addImageButtonListener();
	}

	private void initializeMap() {
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		BitmapDescriptor imageUCU = BitmapDescriptorFactory
				.fromResource(R.drawable.uculogo1);
		GroundOverlay ground = map.addGroundOverlay(new GroundOverlayOptions()
				.image(imageUCU)
				.position(new LatLng(15.980504, 120.560681), 0, 0)
				.transparency((float) 0.5));
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(15.980504, 120.560681), 17.0f));
	}

	@Override
	protected void onResume() {
		super.onResume();
		initializeMap();
	}

	public void addImageButtonListener() {
		imBuild = (ImageView) findViewById(R.id.imBuild);
		imRoom = (ImageView) findViewById(R.id.imRoom);

		imBuild.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent buildingGo = new Intent(MainActivity.this,
						Building.class);
				startActivity(buildingGo);
			}
		});

		imRoom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				Intent classroomGo = new Intent(MainActivity.this,
						ClassroomCBC.class);
				startActivity(classroomGo);
			}
		});
	}
}