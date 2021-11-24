package com.androidDev.ichat.Adapter;




import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidDev.ichat.ChatActivity;
import com.androidDev.ichat.R;
import com.androidDev.ichat.models.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatsUserAdapter extends RecyclerView.Adapter<ChatsUserAdapter.ViewHolder>{
    ArrayList<Users> usersArrayList;
    Context context;

    public ChatsUserAdapter(ArrayList<Users> usersArrayList, Context context) {

        this.usersArrayList = usersArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.chats_users_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = usersArrayList.get(position);
        Picasso.get().load(users.getProfilepic()).placeholder(R.drawable.deaf).into(holder.image);
        holder.userName.setText(users.getUserName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ChatActivity.class);
                intent.putExtra("UserId",users.getUserId());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
      ImageView image;
      TextView userName,lastMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.profile_image_chat);
            userName=itemView.findViewById(R.id.UserNAme);
            lastMessage=itemView.findViewById(R.id.LAstMessage);
        }
    }
}
