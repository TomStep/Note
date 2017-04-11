package com.gan.lib.note.entiry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Created by tangjun on 2017/4/11.
 */

public class EtherItemEntiry implements Parcelable {

    private String url;
    private String title;
    private String img;
    private String tag_url;
    private String tag_name;
    private String time;

    public EtherItemEntiry(String url, String title, String img, String tag_url, String tag_name, String time) {
        this.url = url;
        this.title = title;
        this.img = img;
        this.tag_url = tag_url;
        this.tag_name = tag_name;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTag_url() {
        return tag_url;
    }

    public void setTag_url(String tag_url) {
        this.tag_url = tag_url;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EtherItemEntiry{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", tag_url='" + tag_url + '\'' +
                ", tag_name='" + tag_name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.img);
        dest.writeString(this.tag_url);
        dest.writeString(this.tag_name);
        dest.writeString(this.time);
    }

    public EtherItemEntiry() {
    }

    protected EtherItemEntiry(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
        this.img = in.readString();
        this.tag_url = in.readString();
        this.tag_name = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<EtherItemEntiry> CREATOR = new Parcelable.Creator<EtherItemEntiry>() {
        @Override
        public EtherItemEntiry createFromParcel(Parcel source) {
            return new EtherItemEntiry(source);
        }

        @Override
        public EtherItemEntiry[] newArray(int size) {
            return new EtherItemEntiry[size];
        }
    };
}
