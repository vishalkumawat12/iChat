package com.androidDev.ichat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidDev.ichat.R;
import com.androidDev.ichat.models.MessageModel;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter {
    ArrayList<MessageModel> messageModelArrayList;
    Context context;
    String senderId;
    int senderViewType = 1;
    int receiverViewType = 2;

    public ChatAdapter(ArrayList<MessageModel> messageModelArrayList, Context context, String senderId) {
        this.messageModelArrayList = messageModelArrayList;
        this.context = context;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == senderViewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.bs_send, parent, false);
            return new ViewHolderSend(view);

        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.bg_recive, parent, false);
            return new ViewHolderReciver(view);

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (messageModelArrayList.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())) {
            return senderViewType;
        } else {
            return senderViewType;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessageModel messageModel = messageModelArrayList.get(position);
        if (holder.getClass() == ViewHolderSend.class) {

            ((ViewHolderSend) holder).SendView.setText(messageModel.getMessage());

        } else {
            ((ViewHolderReciver) holder).recView.setText(messageModel.getMessage());
        }
    }


    @Override
    public int getItemCount() {
        return messageModelArrayList.size();
    }

    class ViewHolderSend extends RecyclerView.ViewHolder {
        TextView SendView;

        public ViewHolderSend(@NonNull View itemView) {
            super(itemView);
            SendView = itemView.findViewById(R.id.sendSms);
        }
    }

    class ViewHolderReciver extends RecyclerView.ViewHolder {
        TextView recView;

        public ViewHolderReciver(@NonNull View itemView) {
            super(itemView);
            recView = itemView.findViewById(R.id.reviceSms);
        }
    }

}
