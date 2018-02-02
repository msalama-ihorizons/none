
package android.com.githubsearch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RepositoriesSearchResponse {

    @SerializedName("total_count")
    @Expose
    private Integer totalCount;
    @SerializedName("incomplete_results")
    @Expose
    private Boolean incompleteResults;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public RepositoriesSearchResponse withTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public RepositoriesSearchResponse withIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
        return this;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public RepositoriesSearchResponse withItems(List<Item> items) {
        this.items = items;
        return this;
    }

}
