package com.example.mapdemo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdate;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private GoogleMap map;
	private Button btnTest;
	private EditText edtLatitude;
	private EditText edtLongtitude;
	private double lat=37.338208;
	private double lon=-121.886329;
	LatLng ll=new LatLng(37.338208,-121.886329);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnTest=(Button) findViewById(R.id.test);
		edtLatitude=(EditText) findViewById(R.id.edtLatitude);
		edtLongtitude=(EditText) findViewById(R.id.edtLongtitude);
		
		map=((MapFragment) getFragmentManager().findFragmentById(R.id.fragment1)).getMap();
		
		map.addMarker(new MarkerOptions().position(ll).title("Marker"));
		map.moveCamera(CameraUpdateFactory.newLatLng(ll));
		btnTest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try
				{
					lat=Double.parseDouble(edtLatitude.getText().toString());
					lon=Double.parseDouble(edtLongtitude.getText().toString());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		//map.setMyLocationEnabled(true);
		

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void onClick_zoom(View v)
	{
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		ll=new LatLng(lat,lon);
		map.clear();
		CameraUpdate update=CameraUpdateFactory.newLatLngZoom(ll, 12);
		map.addMarker(new MarkerOptions().position(ll).title("Marker"));
		map.moveCamera(CameraUpdateFactory.newLatLng(ll));
		map.animateCamera(update);
	}
	public void onClick_resume(View v)
	{
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		ll=new LatLng(lat,lon);
		map.clear();
		CameraUpdate update=CameraUpdateFactory.newLatLngZoom(ll, 1);
		map.addMarker(new MarkerOptions().position(ll).title("Marker"));
		
		map.moveCamera(CameraUpdateFactory.newLatLng(ll));
		map.animateCamera(update);
	}
	
}
