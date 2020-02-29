package com.app.sb.sbservices;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFcmTextMessagingService extends FirebaseMessagingService {

    private static final String TAG = MyFcmTextMessagingService.class.getSimpleName();

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "From: " + remoteMessage.getFrom());


        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Message data: " + remoteMessage.getData().toString());
        }
        if (remoteMessage.getNotification() != null) {
            Log.e(TAG, "Message data: " + remoteMessage.getData().toString());
            sendnotification(remoteMessage.getNotification().getBody());
        }
    }

    private void sendnotification(String body) {

        Intent intent = new Intent(this,MyFcmTextMessagingService.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri notificationsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Emoji Keyboard")
                .setDefaults(-1)
                .setContentText(body)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                .setSound(notificationsound)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }


//
}