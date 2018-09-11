package com.example.kapil.movie_app.recyclerView.movies;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.VideoView;

import com.google.gson.annotations.SerializedName;

public class Movies implements Parcelable {



    @SerializedName("title")
    public String Title;

    @SerializedName("year")
    public Integer Year;

    @SerializedName("genre")
    public String Genre;

    @SerializedName("director")
    public String Director;

    @SerializedName("rating")
    public Double Rating;

    @SerializedName("certification")
    public String Certification;

    @SerializedName("duration")
    public String Duration;

    @SerializedName("summary")
    public String Summary;

    @SerializedName("reviews")
    public Integer Reviews;

    @SerializedName("thumbnailImage")
    public String ThumbnailImage;

    @SerializedName("bannerImage")
    public String BannerImage;

    @SerializedName("videoLink")
    public String VideoLink;

    public Movies(String bannerImage, String thumbnailImage, String title, Integer year, String genre, String director, Double rating, String certification, String duration, String summary, Integer reviews, String videoLink) {
        BannerImage = bannerImage;
        ThumbnailImage = thumbnailImage;
        Title = title;
        Year = year;
        Genre = genre;
        Director = director;
        Rating = rating;
        Certification = certification;
        Duration = duration;
        Summary = summary;
        Reviews = reviews;
        VideoLink = videoLink;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Title);
        dest.writeValue(this.Year);
        dest.writeString(this.Genre);
        dest.writeString(this.Director);
        dest.writeValue(this.Rating);
        dest.writeString(this.Certification);
        dest.writeString(this.Duration);
        dest.writeString(this.Summary);
        dest.writeValue(this.Reviews);
        dest.writeString(this.ThumbnailImage);
        dest.writeString(this.BannerImage);
        dest.writeString(this.VideoLink);
    }

    protected Movies(Parcel in) {
        this.Title = in.readString();
        this.Year = (Integer) in.readValue(Integer.class.getClassLoader());
        this.Genre = in.readString();
        this.Director = in.readString();
        this.Rating = (Double) in.readValue(Double.class.getClassLoader());
        this.Certification = in.readString();
        this.Duration = in.readString();
        this.Summary = in.readString();
        this.Reviews = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ThumbnailImage = in.readString();
        this.BannerImage = in.readString();
        this.VideoLink = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
