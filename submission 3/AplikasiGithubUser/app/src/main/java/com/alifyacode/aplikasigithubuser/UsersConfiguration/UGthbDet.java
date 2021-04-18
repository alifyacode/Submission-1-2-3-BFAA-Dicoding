package com.alifyacode.aplikasigithubuser.UsersConfiguration;

import com.google.gson.annotations.SerializedName;

public class UGthbDet {
    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;
    //
    @SerializedName("public_repos")
    private int publicRepos;
    //
    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("public_gists")
    private int publicGists;

    @SerializedName("url")
    private String url;

    @SerializedName("followers")
    private int followers;

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }


    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("following")
    private int following;

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
    @SerializedName("name")
    private String name;

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
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


    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

