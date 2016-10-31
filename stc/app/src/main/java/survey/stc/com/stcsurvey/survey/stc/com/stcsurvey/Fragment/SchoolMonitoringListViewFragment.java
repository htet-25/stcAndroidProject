package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.retrofit.SchoolMonitoringRefrofitInterface;
import survey.stc.com.stcsurvey.retrofit.SchoolUpdatingRefrofitInterface;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter.CustomizeSMListViewAdapter;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter.CustomizeSuListViewAdapter;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.ResponseData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringListWrapper;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingListWrapper;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.util.CustomizeToast;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class SchoolMonitoringListViewFragment extends Fragment{

    View schoolMonitoringListView;
    List<SchoolMonitoringData> muploadSchoolList = new ArrayList<SchoolMonitoringData>();
    User user;
    SchoolMonitoringListWrapper schoolWrapper = new SchoolMonitoringListWrapper();


    public void deleteSchoolUpdating(String key)
    {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolMonitoringListView.getContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).equalTo("schoolCode",key).findAll();
        realmResults.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public List<SchoolMonitoringData> getAllSchoolMonitoringLIist()
    {
        List<SchoolMonitoringData>resList = new ArrayList<>();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolMonitoringListView.getContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).findAll();

        muploadSchoolList = realm.copyFromRealm(realmResults);
        resList =  realm.copyFromRealm(realmResults);
        realm.commitTransaction();

        return resList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button butUploadServer;
        final ListView lstSchoolUpdateList;

        schoolMonitoringListView = inflater.inflate(R.layout.sc_monitoring_list_view,container,false);

        final List<SchoolMonitoringData> schoolList = getAllSchoolMonitoringLIist();


        butUploadServer = (Button) schoolMonitoringListView.findViewById(R.id.but_sm_upload_server);
        lstSchoolUpdateList = (ListView) schoolMonitoringListView.findViewById(R.id.smLogListView);
        lstSchoolUpdateList.setAdapter(new CustomizeSMListViewAdapter(schoolMonitoringListView.getContext(),schoolList));
        lstSchoolUpdateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int id = schoolList.get(position).getId();
                Fragment fragment = new SchoolUpdatingRegisterFragment(id);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        butUploadServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                schoolWrapper.setSchoolLsit(muploadSchoolList);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.server_url))
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                SchoolMonitoringRefrofitInterface schoolUpdateInterface = retrofit.create(SchoolMonitoringRefrofitInterface.class);
                Call<ResponseData> schoolListcall = schoolUpdateInterface.uploadSchoolListtToserver(schoolWrapper);
                SchoolMonitoringListWrapper schoolWrapper = new SchoolMonitoringListWrapper();
                Gson gson = new Gson();
                String schoolUpdatingJson = "";
                if(muploadSchoolList.size()>0)
                {
                    schoolWrapper.setSchoolLsit(muploadSchoolList);
                    schoolUpdatingJson   = gson.toJson(schoolWrapper);
                }

                if(schoolUpdatingJson.equals(""))
                {
                    Toast.makeText(schoolMonitoringListView.getContext(),"There is no data to upload server!",Toast.LENGTH_LONG).show();
                }else
                {
                    schoolListcall.enqueue(new Callback<ResponseData>() {
                        @Override
                        public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                            ResponseData res = response.body();
                            if(res.isServerError())
                            {
                                CustomizeToast cuToast = new CustomizeToast("error");
                                Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),"Server Error!");
                                toast.show();
                              /*  Toast.makeText(schoolMonitoringListView.getContext(),"Server Error!",Toast.LENGTH_LONG).show();*/

                            }else
                            {
                                if(res.getErrorScCodeList().size()>0)
                                {
                                    String errorCode = "";
                                    for(int i = 0 ; i<res.getErrorScCodeList().size() ; i++)
                                    {
                                        errorCode += res.getErrorScCodeList().get(i)+",";
                                    }
                                    Toast.makeText(schoolMonitoringListView.getContext(),"Error Code:"+errorCode,Toast.LENGTH_LONG).show();
                                }

                                if(res.getSaveScCodeList().size()>0)
                                {
                                    for(String code : res.getSaveScCodeList())
                                    {
                                        deleteSchoolUpdating(code);
                                    }
                                }

                                lstSchoolUpdateList.setAdapter(new CustomizeSMListViewAdapter(schoolMonitoringListView.getContext(),getAllSchoolMonitoringLIist()));
                            }


                        }

                        @Override
                        public void onFailure(Call<ResponseData> call, Throwable t) {
                            Toast.makeText(schoolMonitoringListView.getContext(),"Can't connect to server!",Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });

        return schoolMonitoringListView;
    }
}
