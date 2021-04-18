package com.alifyacode.aplikasigithubuser.ActivityFile;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.alifyacode.aplikasigithubuser.ProviderReceiver.DeUGthbReceiver;
import com.alifyacode.aplikasigithubuser.R;

import java.util.Calendar;

public class UGthbSettingActivity extends AppCompatActivity {
    private Switch swtchbttn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugthb_setting);
        swtchbttn = findViewById(R.id.swtchbtn);
        if (PreferenceManager.getDefaultSharedPreferences(this).getInt("user_notification", 0) == 1){
            swtchbttn.setChecked(true);
        }else {
            swtchbttn.setChecked(false);
        }
        swtchbttn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
            editor.apply();
            if (isChecked){
                setReminder(getApplicationContext());
                editor.putInt("user_notification",1);
                Toast.makeText(UGthbSettingActivity.this, "Notification Active", Toast.LENGTH_SHORT).show();
            }else {
                setReminderOff(getApplicationContext());
                editor.putInt("user_notification",0);
                Toast.makeText(UGthbSettingActivity.this, "Notification Not Active", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setReminder(Context applicationContext) {
        Intent intnt = new Intent(applicationContext, com.alifyacode.aplikasigithubuser.ProviderReceiver.DeUGthbReceiver.class);
        Calendar.getInstance().set(Calendar.HOUR_OF_DAY,9);
        Calendar.getInstance().set(Calendar.MINUTE,0);
        Calendar.getInstance().set(Calendar.SECOND,0);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);
        Log.d("switchbutton","switchbutton");
        if (alarmManager != null){
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,Calendar.getInstance().getTimeInMillis(),AlarmManager.INTERVAL_DAY,PendingIntent.getBroadcast(applicationContext, 102, intnt, PendingIntent.FLAG_UPDATE_CURRENT));
        }
    }
    private void setReminderOff(Context applicationContext) {
        Log.d("switchbutton","switchbutton");
        Intent intent = new Intent(UGthbSettingActivity.this, DeUGthbReceiver.class);
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null){
            alarmManager.cancel(PendingIntent.getBroadcast(applicationContext, 102, intent, PendingIntent.FLAG_UPDATE_CURRENT));
        }
    }
}
