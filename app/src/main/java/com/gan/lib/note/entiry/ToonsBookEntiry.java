package com.gan.lib.note.entiry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Created by tangjun on 2017/4/19.
 */

public class ToonsBookEntiry implements Parcelable {

    private String img;
    private String title;
    private String date;
    private String like;
    private String tx;
    private String url;

    public ToonsBookEntiry(String img, String title, String date, String like, String tx, String url) {
        this.img = img;
        this.title = title;
        this.date = date;
        this.like = like;
        this.tx = tx;
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getTx() {
        return tx;
    }

    public void setTx(String tx) {
        this.tx = tx;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ToonsBookEntiry{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", like='" + like + '\'' +
                ", tx='" + tx + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.img);
        dest.writeString(this.title);
        dest.writeString(this.date);
        dest.writeString(this.like);
        dest.writeString(this.tx);
        dest.writeString(this.url);
    }

    protected ToonsBookEntiry(Parcel in) {
        this.img = in.readString();
        this.title = in.readString();
        this.date = in.readString();
        this.like = in.readString();
        this.tx = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<ToonsBookEntiry> CREATOR = new Parcelable.Creator<ToonsBookEntiry>() {
        @Override
        public ToonsBookEntiry createFromParcel(Parcel source) {
            return new ToonsBookEntiry(source);
        }

        @Override
        public ToonsBookEntiry[] newArray(int size) {
            return new ToonsBookEntiry[size];
        }
    };
}
