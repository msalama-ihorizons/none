package android.com.githubsearch.mvp.fetchers;

import android.com.githubsearch.data.GithubService;
import android.com.githubsearch.models.RepositoriesSearchResponse;
import android.com.githubsearch.models.Item;
import android.com.githubsearch.mvp.OnFinishedListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mohammed.salama on 1/27/2018.
 */

public class RepositoriesFetcher {

    public static RepositoriesFetcher newInstance() {
        return new RepositoriesFetcher();
    }

    public void searchRepositories(String keyword, final OnFinishedListener<List<Item>> listener) {

        Call<RepositoriesSearchResponse> call = new GithubService().getService().searchRepos(keyword);

        call.enqueue(new Callback<RepositoriesSearchResponse>() {
            @Override
            public void onResponse(Call<RepositoriesSearchResponse> call, Response<RepositoriesSearchResponse> response) {

                listener.onComplete();

                if (response.isSuccessful()) {
                    listener.onSuccess(response.body().getItems());
                } else {
                    listener.onFailure(response.message(), null);
                }
            }

            @Override
            public void onFailure(Call<RepositoriesSearchResponse> call, Throwable t) {

                listener.onComplete();

                listener.onFailure(t.getMessage(), null);
            }
        });
    }
}
