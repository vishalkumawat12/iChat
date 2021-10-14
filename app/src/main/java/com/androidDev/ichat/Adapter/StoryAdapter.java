package com.androidDev.ichat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidDev.ichat.Model.StoryModel;
import com.androidDev.ichat.R;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.viewHolder>{

    ArrayList<StoryModel> list;
    Context context;

    public StoryAdapter(ArrayList<StoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_rv_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.viewHolder holder, int position) {

        StoryModel model = list.get(position);
        holder.storyImg.setImageResource(model.getStory());
        holder.profile.setImageResource(model.getProfile());
        holder.name.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView storyImg,profile;
        TextView name;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            storyImg = itemView.findViewById(R.id.posted_image);
            profile = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);

        }
    }

}
