import android.content.Context;  
import android.content.Intent;  
import android.os.Bundle;  
import android.support.v7.app.AppCompatActivity;  
import android.view.View;  
import android.widget.Button;  
import com.example.jaga.disasterintimater.AlertActivity;  
import com.example.jaga.disasterintimater.MapsActivity;  
import com.example.jaga.disasterintimater.SettingsActivity;  
public class HomeActivity  
extends AppCompatActivity {  
Button BtnAlert;  
Button Btncurloc;  
Button Btnquit;  
Button Btnsettings;  
protected void onCreate(Bundle bundle) {  
super.onCreate(bundle);  
this.setContentView(2131296282);  
this.Btncurloc = (Button)this.findViewById(2131165213);  
this.BtnAlert = (Button)this.findViewById(2131165212);  
this.Btnquit = (Button)this.findViewById(2131165216);  
this.Btnsettings = (Button)this.findViewById(2131165218);  
this.Btncurloc.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
Intent intent = new Intent((Context)HomeActivity.this, MapsActivity.class);  
HomeActivity.this.startActivity(intent);  
}  
});  
this.BtnAlert.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
Intent intent = new Intent((Context)HomeActivity.this, AlertActivity.class);  
HomeActivity.this.startActivity(intent);  
}  
});  
this.Btnsettings.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
Intent intent = new Intent((Context)HomeActivity.this, SettingsActivity.class);  
HomeActivity.this.startActivity(intent);  
}  
});  
this.Btnquit.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
HomeActivity.this.finish();  
}  
});  
}  
}  