package android.com.githubsearch.mvp;

import android.support.annotation.Nullable;

/**
 * Created by mohammed.salama on 9/20/2016.
 */
public interface OnFinishedListener<T> {
    void onSuccess(@Nullable T data);

    void onFailure(String errorMessage, @Nullable T data);

    void onComplete();

}
