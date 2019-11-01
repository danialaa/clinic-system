package com.example.msadentistryclinic.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.msadentistryclinic.R;
import com.example.msadentistryclinic.fragments.AddPermissionsFragment;
import com.example.msadentistryclinic.fragments.AddRolesFragment;
import com.example.msadentistryclinic.fragments.AddRoomFragment;
import com.example.msadentistryclinic.fragments.AddUsersFragment;
import com.example.msadentistryclinic.fragments.HomeFragment;
import com.example.msadentistryclinic.fragments.SearchFragment;

import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
        } else if (id == R.id.nav_add) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.add_alert));
            final String[] Choices = {getResources().getString(R.string.users),
                    getResources().getString(R.string.role),
                    getResources().getString(R.string.permission),
                    getResources().getString(R.string.permission_links),
                    getResources().getString(R.string.rooms),
                    getResources().getString(R.string.employees)};
            builder.setItems(Choices, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i)
                    {
                        case 0:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddUsersFragment()).commit();
                            break;
                        case 1:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddRolesFragment()).commit();
                            break;
                        case 2:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddPermissionsFragment()).commit();
                            break;
                        case 3:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddUsersFragment()).commit();
                            break;
                        case 4:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddRoomFragment()).commit();
                            break;
                        case 5:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new AddUsersFragment()).commit();
                            break;
                    }
                }
            });

            builder.create().show();
        } else if (id == R.id.nav_search) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.search_alert));
            final String[] Choices = {getResources().getString(R.string.users),
                    getResources().getString(R.string.permission_links),
                    getResources().getString(R.string.rooms),
                    getResources().getString(R.string.employees)};
            builder.setItems(Choices, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i)
                    {
                        case 0:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SearchFragment()).commit();
                        case 1:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SearchFragment()).commit();
                        case 2:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SearchFragment()).commit();
                        case 3:
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SearchFragment()).commit();
                    }
                }
            });
            builder.create().show();
        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle(getResources().getString(R.string.logout));
            alertDialog.setMessage(getResources().getString(R.string.logout_alert));
            alertDialog.setPositiveButton(getResources().getString(R.string.logout), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(HomeActivity.this, MainActivity.class));
                }
            });
            alertDialog.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            alertDialog.create().show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void settingsDialog(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(getResources().getString(R.string.settings));
        alertDialog.setMessage(getResources().getString(R.string.change_language));


        alertDialog.create().show();
    }
}
