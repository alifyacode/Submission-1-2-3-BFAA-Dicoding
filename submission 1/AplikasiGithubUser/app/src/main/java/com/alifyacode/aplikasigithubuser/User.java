package com.alifyacode.aplikasigithubuser;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private int photo;
    private String name;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected User(Parcel in) {
        photo = in.readInt();
        name = in.readString();
        username = in.readString();
    }

    public User() {
        //
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(name);
        dest.writeString(username);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
