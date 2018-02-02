package android.com.githubsearch.mvp.contracts;


import android.com.githubsearch.models.Item;

import java.util.List;

/**
 * Created by alaa.salah on 8/9/2016.
 */

public interface RepositoriesContract {

    interface UserInteraction {

      void searchRepositories(String keyword);

    }

    interface View extends BaseContract.View {

        void onRepositoriesLoaded(List<Item> repositories);

    }
}
