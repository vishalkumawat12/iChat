package com.androidDev.ichat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
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
        getSupportActionBar().hide();


//        binding.settingsprofile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this,"Settings",Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        setSupportActionBar(binding.toolbar2);
//        MainActivity.this.setTitle("My Profile");
//        MainActivity.this.setTitleColor(Color.WHITE);

        auth = FirebaseAuth.getInstance();
//        binding.button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                auth.signOut();
//                startActivity(new Intent(MainActivity.this, SignUp.class));
//            }
//        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        binding.toolbar2.setVisibility(View.GONE);
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();

        BottomNavigationView bnv=(BottomNavigationView) findViewById(R.id.bottom_navigation);

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {

                    case R.id.home:
//                        binding.toolbar2.setVisibility(View.GONE);
                        transaction.replace(R.id.container,new HomeFragment());
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.chat:
//                        binding.toolbar2.setVisibility(View.GONE);
                        transaction.replace(R.id.container,new ChatFragment());
                        Toast.makeText(getApplicationContext(), "Chat", Toast.LENGTH_SHORT).show();
                        break;


                    case R.id.addpost:
//                        binding.toolbar2.setVisibility(View.GONE);
                        transaction.replace(R.id.container,new AddPostFragment());
                        Toast.makeText(getApplicationContext(), "Add Post", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.notification:
//                        binding.toolbar2.setVisibility(View.GONE);
                        transaction.replace(R.id.container,new NotificationFragment());
//                        Intent intent=new Intent(MainActivity.this,NotificationTabsActivity.class);
//                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.profile:
//                        binding.toolbar2.setVisibility(View.VISIBLE);
                        transaction.replace(R.id.container,new ProfileFragment());
                        Toast.makeText(getApplicationContext(), "Profile", Toast.LENGTH_SHORT).show();
                        break;

                }
                transaction.commit();
                return true;
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.home_menu,menu);
////        menu.getItem(1).setVisible(false);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId())
//        {
//            case R.id.signout:
//                auth.signOut();
//                startActivity(new Intent(MainActivity.this, SignUp.class));
//        }
//        return super.onOptionsItemSelected(item);
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.editmenu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}
