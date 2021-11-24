package com.androidDev.ichat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidDev.ichat.Adapter.ChatAdapter;
import com.androidDev.ichat.databinding.ActivityChatBinding;
import com.androidDev.ichat.models.MessageModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ActivityChatBinding binding;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ArrayList<MessageModel> messageModelArrayList=new ArrayList<>();
    ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        getSupportActionBar().hide();

        String senderId = auth.getUid();
        String reviceiveId = getIntent().getStringExtra("UserId");
        final String senderRoom = senderId + reviceiveId;
        final String receiverRoom = reviceiveId + senderId;
        binding.smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsContent = binding.smsContent.getText().toString();
                binding.smsContent.setText("");
                if (smsContent != null) {
                    final MessageModel model = new MessageModel(senderId, smsContent);

                    Toast.makeText(ChatActivity.this, smsContent, Toast.LENGTH_SHORT).show();
                    database.getReference().child("chats").child(senderRoom).push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            database.getReference().child("chats").child(receiverRoom).push().setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });
                        }
                    });

                }
            }
        });
        adapter=new ChatAdapter(messageModelArrayList,this,reviceiveId);
        binding.ChatRV.setLayoutManager(new LinearLayoutManager(this));
        binding.ChatRV.setAdapter(adapter);

        database.getReference().child("chats").child(senderRoom)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        messageModelArrayList.clear();
                        for (DataSnapshot snapshot1:snapshot.getChildren())
                        {
                            MessageModel model=snapshot1.getValue(MessageModel.class);
                            model.setMessageId(snapshot1.getKey());
                            messageModelArrayList.add(model);
;
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });







    }
}