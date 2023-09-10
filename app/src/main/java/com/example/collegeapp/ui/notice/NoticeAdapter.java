package com.example.collegeapp.ui.notice;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewApater> {
    private Context context;
    private ArrayList<noticeData> list;

    public NoticeAdapter(Context context, ArrayList<noticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewApater onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);

        return new NoticeViewApater(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewApater holder, int position) {


        noticeData currentItem = list.get(position);

        holder.deletenoticeTitle.setText(currentItem.getTitle());
        holder.date.setText(currentItem.getDate());
        holder.time.setText(currentItem.getTime());


        try {
            if (currentItem.getImage() != null)
                Glide.with(context).load(currentItem.getImage()).into(holder.deletenoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewApater extends RecyclerView.ViewHolder {


        private TextView deletenoticeTitle, date, time;
        private ImageView deletenoticeImage;

        public NoticeViewApater(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            deletenoticeTitle = itemView.findViewById(R.id.deletenoticeTitle);
            deletenoticeImage = itemView.findViewById(R.id.deletenoticeImage);
        }
    }
}
