package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.activity;


import android.content.Context;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolMonitoringListViewFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolMonitoringRegisterFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolUpdatingListViewFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolUpdatingRegisterFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

public class DrawerLayoutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    User user;
    TextView userCodeTxt;
    TextView userNameTxt;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        user = new User();
        id = getIntent().getIntExtra("uid",0);
        user = getUserByid(id);

        View navHeaderView= navigationView.getHeaderView(0);

        userCodeTxt = (TextView) navHeaderView.findViewById(R.id.txtDrawerHeader);
        userNameTxt = (TextView) navHeaderView.findViewById(R.id.txtHeadertxt);

        userCodeTxt.setText(user.getUserId());
        userNameTxt.setText(user.getUserName());


    }

    public User getUserByid(int id)
    {
        User user = new User();

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<User> results = realm.where(User.class).equalTo("id",id).findAll();
        List<User> userData = realm.copyFromRealm(results);
        realm.commitTransaction();

        return userData.get(0);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment = null;
        int id = item.getItemId();
        String title = "";

        if (id == R.id.su_update) {
            fragment = new SchoolUpdatingRegisterFragment(0);
            title = "School Updating";
            Bundle args = new Bundle();
            args.putString("userid",user.getUserId());
            args.putString("username",user.getUserName());
            fragment.setArguments(args);
        } else if (id == R.id.su_search) {
            fragment = new SchoolUpdatingListViewFragment();
            title = "School Updating Log";
        }else if(id == R.id.sm_register)
        {
            fragment = new SchoolMonitoringRegisterFragment(0);
            title = "School Monitoring Register";
        }else if(id == R.id.sm_search)
        {
            fragment = new SchoolMonitoringListViewFragment();
            title = "School Monitoring List";
        }

        if(fragment != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
