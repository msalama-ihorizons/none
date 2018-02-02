package android.com.githubsearch.adapters;

import android.com.githubsearch.R;
import android.com.githubsearch.models.Item;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.com.githubsearch.injectors.ApplicationContextInjector.getApplicationContext;
import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by mohammed.salama on 1/28/2018.
 */

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.RepositoryViewHolder> {

    private List<Item> repositories;

    public RepositoriesAdapter(List<Item> repositories) {
        setList(repositories);
    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View offerView = inflater.inflate(R.layout.repository_item, parent, false);
        RepositoryViewHolder holder = new RepositoryViewHolder(offerView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder offerViewHolder, int position) {
        Item repository = repositories.get(position);

        offerViewHolder.repoOwnerName.setText(repository.getFullName());

        offerViewHolder.repoDesc.setText(repository.getDescription());

        offerViewHolder.forkCount.setText(
                String.valueOf(repository.getForksCount())
        );

        String offerThumbnailUrl = repository.getOwner().getAvatarUrl();

        Picasso.with(getApplicationContext()).load(offerThumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background)
                .into(offerViewHolder.repoOwnerAvatar
                );
    }

    public void replaceData(List<Item> repositories) {
        setList(repositories);
        notifyDataSetChanged();
    }

    private void setList(@NonNull List<Item> repositories) {
        this.repositories = checkNotNull(repositories);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    public static class RepositoryViewHolder extends RecyclerView.ViewHolder {

        public TextView repoOwnerName;
        public TextView repoDesc;
        public TextView forkCount;
        public CircleImageView repoOwnerAvatar;

        public RepositoryViewHolder(View itemView) {
            super(itemView);
            repoOwnerName = itemView.findViewById(R.id.ownerName);
            repoDesc =  itemView.findViewById(R.id.repoDesc);
            forkCount = itemView.findViewById(R.id.forkCount);
            repoOwnerAvatar = itemView.findViewById(R.id.ownerAvatar);
        }

    }
}
