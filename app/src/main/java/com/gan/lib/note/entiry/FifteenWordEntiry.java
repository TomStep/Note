package com.gan.lib.note.entiry;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.gan.lib.note.BR;

/**
 * FifteenWord Entiry
 * Created by tangjun on 2017/3/30.
 */

public class FifteenWordEntiry extends BaseObservable implements Parcelable {

    private String imgUrl;
    private String title;
    private String title_sub;

    private String userName;
    private String userImg;

    private String url;

    public FifteenWordEntiry(String imgUrl, String title, String title_sub, String userName, String userImg,String url) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.title_sub = title_sub;
        this.userName = userName;
        this.userImg = userImg;
        this.url = url;
    }

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        notifyPropertyChanged(BR.imgUrl);

    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getTitle_sub() {
        return title_sub;
    }

    public void setTitle_sub(String title_sub) {
        this.title_sub = title_sub;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
        notifyPropertyChanged(BR.userImg);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Override
    public String toString() {
        return "FifteenWordEntiry{" +
                "imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", title_sub='" + title_sub + '\'' +
                ", userName='" + userName + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imgUrl);
        dest.writeString(this.title);
        dest.writeString(this.title_sub);
        dest.writeString(this.userName);
        dest.writeString(this.userImg);
        dest.writeString(this.url);
    }

    protected FifteenWordEntiry(Parcel in) {
        this.imgUrl = in.readString();
        this.title = in.readString();
        this.title_sub = in.readString();
        this.userName = in.readString();
        this.userImg = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<FifteenWordEntiry> CREATOR = new Parcelable.Creator<FifteenWordEntiry>() {
        @Override
        public FifteenWordEntiry createFromParcel(Parcel source) {
            return new FifteenWordEntiry(source);
        }

        @Override
        public FifteenWordEntiry[] newArray(int size) {
            return new FifteenWordEntiry[size];
        }
    };


}
