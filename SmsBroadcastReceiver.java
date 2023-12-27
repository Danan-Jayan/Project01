import android.app.Notification;  
import android.app.NotificationManager;  
import android.app.PendingIntent;  
import android.content.BroadcastReceiver;  
import android.content.Context;  
import android.content.Intent;  
import android.media.RingtoneManager;  
import android.net.Uri;  
import android.os.Bundle;  
import android.telephony.SmsMessage;  
import com.example.jaga.disasterintimater.MapsActivity;  
public class SmsBroadcastReceiver  
extends BroadcastReceiver {  
public static final String SMS_BUNDLE = "pdus";  
public void onReceive(Context context, Intent intent) {  
String string2 = "";  
String string3 = "";  
String string4 = "";  
String string5 = "";  
Bundle bundle = intent.getExtras();  
if (bundle != null) {  
Object[] arrobject = (Object[])bundle.get(SMS_BUNDLE);  
for (int i = 0; i < arrobject.length; ++i) {  
String string6 = SmsMessage.createFromPdu((byte[])((byte[])arrobject[i])).getMessageBody().toString();  
string2 = string6.split(":")[0];  
string5 = string6.split(":")[1];  
string3 = string6.split(":")[2];  
string4 = string6.split(":")[3];  
}  
if (string5.toUpperCase().contains((CharSequence)"FIRE")) {  
this.showdialog(context, "FIRE ALARAM DETECTED", "FIRE ACCIDENT 
MESSAGE FROM " + string2, string3, string4, "Fire accident");  
} else if (string5.toUpperCase().contains((CharSequence)"EARTH")) {  
this.showdialog(context, "EARTHQUAKE DETECTED", "EARTHQUAKE 
MESSAGE FROM " + string2, string3, string4, "Earthquake");  
}  
if (string5.toUpperCase().contains((CharSequence)"ACCIDENT")) {  
this.showdialog(context, "VEHICLE ACCIDENT DETECTED", "VEHICLE 
ACCIDENT MESSAGE FROM " + string2, string3, string4, "Vehicle accident");  
}  
}  
}  
void showdialog(Context context, String string2, String string3, String string4, 
String string5, String string6) {  
try {  
Intent intent = new Intent(context, MapsActivity.class);  
intent.putExtra("lat", string4);  
intent.putExtra("lon", string5);  
intent.putExtra("type", string6);  
PendingIntent pendingIntent = PendingIntent.getActivity((Context)context, (int)((int)System.currentTimeMillis()), (Intent)intent, (int)0);  
Notification notification = new Notification.Builder(context).setContentTitle((CharSequence)string2).setContentText((CharSequence)string3).setContentIntent(pendingIntent).setSound(RingtoneManager.getDefaultUri((int)2)).setSmallIcon(2131361792).setAutoCancel(true).build();  
((NotificationManager)context.getSystemService("notification")).notify(0,notification);  
return;
}  
catch (Exception exception) {  
return;  
}  
}  
}