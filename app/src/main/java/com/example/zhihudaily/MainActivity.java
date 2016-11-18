package com.example.zhihudaily;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zhihudaily.Fragment.MainFragment;
import com.example.zhihudaily.Fragment.OtherContentFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static String tag = "data";
    private Context context;
    private ViewPager topimage;
    private RecyclerView todaynews;
    private MainFragment mainFragment;
    public String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        context = this;
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        try {
            mainFragment = MainFragment.class.newInstance();
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,mainFragment).commit();

    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        item.setChecked(true);
        setTitle(item.getTitle());
        Fragment fragment = null;
        Class fragmentclass = null;

        switch (id){
            case R.id.page_home:
                setId("0");
                fragmentclass = MainFragment.class;
                break;
            case R.id.page_psychology:
                setId("13");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_recommend:
                setId("12");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_movie:
                setId("3");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_boring:
                setId("11");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_design:
                setId("4");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.pager_compony:
                setId("5");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_finance:
                setId("6");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_internetSafe:
                setId("10");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_game:
                setId("2");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_music:
                setId("7");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_comic:
                setId("9");
                fragmentclass = OtherContentFragment.class;
                break;
            case R.id.page_sport:
                setId("8");
                fragmentclass = OtherContentFragment.class;
                break;
            default:
                fragmentclass = MainFragment.class;
                break;
        }

        try{
            fragment = (Fragment)fragmentclass.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("ID",getId());
            fragment.setArguments(bundle);
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        }catch (InstantiationException | IllegalAccessException e){
            e.printStackTrace();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
