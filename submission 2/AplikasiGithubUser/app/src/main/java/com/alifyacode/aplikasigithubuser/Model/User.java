package com.alifyacode.aplikasigithubuser.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User implements Parcelable {

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("login")
    private String login;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("id")
    private int id;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("organizations_url")
    private String organizationsUrl;

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public static Creator<User> getCREATOR() {
        return CREATOR;
    }

    protected User(Parcel in) {
        gistsUrl = in.readString();
        reposUrl = in.readString();
        followingUrl = in.readString();
        starredUrl = in.readString();
        login = in.readString();
        followersUrl = in.readString();
        type = in.readString();
        url = in.readString();
        subscriptionsUrl = in.readString();
        receivedEventsUrl = in.readString();
        avatarUrl = in.readString();
        eventsUrl = in.readString();
        htmlUrl = in.readString();
        siteAdmin = in.readByte() != 0;
        id = in.readInt();
        gravatarId = in.readString();
        nodeId = in.readString();
        organizationsUrl = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gistsUrl);
        dest.writeString(reposUrl);
        dest.writeString(followingUrl);
        dest.writeString(starredUrl);
        dest.writeString(login);
        dest.writeString(followersUrl);
        dest.writeString(type);
        dest.writeString(url);
        dest.writeString(subscriptionsUrl);
        dest.writeString(receivedEventsUrl);
        dest.writeString(avatarUrl);
        dest.writeString(eventsUrl);
        dest.writeString(htmlUrl);
        dest.writeByte((byte) (siteAdmin ? 1 : 0));
        dest.writeInt(id);
        dest.writeString(gravatarId);
        dest.writeString(nodeId);
        dest.writeString(organizationsUrl);
    }
}