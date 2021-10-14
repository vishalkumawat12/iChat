package com.androidDev.ichat.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidDev.ichat.Adapter.HomeRVadapter;
import com.androidDev.ichat.MainActivity;
import com.androidDev.ichat.Model.HomeRVmodel;
import com.androidDev.ichat.R;
import com.androidDev.ichat.SignUp;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    RecyclerView profileRv;
    ArrayList<HomeRVmodel> mypostlist;

    ImageView settings;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        settings=view.findViewById(R.id.settingsprofile);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Settings",Toast.LENGTH_SHORT).show();
            }
        });


        profileRv = view.findViewById(R.id.my_post_rv);
        mypostlist = new ArrayList<>();
        HomeRVadapter profileRvadapter=new HomeRVadapter(mypostlist,getContext());
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        mypostlist.add(new HomeRVmodel(R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,"**iChat**","about iChat","546","45","7"));
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        profileRv.setLayoutManager(linearLayoutManager1);
        profileRv.setNestedScrollingEnabled(false);//for continuous scrolling .
        profileRv.setAdapter(profileRvadapter);

        return view;
    }


}