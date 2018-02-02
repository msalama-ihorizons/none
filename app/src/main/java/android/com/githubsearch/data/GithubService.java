package android.com.githubsearch.data;

import android.com.githubsearch.Utils.Constants;
import android.support.annotation.Nullable;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mohammed.salama on 1/27/2018.
 */

public class GithubService {

    private GithubRest gitHubRest;

    public GithubService() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        gitHubRest = retrofit.create(GithubRest.class);
    }

    @Nullable
    public GithubRest getService() {
        return gitHubRest;
    }
}
