package com.androidDev.ichat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidDev.ichat.Model.HomeRVmodel;
import com.androidDev.ichat.R;

import java.util.ArrayList;

public class HomeRVadapter extends RecyclerView.Adapter<HomeRVadapter.viewHolder> {

    ArrayList<HomeRVmodel> list;
    Context context;

    public HomeRVadapter(ArrayList<HomeRVmodel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rv_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRVadapter.viewHolder holder, int position) {

        HomeRVmodel homeRVmodel = list.get(position);
        holder.profile.setImageResource(homeRVmodel.getProfile());
        holder.postImage.setImageResource(homeRVmodel.getPostImage());
        holder.name.setText(homeRVmodel.getName());
        holder.about.setText(homeRVmodel.getAbout());
        holder.like.setText(homeRVmodel.getLike());
        holder.comment.setText(homeRVmodel.getComment());
        holder.share.setText(homeRVmodel.getShare());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView profile,postImage,save;
        TextView name,about,like,comment,share;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profile=itemView.findViewById(R.id.profile_image);
            postImage=itemView.findViewById(R.id.posted_image);
            name=itemView.findViewById(R.id.userName);
            about=itemView.findViewById(R.id.about);
            like=itemView.findViewById(R.id.like);
            comment=itemView.findViewById(R.id.comment);
            share=itemView.findViewById(R.id.share);

        }
    }

}
