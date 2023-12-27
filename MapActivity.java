import android.app.Activity;  
import android.content.Context;  
import android.content.Intent;  
import android.os.Build;  
import android.os.Bundle;  
import android.support.v4.app.ActivityCompat;  
import android.support.v4.app.Fragment;  
import android.support.v4.app.FragmentActivity;  
import android.support.v4.app.FragmentManager;  
import android.support.v4.content.ContextCompat;  
import com.google.android.gms.maps.CameraUpdate;  
import com.google.android.gms.maps.CameraUpdateFactory;  
import com.google.android.gms.maps.GoogleMap;  
import com.google.android.gms.maps.OnMapReadyCallback;  
import com.google.android.gms.maps.SupportMapFragment;  
import com.google.android.gms.maps.model.LatLng;  
import com.google.android.gms.maps.model.Marker;  
import com.google.android.gms.maps.model.MarkerOptions;  
public class MapsActivity  
extends FragmentActivity  
implements OnMapReadyCallback {  
public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;  
private GoogleMap mMap;  
public boolean checkLocationPermission() {  
if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.ACCESS_FINE_LOCATION") != 0) {  
if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this, (String)"android.permission.ACCESS_FINE_LOCATION")) {  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.ACCESS_FINE_LOCATION"}, (int)99);  
return false;  
}  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.ACCESS_FINE_LOCATION"}, (int)99);  
return false;  
}  
return true;  
}  
public boolean checkSMSPermission() {  
if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.RECEIVE_MMS") != 0) {  
if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this, (String)"android.permission.RECEIVE_SMS")) {  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECEIVE_SMS"}, (int)99);  
return false;  
}  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.RECEIVE_SMS"}, (int)99);  
return false;  
}  
return true;  
}  
protected void onCreate(Bundle bundle) {  
super.onCreate(bundle);  
this.setContentView(2131296283);  
((SupportMapFragment)this.getSupportFragmentManager().findFragmentById(2131165272)).getMapAsync((OnMapReadyCallback)this);  
this.checkSMSPermission();  
}  
public void onMapReady(GoogleMap googleMap) {  
this.mMap = googleMap;  
Bundle bundle = this.getIntent().getExtras();  
if (bundle != null) {  
try {  
Double d = Double.parseDouble((String)bundle.getString("lat"));  
Double d2 = Double.parseDouble((String)bundle.getString("lon"));  
LatLng latLng = new LatLng(d.doubleValue(), d2.doubleValue());  
this.mMap.addMarker(new MarkerOptions().position(latLng).title(bundle.getString("type")));  
this.mMap.moveCamera(CameraUpdateFactory.newLatLng((LatLng)latLng));  
}  
catch (Exception exception) {  
// empty catch block  
}  
}  
if (Build.VERSION.SDK_INT >= 23) {  
this.checkLocationPermission();  
this.mMap.setMyLocationEnabled(true);  
return;  
}  
this.mMap.setMyLocationEnabled(true);  
}  
} 