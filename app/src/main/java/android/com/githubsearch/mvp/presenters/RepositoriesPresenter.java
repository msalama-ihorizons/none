package android.com.githubsearch.mvp.presenters;

import android.com.githubsearch.models.Item;
import android.com.githubsearch.mvp.OnFinishedListener;
import android.com.githubsearch.mvp.contracts.RepositoriesContract;
import android.com.githubsearch.mvp.fetchers.RepositoriesFetcher;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by mohammed.salama on 1/28/2018.
 */

public class RepositoriesPresenter implements RepositoriesContract.UserInteraction {

    private RepositoriesContract.View view;
    private RepositoriesFetcher repositoriesFetcher;

    public RepositoriesPresenter(RepositoriesContract.View view, RepositoriesFetcher repositoriesFetcher) {
        this.view = view;
        this.repositoriesFetcher = repositoriesFetcher;
    }

    @Override
    public void searchRepositories(String keyword) {
        view.showProgress();

        repositoriesFetcher.searchRepositories(keyword, new OnFinishedListener<List<Item>>() {
            @Override
            public void onSuccess(@Nullable List<Item> data) {

                if (view == null) {
                    return;
                }

                if (data == null) {
                    return;
                }

                view.onRepositoriesLoaded(data);
            }

            @Override
            public void onFailure(String errorMessage, @Nullable List<Item> data) {
                if (view == null) {
                    return;
                }

                view.showFailureMessage(errorMessage);
            }

            @Override
            public void onComplete() {

                if (view == null) {
                    return;
                }

                view.hideProgress();
            }
        });
    }
}
