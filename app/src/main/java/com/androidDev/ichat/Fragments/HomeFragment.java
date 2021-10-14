package com.androidDev.ichat.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidDev.ichat.Adapter.HomeRVadapter;
import com.androidDev.ichat.Adapter.StoryAdapter;
import com.androidDev.ichat.MainActivity;
import com.androidDev.ichat.Model.HomeRVmodel;
import com.androidDev.ichat.Model.StoryModel;
import com.androidDev.ichat.R;
import com.androidDev.ichat.SignUp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView storyRv;
    ArrayList<StoryModel> list;

    RecyclerView homeRv;
    ArrayList<HomeRVmodel> homepostlist;

    ImageView more;
    FirebaseAuth auth;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        setHasOptionsMenu(true);

        super.onCreate(savedInstanceState);
//        auth = FirebaseAuth.getInstance();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        auth = FirebaseAuth.getInstance();
        more=view.findViewById(R.id.more3dots);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Sign Out",Toast.LENGTH_SHORT).show();
                auth.signOut();
                startActivity(new Intent(getActivity(), SignUp.class));
            }
        });

        storyRv = view.findViewById(R.id.storyRV);

        list = new ArrayList<>();
        list.add(new StoryModel(R.drawable.art,R.drawable.art,"Arjun"));
        list.add(new StoryModel(R.drawable.profile_logo,R.drawable.profile_logo,"Siddanth"));
        list.add(new StoryModel(R.drawable.deaf,R.drawable.deaf,"Bro"));
        list.add(new StoryModel(R.drawable.art,R.drawable.art,"Rashi"));
        list.add(new StoryModel(R.drawable.profile_logo,R.drawable.profile_logo,"Ronak"));
        list.add(new StoryModel(R.drawable.deaf,R.drawable.deaf,"Sweety"));
        StoryAdapter adapter = new StoryAdapter(list,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        storyRv.setLayoutManager(linearLayoutManager);
        storyRv.setNestedScrollingEnabled(false);
        storyRv.setAdapter(adapter);


        homeRv = view.findViewById(R.id.home_post_rv);
        homepostlist = new ArrayList<>();
        homepostlist.add(new HomeRVmodel(R.drawable.art,R.drawable.art,"Arjun","about Arjun","546","45","7"));
        homepostlist.add(new HomeRVmodel(R.drawable.deaf,R.drawable.deaf,"Siddanth","about Siddanth","546","45","7"));
        homepostlist.add(new HomeRVmodel(R.drawable.profile_logo,R.drawable.profile_logo,"Bro","about Bro","546","45","7"));
        homepostlist.add(new HomeRVmodel(R.drawable.art,R.drawable.art,"Rashi","about Rashi","546","45","7"));
        homepostlist.add(new HomeRVmodel(R.drawable.deaf,R.drawable.deaf,"Ronak","about Ronak","546","45","7"));
        homepostlist.add(new HomeRVmodel(R.drawable.profile_logo,R.drawable.profile_logo,"Sweety","about Sweety","546","45","7"));
        HomeRVadapter homeRVadapter=new HomeRVadapter(homepostlist,getContext());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        homeRv.setLayoutManager(linearLayoutManager1);
        homeRv.setNestedScrollingEnabled(false);//for continuous scrolling .
        homeRv.setAdapter(homeRVadapter);

        return view;
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.home_menu,menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.signout:
//                Toast.makeText(getActivity(),"signout",Toast.LENGTH_SHORT).show();
////                auth.signOut();
////                startActivity(new Intent(getActivity(), SignUp.class));
//
//        }
//        return super.onOptionsItemSelected(item);
//    }

}