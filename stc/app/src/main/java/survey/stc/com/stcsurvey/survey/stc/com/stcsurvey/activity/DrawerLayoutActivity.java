package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.activity;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolMonitoringListViewFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolMonitoringRegisterFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolUpdatingListViewFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment.SchoolUpdatingRegisterFragment;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

public class DrawerLayoutActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    User user;
    TextView userCodeTxt;
    Dialog exitDialog;
    TextView userNameTxt;
    int id;
    Button butCancel;
    Button butExit;
    Context activity;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = DrawerLayoutActivity.this;
        exitDialog = new Dialog(activity, R.style.FullHeightDialog);
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
        if (savedInstanceState == null) {
            onNavigationItemSelected(navigationView.getMenu().getItem(0).getSubMenu().getItem());
        }

    }

    public User getUserByid(int id)
        {
            User user = new User();

            Realm.init(getApplicationContext());
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            RealmResults<User> results = realm.where(User.class).equalTo("id",id).findAll();
            List<User> userData = realm.copyFromRealm(results);
            realm.commitTransaction();

            return userData.get(0);
    }
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        exitDialog.setCancelable(true);
        exitDialog.setCanceledOnTouchOutside(false);
        exitDialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(((Activity) activity).LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.exit_custom_dialog,
                (ViewGroup) (findViewById(R.id.outerLayout)));
        exitDialog.setContentView(layout);

        exitDialog.show();

        butCancel = (Button) layout.findViewById(R.id.butCancel);
        butExit = (Button) layout.findViewById(R.id.butExit);

        butExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitDialog.dismiss();
                //onDestroy();
                System.exit(1);

            }
        });

        butCancel.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                exitDialog.cancel();
            }
        });

   /*   if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);*/


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
            fragment =  SchoolUpdatingRegisterFragment.newInstance(0);
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
            fragment =  SchoolMonitoringRegisterFragment.newInstance(0);
            title = "School Monitoring Register";
        }else if(id == R.id.sm_search)
        {
            fragment = new SchoolMonitoringListViewFragment();
            title = "School Monitoring List";
        }else if(id == R.id.sc_log_out)
        {

            Realm.init(getApplicationContext());
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            RealmResults<User> realmResults = realm.where(User.class).findAll();
            realmResults.deleteAllFromRealm();
            realm.commitTransaction();

            finish();
            //onDestroy();
            System.exit(0);
        }else
        {
            fragment =  SchoolUpdatingRegisterFragment.newInstance(0);
            title = "School Updating";
            Bundle args = new Bundle();
            args.putString("userid",user.getUserId());
            args.putString("username",user.getUserName());
            fragment.setArguments(args);
        }

        if(fragment != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            setTitle(title);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
