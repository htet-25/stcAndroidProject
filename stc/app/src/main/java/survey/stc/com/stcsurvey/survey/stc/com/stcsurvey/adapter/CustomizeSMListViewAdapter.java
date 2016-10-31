package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class CustomizeSMListViewAdapter extends  ArrayAdapter<SchoolMonitoringData>{

    Context contex;
    List<SchoolMonitoringData>muploadSchoolList;

    public CustomizeSMListViewAdapter(Context context, List<SchoolMonitoringData> muploadSchoolList) {

        super(context, R.layout.customize_su_list_view_layout,  muploadSchoolList);
        this.muploadSchoolList = muploadSchoolList;
        contex = context;
        notifyDataSetChanged();

    }

    public List<SchoolMonitoringData> getMuploadSchoolList() {
        return muploadSchoolList;
    }

    public void setMuploadSchoolList(List<SchoolMonitoringData> muploadSchoolList) {
        this.muploadSchoolList = muploadSchoolList;
    }

    public List<SchoolMonitoringData> getAllSchoolUpdatingLIist()
    {
        List<SchoolMonitoringData>resList = new ArrayList<>();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).findAll();

        muploadSchoolList = realm.copyFromRealm(realmResults);
        resList =  realm.copyFromRealm(realmResults);
        realm.commitTransaction();

        return resList;
    }

    public void refreshList()
    {



        this.muploadSchoolList.clear();
        this.muploadSchoolList.addAll(getAllSchoolUpdatingLIist());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {


            LayoutInflater inflater = ((Activity) contex).getLayoutInflater();
            View row = inflater.inflate(R.layout.customize_su_list_view_layout,null);
            TextView txtViewNo = (TextView) row.findViewById(R.id.txtViewNum);
            TextView txtSchoolCode = (TextView) row.findViewById(R.id.txt_view_su_code);
            ImageView imgInfo = (ImageView) row.findViewById(R.id.img_su_info);
            ImageView imgDelete = (ImageView) row.findViewById(R.id.img_su_delete);



        final SchoolMonitoringData school = getItem(position);
        if(school != null)
        {
            txtViewNo.setText(position+1+".");
            txtSchoolCode.setText(school.getSchoolCode()+" ("+school.getTowonship()+")");
            imgInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    SchoolMonitoringCustomizeDialog customizeDialog = new SchoolMonitoringCustomizeDialog(contex,school.getId());
                    customizeDialog.show();
                }
            });
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
                    Realm realm = Realm.getInstance(realmConfig);
                    realm.beginTransaction();
                    RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).equalTo("id",school.getId()).findAll();
                    realmResults.deleteAllFromRealm();
                    realm.commitTransaction();
                    Toast.makeText(contex,"Delete Successfully!",Toast.LENGTH_LONG).show();
                    refreshList();
                }
            });
        }

        return row;
    }
}
