package com.alifyacode.aplikasigithubuser.UsersConfiguration;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class UsrGthb implements Parcelable {
    @SerializedName("following_url")
    private String followingUrl;
    @SerializedName("followers_url")
    private String followersUrl;
    @SerializedName("starred_url")
    private String starredUrl;
    @SerializedName("login")
    private String login;
    @SerializedName("url")
    private String url;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("html_url")
    private String htmlUrl;
    @SerializedName("id")
    private int id;

    public UsrGthb() {

    }
    public String getLogin() {
        return login;
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
    public void setLogin(String login) {
        this.login = login;
    }
    public String getFollowersUrl() {
        return followersUrl;
    }
    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
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
    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public static Creator<UsrGthb> shwkrtr() {
        return CREATOR;
    }

    public UsrGthb(Parcel in) {
        followingUrl = in.readString();
        starredUrl = in.readString();
        login = in.readString();
        followersUrl = in.readString();
        url = in.readString();
        avatarUrl = in.readString();
        htmlUrl = in.readString();
        id = in.readInt();
    }

    public static final Creator<UsrGthb> CREATOR = new Creator<UsrGthb>() {
        @Override
        public UsrGthb createFromParcel(Parcel in) {
            return new UsrGthb(in);
        }

        @Override
        public UsrGthb[] newArray(int size) {
            return new UsrGthb[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dst, int flgs) {
        dst.writeString(followingUrl);
        dst.writeString(starredUrl);
        dst.writeString(login);
        dst.writeString(followersUrl);
        dst.writeString(url);
        dst.writeString(avatarUrl);
        dst.writeString(htmlUrl);
        dst.writeInt(id);
    }
}
