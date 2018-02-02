
package android.com.githubsearch.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class License {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("spdx_id")
    @Expose
    private String spdxId;
    @SerializedName("url")
    @Expose
    private String url;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public License withKey(String key) {
        this.key = key;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public License withName(String name) {
        this.name = name;
        return this;
    }

    public String getSpdxId() {
        return spdxId;
    }

    public void setSpdxId(String spdxId) {
        this.spdxId = spdxId;
    }

    public License withSpdxId(String spdxId) {
        this.spdxId = spdxId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public License withUrl(String url) {
        this.url = url;
        return this;
    }

}
