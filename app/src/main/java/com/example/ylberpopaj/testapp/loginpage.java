package com.example.ylberpopaj.testapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ylberpopaj on 3/23/17.
 */

public class loginpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.newpage);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){getMenuInflater().inflate(R.menu.home, menu);
    return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_name){
            startActivity(new Intent(this, MainActivity.class));
            return true;}
return true;
    }
    @Override
    public void onBackPressed(){

        startActivity(new Intent(this, MainActivity.class));

    }
}

