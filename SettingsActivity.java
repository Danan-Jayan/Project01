import android.content.Context;  
import android.content.SharedPreferences;  
import android.os.Bundle;  
import android.preference.PreferenceManager;  
import android.support.v7.app.AppCompatActivity;  
import android.text.Editable;  
import android.view.View;  
import android.widget.Button;  
import android.widget.EditText;  
public class SettingsActivity  
extends AppCompatActivity {  
Button Btnsave;  
EditText EtPhone;  
EditText EtUser;  
SharedPreferences.Editor editor;  
SharedPreferences sharedPreferences;  
protected void onCreate(Bundle bundle) {  
SharedPreferences sharedPreferences;  
super.onCreate(bundle);  
this.setContentView(2131296284);  
this.EtUser = (EditText)this.findViewById(2131165249);  
this.EtPhone = (EditText)this.findViewById(2131165248);  
this.Btnsave = (Button)this.findViewById(2131165217);  
this.sharedPreferences = sharedPreferences = PreferenceManager.getDefaultSharedPreferences((Context)this.getApplicationContext());  
try {  
this.EtUser.setText((CharSequence)sharedPreferences.getString("name", ""));            
this.EtPhone.setText((CharSequence)this.sharedPreferences.getString("mobile",""));  
}        
 catch (Exception exception) {  
// empty catch block  
}  
this.editor = this.sharedPreferences.edit();  
this.Btnsave.setOnClickListener(new View.OnClickListener(){  
public void onClick(View view) {  
SettingsActivity.this.editor.putString("name",SettingsActivity.this.EtUser.getText().toString());  
SettingsActivity.this.editor.putString("mobile",SettingsActivity.this.EtPhone.getText().toString());  
SettingsActivity.this.editor.commit();  
SettingsActivity.this.finish();  
}  
});  
}  
}