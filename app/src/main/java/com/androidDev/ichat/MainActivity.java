package com.androidDev.ichat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.androidDev.ichat.Fragments.AddPostFragment;
import com.androidDev.ichat.Fragments.ChatFragment;
import com.androidDev.ichat.Fragments.HomeFragment;
import com.androidDev.ichat.Fragments.NotificationFragment;
import com.androidDev.ichat.Fragments.ProfileFragment;
import com.androidDev.ichat.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    FirebaseAuth  auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().hide();




        auth = FirebaseAuth.getInstance();


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        getSupportActionBar().show();
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();

        BottomNavigationView bnv=(BottomNavigationView) findViewById(R.id.bottom_navigation);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {

                    case R.id.home:
                       getSupportActionBar().show();
                        transaction.replace(R.id.container,new HomeFragment());
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:

                        getSupportActionBar().hide();
                        transaction.replace(R.id.container,new ChatFragment());
                        Toast.makeText(getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.Shorts:
                        getSupportActionBar().hide();
                        transaction.replace(R.id.container,new ShortsFragment());
                        Toast.makeText(getApplicationContext(), "Add Post", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notification:
                        getSupportActionBar().hide();
                        transaction.replace(R.id.container,new NotificationFragment());
//                        Intent intent=new Intent(MainActivity.this,NotificationTabsActivity.class);
//                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
                        getSupportActionBar().hide();
                        transaction.replace(R.id.container,new ProfileFragment());
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                        break;

                }
                transaction.commit();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.chatsitems,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
