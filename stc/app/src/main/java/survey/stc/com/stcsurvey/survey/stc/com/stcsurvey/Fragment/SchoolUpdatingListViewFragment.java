package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter.CustomizeSuListViewAdapter;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class SchoolUpdatingListViewFragment extends Fragment{

    View schoolUpdatingListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button butUploadServer;
        ListView lstSchoolUpdateList;

        schoolUpdatingListView = inflater.inflate(R.layout.sc_updating_list_view,container,false);

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingListView.getContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> realmResults = realm.where(SchoolUpdatingData.class).findAll();
        List<SchoolUpdatingData> schoolList = realm.copyFromRealm(realmResults);
        realm.commitTransaction();

        butUploadServer = (Button) schoolUpdatingListView.findViewById(R.id.but_su_upload_server);
        lstSchoolUpdateList = (ListView) schoolUpdatingListView.findViewById(R.id.suLogListView);
        lstSchoolUpdateList.setAdapter(new CustomizeSuListViewAdapter(schoolUpdatingListView.getContext(),schoolList));
        lstSchoolUpdateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return schoolUpdatingListView;
    }
}
