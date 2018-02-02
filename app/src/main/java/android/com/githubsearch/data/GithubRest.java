package android.com.githubsearch.data;

import android.com.githubsearch.models.RepositoriesSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohammed.salama on 1/27/2018.
 */

public interface GithubRest {
    @GET("search/repositories")
    Call<RepositoriesSearchResponse> searchRepos(@Query("q") String keyword);
}
