package com.alifyacode.aplikasigithubuser.Model;

import com.google.gson.annotations.SerializedName;

public class UserDetail {
    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("login")
    private String login;

    @SerializedName("type")
    private String type;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("organizations_url")
    private String organizationsUrl;

    @SerializedName("hireable")
    private Object hireable;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("public_gists")
    private int publicGists;

    @SerializedName("url")
    private String url;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("followers")
    private int followers;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("following")
    private int following;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("node_id")
    private String nodeId;

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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(int publicRepos) {
        this.publicRepos = publicRepos;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public int getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(int publicGists) {
        this.publicGists = publicGists;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
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

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}