package comp380.group4.com.aslpocketdictionary;

import android.content.Context;
import android.app.Application;

/**
 * Created by andrewhoang on 12/5/16.
 */

public class MyApp extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}