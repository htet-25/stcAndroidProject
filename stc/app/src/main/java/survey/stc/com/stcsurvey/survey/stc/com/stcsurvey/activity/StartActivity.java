package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/16/2016.
 */

public class StartActivity extends AppCompatActivity{

    Context activity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activity = StartActivity.this;
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(getApplicationContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<User> results = realm.where(User.class).findAll();
        realm.commitTransaction();

        if(results.isEmpty())
        {
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();

        }else
        {
            List<User> user = realm.copyFromRealm(results);
            Intent intent = new Intent(StartActivity.this , DrawerLayoutActivity.class);
            intent.putExtra("uid",user.get(0).getId());
            startActivity(intent);
            finish();
        }

    }


}
