package com.androidDev.ichat.Adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidDev.ichat.Model.notificationModel;
import com.androidDev.ichat.R;

import java.util.ArrayList;

public class notificationTabRvAdapter extends RecyclerView.Adapter<notificationTabRvAdapter.viewHolder>{

    ArrayList<notificationModel> list;
    Context context;

    public notificationTabRvAdapter(ArrayList<notificationModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.notification_tab_rv_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notificationTabRvAdapter.viewHolder holder, int position) {
        notificationModel model = list.get(position);
        holder.profile.setImageResource(model.getProfile());
        holder.notificationdata.setText(Html.fromHtml(model.getNotificationdata()));
        holder.notificationtime.setText(model.getNotificationtime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView profile;
        TextView notificationdata,notificationtime;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profile=itemView.findViewById(R.id.profile_image);
            notificationdata=itemView.findViewById(R.id.notification_data);
            notificationtime=itemView.findViewById(R.id.notification_time);
        }
    }

}
