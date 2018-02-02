package android.com.githubsearch.ui.fragments;

import android.app.Fragment;
import android.com.githubsearch.R;
import android.com.githubsearch.adapters.RepositoriesAdapter;
import android.com.githubsearch.models.Item;
import android.com.githubsearch.mvp.contracts.RepositoriesContract;
import android.com.githubsearch.mvp.fetchers.RepositoriesFetcher;
import android.com.githubsearch.mvp.presenters.RepositoriesPresenter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammed.salama on 1/28/2018.
 */

public class RepositoriesListFragment extends Fragment implements RepositoriesContract.View {

    private static final String TAG = "GithubListFragment";

    private RepositoriesAdapter adapter;
    private RepositoriesPresenter presenter;

    private LottieAnimationView progressLoading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RepositoriesAdapter(new ArrayList<Item>());
        presenter = new RepositoriesPresenter(this, RepositoriesFetcher.newInstance());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repositories_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressLoading = view.findViewById(R.id.progressLoading);

        RecyclerView recyclerViewOffers = view.findViewById(R.id.repositoriesList);

        //init recycle view
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewOffers.setLayoutManager(layoutManager);
        recyclerViewOffers.setHasFixedSize(true);
        recyclerViewOffers.setAdapter(adapter);
       /* recyclerViewOffers.addItemDecoration(new SimpleDividerItemDecoration(
                getActivity()
        ));*/

    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.searchRepositories("hello");
    }

    @Override
    public void hideProgress() {
        progressLoading.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showFailureMessage(String message) {

    }

    @Override
    public void onRepositoriesLoaded(List<Item> repositories) {
        Log.d(TAG, "onRepositoriesLoaded: " + repositories.size());
        adapter.replaceData(repositories);
    }
}
