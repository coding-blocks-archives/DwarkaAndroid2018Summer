package com.codingblocks.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Parcelable{

    private String login;

    //GSON uses this SerializedName while parsing the JSON
    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    private String url;

    protected User(Parcel in) {
        login = in.readString();
        avatarUrl = in.readString();
        reposUrl = in.readString();
        url = in.readString();
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

    public String getReposUrl() {
        return reposUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(login);
        parcel.writeString(avatarUrl);
        parcel.writeString(reposUrl);
        parcel.writeString(url);
    }
}
