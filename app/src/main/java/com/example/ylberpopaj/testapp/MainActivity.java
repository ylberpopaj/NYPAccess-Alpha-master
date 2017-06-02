package com.example.ylberpopaj.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create a instance of SQLite Database

        if(SaveSharedPreference.getUserName(MainActivity.this).length()==0)
        {


            setContentView(R.layout.activity_main);

        }else
            {
            setContentView(R.layout.activity_main);
            Toast.makeText(this, "user already logged in!", Toast.LENGTH_LONG).show();
        };




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thisUsername = SaveSharedPreference.getUserName(MainActivity.this);

                Snackbar.make(view, "You are logged in as : " + thisUsername, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {finish();
            System.exit(0);

           //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            SaveSharedPreference.setUserName(MainActivity.this, "");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera /*&& SaveSharedPreference.getUserName(MainActivity.this).length() == 0*/) {
            login_fragment cameraFragment = new login_fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, cameraFragment, cameraFragment.getTag()).commit();

            //startActivity(new Intent(this, loginpage.class));
        } /*else if (id == R.id.nav_camera){
            Toast.makeText(this, "A user is logged in." + SaveSharedPreference.getUserName(getApplicationContext()), Toast.LENGTH_LONG).show();
    }*/ else if (id == R.id.nav_gallery) {
            appointment_frag navFragment = new appointment_frag();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, navFragment, navFragment.getTag()).commit();


        } else if (id == R.id.nav_slideshow) {
            map_fragment fb_frag = new map_fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, fb_frag, fb_frag.getTag()).commit();

        } else if (id == R.id.nav_manage) {

            profile_page profilePage = new profile_page();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, profilePage, profilePage.getTag()).commit();
        } else if (id == R.id.nav_share) {
            email_fragment share_frag = new email_fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, share_frag, share_frag.getTag()).commit();


        } else if (id == R.id.nav_send) {
            facebook_fragment nav_frag = new facebook_fragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.constraintlayout_fragment, nav_frag, nav_frag.getTag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
