package com.tripaction_interview_assignment;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsFeedModel implements Parcelable {
            private String status;

    private String copyright;
            private String section;
            private String last_updated;
            private float num_results;
            private String title;
            private String url;
            private String imageUrl;


            public NewsFeedModel(JSONObject jsonObject){
                try {
                    this.status = jsonObject.getString("status");
                    this.copyright = jsonObject.getString("copyright");
                    this.section = jsonObject.getString("section");
                    this.last_updated= jsonObject.getString("last_updated");
                    this.num_results = jsonObject.getInt("num_results");
                    this.imageUrl = jsonObject.getJSONObject("results").getJSONArray("multimedia").getJSONObject(0).getString("url");
                    this.title = jsonObject.getJSONObject("results").getString("title");
                    this.url = jsonObject.getJSONObject("results").getString("url");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }


            // Getter Methods

    public String getStatus() {
                return status;
            }

            public String getCopyright() {
                return copyright;
            }

            public String getSection() {
                return section;
            }

            public String getLast_updated() {
                return last_updated;
            }

            public float getNum_results() {
                return num_results;
            }

            // Setter Methods

            public void setStatus(String status) {
                this.status = status;
            }

            public void setCopyright(String copyright) {
                this.copyright = copyright;
            }

            public void setSection(String section) {
                this.section = section;
            }

            public void setLast_updated(String last_updated) {
                this.last_updated = last_updated;
            }

            public void setNum_results(float num_results) {
                this.num_results = num_results;
            }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ArrayList<Results> parseJSON (JSONArray jsonArray){
        ArrayList<Results> results = new ArrayList<Results>();
        for (int i=0 ; i<jsonArray.length();i++){
            try{
                results.add(new Results(jsonArray.getJSONObject(i)));
            } catch(JSONException e){
                e.printStackTrace();
            }
        }
        return results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.copyright);
        dest.writeString(this.section);
        dest.writeString(this.last_updated);
        dest.writeFloat(this.num_results);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeString(this.imageUrl);
    }

    protected NewsFeedModel(Parcel in) {
        this.status = in.readString();
        this.copyright = in.readString();
        this.section = in.readString();
        this.last_updated = in.readString();
        this.num_results = in.readFloat();
        this.title = in.readString();
        this.url = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Creator<NewsFeedModel> CREATOR = new Creator<NewsFeedModel>() {
        @Override
        public NewsFeedModel createFromParcel(Parcel source) {
            return new NewsFeedModel(source);
        }

        @Override
        public NewsFeedModel[] newArray(int size) {
            return new NewsFeedModel[size];
        }
    };
}