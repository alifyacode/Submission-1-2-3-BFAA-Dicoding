package com.alifyacode.aplikasigithubuser.ProviderReceiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.alifyacode.aplikasigithubuser.ActivityFile.UGthbMainActivity;
import com.alifyacode.aplikasigithubuser.R;

public class DeUGthbReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context cntxt, Intent intnt) {
        Log.d("buttonSwitch", "buttonSwitch");

        NotificationManager notificationManager = (NotificationManager) cntxt.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(cntxt, "102")
                .setContentIntent(PendingIntent.getActivity(cntxt, 102, new Intent(cntxt, UGthbMainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT))
                .setSmallIcon(R.drawable.logogithub)
                .setLargeIcon(BitmapFactory.decodeResource(cntxt.getResources(), R.drawable.logogithub2))
                .setContentTitle("Github User")
                .setContentText("Ayo buka aplikasi githubmu!")
                .setSubText("Github User")
                .setAutoCancel(true);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId("102");

            if (notificationManager != null) {
                notificationManager.createNotificationChannel(new NotificationChannel("102", "AlarmManager Channel", NotificationManager.IMPORTANCE_DEFAULT));
            }
        }
        if (notificationManager != null) {
            notificationManager.notify(2,builder.build());
        }
    }
}
