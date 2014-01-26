package com.example.firstapp;
import android.app.Application;

public class GlobalState extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "9edkdpCebtCAdrB7IasRFiHXcuu09ktlz3hm7OWw",
                               "Ot4spJ3FHyIlYFFqnkBMPnizy2ZJ7Q0XOHmBx052");
        PushService.setDefaultPushCallback(this, NotificationHandler.class);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}