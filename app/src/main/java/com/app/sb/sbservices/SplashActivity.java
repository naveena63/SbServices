package com.app.sb.sbservices;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

import com.app.sb.sbservices.Utils.AppConstants;
import com.app.sb.sbservices.Utils.GlobalVariable;
import com.app.sb.sbservices.Utils.PrefManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Arrays;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    private static final String CHANNEL_ID = "4565";
    String unique_id;
    @RequiresApi(api = Build.VERSION_CODES.O)
    AppCompatImageView ivImage;
    PrefManager prefManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activity);
        prefManager=new PrefManager(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channcel_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
            FirebaseMessaging.getInstance().subscribeToTopic("weather")
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = getString(R.string.msg_subscribed);
                            if (!task.isSuccessful()) {
                                msg = getString(R.string.msg_subscribe_failed);
                            }
                            Log.d("app", msg);
                            // Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        FirebaseMessaging.getInstance().subscribeToTopic("websitetool")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Success";
                       // Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        //this code will be written in splash screen
        unique_id = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        Log.d("deviceId", "deviceid" + unique_id);
        prefManager.storeValue(AppConstants.DEVICE_ID, unique_id);
        prefManager.setDevceid(unique_id);


        //this  token will changes for Every Device this  token  will give to server
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String deviceToken = instanceIdResult.getToken();
                Log.d("dsdtoken", "devicesToken" + deviceToken);
                prefManager.storeValue(AppConstants.REFRESH_TOKEN, deviceToken);
                prefManager.setRegistrationtoken(deviceToken);
                Log.d("token", "token" + prefManager.getRegistrationtoken());
            }
            // or directly send it to server
        });
        getSupportActionBar().hide();
        ivImage = findViewById(R.id.logo_one);
        prefManager = new PrefManager(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        GlobalVariable.deviceWidth = displayMetrics.widthPixels;
        GlobalVariable.deviceHeight = displayMetrics.heightPixels;

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!prefManager.getBoolean(AppConstants.APP_USER_LOGIN)) {
                    Intent intent = new Intent(SplashActivity.this, GuestLoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    finish();
                } else {
                    Intent intent = new Intent(SplashActivity.this, BottomNavActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                    finish();
                }
            }

        }, 3000);
        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = getString(R.string.msg_subscribed);
                        if (!task.isSuccessful()) {
                            msg = getString(R.string.msg_subscribe_failed);
                        }
                        Log.d("sb", msg);
                       // Toast.makeText(SplashActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


// These registration tokens come from the client FCM SDKs.
        List<String> registrationTokens = Arrays.asList(
                "YOUR_REGISTRATION_TOKEN_1",
                // ...
                "YOUR_REGISTRATION_TOKEN_n"
        );

    }

}



