package android.com.githubsearch;

import android.app.Application;

import static android.com.githubsearch.injectors.ApplicationContextInjector.setApplicationContext;


/**
 * Created by mohammed.salama on 11/6/2017.
 */

public class GithubSearchApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setApplicationContext(this);

    }
}
