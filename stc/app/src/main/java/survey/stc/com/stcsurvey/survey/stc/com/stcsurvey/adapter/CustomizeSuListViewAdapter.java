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
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class CustomizeSuListViewAdapter extends  ArrayAdapter<SchoolUpdatingData>{

    Context contex;
    List<SchoolUpdatingData>muploadSchoolList;

    public CustomizeSuListViewAdapter(Context context,   List<SchoolUpdatingData> muploadSchoolList) {

        super(context, R.layout.customize_su_list_view_layout,  muploadSchoolList);
        this.muploadSchoolList = muploadSchoolList;
        contex = context;
        notifyDataSetChanged();

    }

    public List<SchoolUpdatingData> getMuploadSchoolList() {
        return muploadSchoolList;
    }

    public void setMuploadSchoolList(List<SchoolUpdatingData> muploadSchoolList) {
        this.muploadSchoolList = muploadSchoolList;
    }

    public List<SchoolUpdatingData> getAllSchoolUpdatingLIist()
    {
        List<SchoolUpdatingData>resList = new ArrayList<>();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> realmResults = realm.where(SchoolUpdatingData.class).findAll();

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



        final SchoolUpdatingData school = getItem(position);
        if(school != null)
        {
            txtViewNo.setText(position+1+".");
            txtSchoolCode.setText(school.getSchoolCode()+" ("+school.getTowonship()+")");
            imgInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    SchoolUpdatingCustomizeDialog customizeDialog = new SchoolUpdatingCustomizeDialog(contex,school.getId());
                    customizeDialog.show();
                }
            });
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
                    Realm realm = Realm.getInstance(realmConfig);
                    realm.beginTransaction();
                    RealmResults<SchoolUpdatingData> realmResults = realm.where(SchoolUpdatingData.class).equalTo("id",school.getId()).findAll();
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
