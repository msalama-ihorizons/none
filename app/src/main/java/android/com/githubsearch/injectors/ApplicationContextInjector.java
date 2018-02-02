package android.com.githubsearch.injectors;

import android.app.Application;
import android.content.Context;

public class ApplicationContextInjector {

    private static Application context;



    public static void setApplicationContext(Application context) {
        ApplicationContextInjector.context = context;
    }

    public static Context getApplicationContext() {
        if (context == null) {
            throw new IllegalStateException("Trying to get the context, before setting it");
        }
        return context;
    }


}