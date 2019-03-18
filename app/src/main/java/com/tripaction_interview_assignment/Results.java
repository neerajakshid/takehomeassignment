package com.tripaction_interview_assignment;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Results implements Parcelable {

    private String section;
    private String subsection;
    private String title;
    private String url;
    private String byline;
    private String item_type;
    private String updated_date;
    private String created_date;
    private String published_date;
    private String material_type_facet;
    private String kicker;
    private JSONArray multimedia;
    private String short_url;


    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
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

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getMaterial_type_facet() {
        return material_type_facet;
    }

    public void setMaterial_type_facet(String material_type_facet) {
        this.material_type_facet = material_type_facet;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public JSONArray getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(JSONArray multimedia) {
        this.multimedia = multimedia;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public Results(JSONObject jsonObject){
        try {
            ArrayList <MultiMedia> multimedia = new ArrayList< MultiMedia >();
            this.section = jsonObject.getString("section");
            this.short_url = jsonObject.getString("short_url");
            this.subsection = jsonObject.getString("subsection");
            this.url= jsonObject.getString("url");
            this.byline = jsonObject.getString("byline");
            this.item_type = jsonObject.getString("item_type");
            this.updated_date = jsonObject.getString("updated_date");
            this.created_date = jsonObject.getString("created_date");
            this.published_date= jsonObject.getString("published_date");
            this.material_type_facet = jsonObject.getString("material_type_facet");
            this.kicker = jsonObject.getString("kicker");
            this.multimedia = jsonObject.getJSONArray("multimedia");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Results(Parcel in) {
        section = in.readString();
        subsection = in.readString();
        title = in.readString();
        url = in.readString();
        byline = in.readString();
        item_type = in.readString();
        updated_date = in.readString();
        created_date = in.readString();
        published_date = in.readString();
        material_type_facet = in.readString();
        kicker = in.readString();
        short_url = in.readString();
    }

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel in) {
            return new Results(in);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(section);
        dest.writeString(subsection);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(byline);
        dest.writeString(item_type);
        dest.writeString(updated_date);
        dest.writeString(created_date);
        dest.writeString(published_date);
        dest.writeString(material_type_facet);
        dest.writeString(kicker);
        dest.writeString(short_url);
    }
}
