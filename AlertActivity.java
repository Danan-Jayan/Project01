import android.app.Activity;  
import android.app.PendingIntent;  
import android.content.Context;  
import android.content.SharedPreferences;  
import android.location.Address;  
import android.location.Criteria;  
import android.location.Geocoder;  
import android.location.Location;  
import android.location.LocationListener;  
import android.location.LocationManager;  
import android.os.Bundle;  
import android.preference.PreferenceManager;  
import android.support.v4.app.ActivityCompat;  
import android.support.v4.content.ContextCompat;  
import android.support.v7.app.AppCompatActivity;  
import android.telephony.SmsManager;  
import android.view.View;  
import android.widget.Button;  
import android.widget.Toast;  
import java.io.IOException;  
import java.util.List;  
import java.util.Locale;  
public class AlertActivity  
extends AppCompatActivity  
implements LocationListener {  
public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;  
private String Address = "";  
Button Btnearth;  
Button Btnfire;  
Button Btnquit;  
Button Btnsunami;  
Button Btnvehicle;  
Location location;  
LocationManager locationManager;  
String provider;  
SharedPreferences sharedPreferences;  
public boolean checkLocationPermission() {  
if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.ACCESS_FINE_LOCATION") != 0) {  
if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this, (String)"android.permission.ACCESS_FINE_LOCATION")) {  
ActivityCompat.requestPermissions((Activity)this, (String[])new 
String[]{"android.permission.ACCESS_FINE_LOCATION"}, (int)99);  
return false;  
}  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.ACCESS_FINE_LOCATION"}, (int)99);  
return false;  
}  
return true;  
}  
public boolean checkSMSPermission() {  
if (ContextCompat.checkSelfPermission((Context)this, (String)"android.permission.SEND_SMS") != 0) {  
if (ActivityCompat.shouldShowRequestPermissionRationale((Activity)this, (String)"android.permission.SEND_SMS")) {  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.SEND_SMS"}, (int)99);  
return false;  
}  
ActivityCompat.requestPermissions((Activity)this, (String[])new String[]{"android.permission.SEND_SMS"}, (int)99);  
return false;  
}  
return true;  
}  
protected void onCreate(Bundle bundle) {  
String string2;  
super.onCreate(bundle);  
this.setContentView(2131296281);  
this.sharedPreferences = 
PreferenceManager.getDefaultSharedPreferences((Context)this);  
this.locationManager = (LocationManager)this.getSystemService("location");  
Criteria criteria = new Criteria();  
this.provider = string2 = this.locationManager.getBestProvider(criteria, false);  
if (string2 != null && !string2.equals((Object)"")) {  
this.location = this.locationManager.getLastKnownLocation(this.provider);  
this.locationManager.requestLocationUpdates(this.provider, 1000L, 1.0f, (LocationListener)this);  
Location location = this.location;  
if (location != null) {  
this.onLocationChanged(location);  
} else {  
Toast.makeText((Context)this.getBaseContext(), (CharSequence)"Location can't be retrieved", (int)0).show();  
}  
} else {  
Toast.makeText((Context)this.getBaseContext(), (CharSequence)"No Provider Found", (int)0).show();  
}  
this.checkSMSPermission();  
this.checkLocationPermission();  
this.Btnfire = (Button)this.findViewById(2131165215);  
this.Btnvehicle = (Button)this.findViewById(2131165221);  
this.Btnearth = (Button)this.findViewById(2131165214);  
this.Btnquit = (Button)this.findViewById(2131165216);  
this.Btnsunami = (Button)this.findViewById(2131165219);  
this.Btnfire.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
if (!AlertActivity.this.sharedPreferences.getString("mobile", "").equals((Object)"")) {  
for (String string2 : AlertActivity.this.sharedPreferences.getString("mobile", ",").split(",")) {  
if (string2.equals((Object)"")) continue;  
SmsManager smsManager = SmsManager.getDefault();  
smsManager.sendTextMessage(string2, null, "Emergency Situation - Need Help!!! Emergency due to Fire Accident. more details are in subsequent messages.", null, null);  
smsManager.sendTextMessage(string2, null, AlertActivity.this.sharedPreferences.getString("name", "") + "Approximate link for map to reach emergency site:\nhttp://maps.google.com/maps?q=" + String.valueOf((double)AlertActivity.this.location.getLatitude()) + "," + String.valueOf((double)AlertActivity.this.location.getLongitude()), null, null);  
smsManager.sendTextMessage(string2, null, "Approximate address of emergency location:\n" + AlertActivity.this.Address, null, null);  
}  
}  
}  
});  
this.Btnvehicle.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
if (!AlertActivity.this.sharedPreferences.getString("mobile", "").equals((Object)"")) {  
for (String string2 : AlertActivity.this.sharedPreferences.getString("mobile", "").split(",")) {  
if (string2.equals((Object)"")) continue;  
SmsManager smsManager = SmsManager.getDefault();  
smsManager.sendTextMessage(string2, null, "Emergency Situation - Need Help!!! Emergency due to Police station . more details are in subsequent messages.", null, null);  
smsManager.sendTextMessage(string2, null, AlertActivity.this.sharedPreferences.getString("name", "") + "Approximate link for map to reach emergency site:\nhttp://maps.google.com/maps?q=" + String.valueOf((double)AlertActivity.this.location.getLatitude()) + "," + String.valueOf((double)AlertActivity.this.location.getLongitude()), null, null);  
smsManager.sendTextMessage(string2, null, "Approximate address of emergency location:\n" + AlertActivity.this.Address, null, null);  
}  
}  
}  
});  
this.Btnearth.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
if (!AlertActivity.this.sharedPreferences.getString("mobile", "").equals((Object)"")) {  
for (String string2 : AlertActivity.this.sharedPreferences.getString("mobile","").split(",")) {  
if (string2.equals((Object)"")) continue;  
SmsManager smsManager = SmsManager.getDefault();  
smsManager.sendTextMessage(string2, null, "Emergency Situation - Need Help!!! Emergency due to Hospital. more details are in subsequent messages.", null, null);  
smsManager.sendTextMessage(string2, null, AlertActivity.this.sharedPreferences.getString("name", "") + "Approximate link for map to reach emergency site:\nhttp://maps.google.com/maps?q=" + String.valueOf((double)AlertActivity.this.location.getLatitude()) + "," + String.valueOf((double)AlertActivity.this.location.getLongitude()), null, null);  
smsManager.sendTextMessage(string2, null, "Approximate address of emergency location:\n" + AlertActivity.this.Address, null, null);  
}  
}  
}  
});  
this.Btnsunami.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
if (!AlertActivity.this.sharedPreferences.getString("mobile", "").equals((Object)"")) {  
for (String string2 : AlertActivity.this.sharedPreferences.getString("mobile", "").split(",")) {  
if (string2.equals((Object)"")) continue;  
SmsManager smsManager = SmsManager.getDefault();  
smsManager.sendTextMessage(string2, null, "Emergency Situation - Need Help!!! Emergency due to TSunami. more details are in subsequent messages.", null, null);  
smsManager.sendTextMessage(string2, null, AlertActivity.this.sharedPreferences.getString("name", "") + "Approximate link for map to reach emergency site:\nhttp://maps.google.com/maps?q=" + String.valueOf((double)AlertActivity.this.location.getLatitude()) + "," + String.valueOf((double)AlertActivity.this.location.getLongitude()), null, null);  
smsManager.sendTextMessage(string2, null, "Approximate address of emergency location:\n" + AlertActivity.this.Address, null, null);  
}  
}  
}  
});  
this.Btnsunami.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
}  
});  
this.Btnquit.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
AlertActivity.this.finish();  
}  
});  
}  
public void onLocationChanged(Location location) {  
int n;  
List list;  
this.location = location;  
Geocoder geocoder = new Geocoder((Context)this, Locale.getDefault());  
try {  
list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);  
this.Address = "";  
n = 0;  
}  
catch (IOException iOException) {  
iOException.printStackTrace();  
return;  
}  
do {  
if (n >= ((Address)list.get(0)).getMaxAddressLineIndex()) break;  
this.Address = this.Address + ((Address)list.get(0)).getAddressLine(n) + ",";  
++n;  
} while (true);  
return;  
}  
public void onProviderDisabled(String string2) {  
}  
public void onProviderEnabled(String string2) {  
}  
public void onStatusChanged(String string2, int n, Bundle bundle) {  
}  
} 