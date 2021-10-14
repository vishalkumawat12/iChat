package com.androidDev.ichat.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidDev.ichat.Adapter.notificationTabRvAdapter;
import com.androidDev.ichat.Model.notificationModel;
import com.androidDev.ichat.R;

import java.util.ArrayList;

public class notificationTabFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<notificationModel> list;

    public notificationTabFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification_tab, container, false);

        recyclerView=view.findViewById(R.id.notificationTabRV);

        list=new ArrayList<>();
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        list.add(new notificationModel(R.drawable.deaf,"<b>Sweety</b> is live right now .... ","few minutes ago"));
        notificationTabRvAdapter adapter = new notificationTabRvAdapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        return view;
    }
}