package com.codingblocks.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


//Benefits of Parcelable and Serializable are that you can send objects across intents
public class DetailUser implements Parcelable{

    private String name, company, blog, bio;

    @SerializedName("avatar_url")
    private String avatarUrl;

    protected DetailUser(Parcel in) {
        name = in.readString();
        company = in.readString();
        blog = in.readString();
        bio = in.readString();
        avatarUrl = in.readString();
    }

    public static final Creator<DetailUser> CREATOR = new Creator<DetailUser>() {
        @Override
        public DetailUser createFromParcel(Parcel in) {
            return new DetailUser(in);
        }

        @Override
        public DetailUser[] newArray(int size) {
            return new DetailUser[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getBlog() {
        return blog;
    }

    public String getBio() {
        return bio;
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
        parcel.writeString(name);
        parcel.writeString(company);
        parcel.writeString(blog);
        parcel.writeString(bio);
        parcel.writeString(avatarUrl);
    }
}
