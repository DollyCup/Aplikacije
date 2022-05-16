package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.ActionBarDrawerToggle;



import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public String[] mNavigationDrawerItemTitles;
    public DrawerLayout mDrawerLayout;
    public ListView mDrawerList;

    public CharSequence mDrawerTitle;

    public CharSequence mTitle;

    ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle;
        mDrawerTitle= getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerList = findViewById(R.id.left_drawer);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[3];

        drawerItem[0] = new DataModel(R.drawable.connect, "Connect");
        drawerItem[1] = new DataModel(R.drawable.fixtures, "Fixtures");
        drawerItem[2] = new DataModel(R.drawable.table, "Table");

        getSupportActionBar().setHomeButtonEnabled(true);


        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);


        setupDrawerToggle();

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ConnectFragment();
                break;
            case 1:
                fragment = new FixturesFragment();
                break;
            case 2:
                fragment = new Table();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawers();

        } else {
            //do something
        }
    }
        @Override
        public void setTitle(CharSequence title){
            mTitle=title;
            getSupportActionBar().setTitle(mTitle);
        }
         @Override

        public boolean onOptionsItemSelected(MenuItem item) {

            if (mDrawerToggle.onOptionsItemSelected(item)) {
                return true;
            }
        else
            return super.onOptionsItemSelected(item);
        }


        void setupDrawerToggle(){
            Toolbar toolbar=findViewById(R.id.toolbar);
            mDrawerToggle =new ActionBarDrawerToggle(this,mDrawerLayout,toolbar, R.string.app_name,R.string.app_name);
            mDrawerToggle.syncState();
        }
        void setupToolbar(){
            Toolbar toolbar=findViewById(R.id.toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }



        }
