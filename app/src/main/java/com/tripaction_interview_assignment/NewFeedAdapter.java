package com.tripaction_interview_assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.List;

public class NewFeedAdapter extends ArrayAdapter<NewsFeedModel> {
    public NewFeedAdapter(Context context, List<NewsFeedModel> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }
    private static class ViewHolder {
        ImageView ivImageItem;
        TextView tvNewsFeedTitle, tvNewsFeedUrl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsFeedModel imageInfo = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_news_feed, parent, false);;
            viewHolder.ivImageItem = (ImageView) convertView.findViewById(R.id.ivNewFeedImage);
            viewHolder.tvNewsFeedTitle = (TextView) convertView.findViewById(R.id.tvNewsFeedTitle);
            viewHolder.tvNewsFeedUrl = (TextView) convertView.findViewById(R.id.tvNewsFeedUrl);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivImageItem.setImageResource(0);
            Picasso.with(getContext()).load(imageInfo.getImageUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.ivImageItem);
            viewHolder.tvNewsFeedTitle.setText(imageInfo.getTitle());
            viewHolder.tvNewsFeedUrl.setText(imageInfo.getUrl());
        return convertView;
    }
}