package android.com.githubsearch.mvp.contracts;

/**
 * Created by mohammed.salama on 10/25/2016.
 */

public interface BaseContract {

    interface View<T> {

        void hideProgress();

        void showProgress();

        void showFailureMessage(String message);

    }

}
