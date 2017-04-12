package com.gan.lib.note.entiry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tangjun on
 * 2017/4/12.
 */

public class ToonsHotEntiry implements Parcelable {

    private String refer = "http://www.webtoons.com/zh-hans/top?rankingGenre=ALL&target=MALE20";
    private String url;
    private String img;
    private String tag;
    private String title;
    private String author;

    public ToonsHotEntiry(String url, String img, String tag, String title, String author) {
        this.url = url;
        this.img = img;
        this.tag = tag;
        this.title = title;
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getRefer() {
        return refer;
    }

    public void setRefer(String refer) {
        this.refer = refer;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ToonsHotEntiry{" +
                "url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }


    public ToonsHotEntiry() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.img);
        dest.writeString(this.tag);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.refer);
    }

    private ToonsHotEntiry(Parcel in) {
        this.url = in.readString();
        this.img = in.readString();
        this.tag = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.refer = in.readString();
    }

    public static final Creator<ToonsHotEntiry> CREATOR = new Creator<ToonsHotEntiry>() {
        @Override
        public ToonsHotEntiry createFromParcel(Parcel source) {
            return new ToonsHotEntiry(source);
        }

        @Override
        public ToonsHotEntiry[] newArray(int size) {
            return new ToonsHotEntiry[size];
        }
    };
}
