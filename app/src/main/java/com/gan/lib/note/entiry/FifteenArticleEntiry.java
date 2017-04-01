package com.gan.lib.note.entiry;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 十五言 文章
 * Created by tangjun on 2017/3/31.
 */

public class FifteenArticleEntiry implements Parcelable {

    private String title;
    private String title_sub;
    private String img;

    /**
     *
     *  css代码块
     */
    private String article;

    public FifteenArticleEntiry(String title, String title_sub, String img, String article) {
        this.title = title;
        this.title_sub = title_sub;
        this.img = img;
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle_sub() {
        return title_sub;
    }

    public void setTitle_sub(String title_sub) {
        this.title_sub = title_sub;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "FifteenArticleEntiry{" +
                "title='" + title + '\'' +
                ", title_sub='" + title_sub + '\'' +
                ", img='" + img + '\'' +
                ", article='" + article + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.title_sub);
        dest.writeString(this.img);
        dest.writeString(this.article);
    }

    protected FifteenArticleEntiry(Parcel in) {
        this.title = in.readString();
        this.title_sub = in.readString();
        this.img = in.readString();
        this.article = in.readString();
    }

    public static final Parcelable.Creator<FifteenArticleEntiry> CREATOR = new Parcelable.Creator<FifteenArticleEntiry>() {
        @Override
        public FifteenArticleEntiry createFromParcel(Parcel source) {
            return new FifteenArticleEntiry(source);
        }

        @Override
        public FifteenArticleEntiry[] newArray(int size) {
            return new FifteenArticleEntiry[size];
        }
    };
}
