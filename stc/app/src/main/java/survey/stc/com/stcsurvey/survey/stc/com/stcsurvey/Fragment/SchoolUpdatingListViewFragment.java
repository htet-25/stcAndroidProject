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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.retrofit.SchoolUpdatingRefrofitInterface;
import survey.stc.com.stcsurvey.retrofit.UserRetrofitInterface;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter.CustomizeSuListViewAdapter;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.ResponseData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingListWrapper;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class SchoolUpdatingListViewFragment extends Fragment{

    View schoolUpdatingListView;
    List<SchoolUpdatingData> muploadSchoolList = new ArrayList<SchoolUpdatingData>();
    User user;
    SchoolUpdatingListWrapper schoolWrapper = new SchoolUpdatingListWrapper();


    public void deleteSchoolUpdating(String key)
    {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingListView.getContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> realmResults = realm.where(SchoolUpdatingData.class).equalTo("schoolCode",key).findAll();
        realmResults.deleteAllFromRealm();
        realm.commitTransaction();
    }

    public List<SchoolUpdatingData> getAllSchoolUpdatingLIist()
    {
        List<SchoolUpdatingData>resList = new ArrayList<>();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingListView.getContext()).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> realmResults = realm.where(SchoolUpdatingData.class).findAll();

        muploadSchoolList = realm.copyFromRealm(realmResults);
        resList =  realm.copyFromRealm(realmResults);
        realm.commitTransaction();

        return resList;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button butUploadServer;
        final ListView lstSchoolUpdateList;

        schoolUpdatingListView = inflater.inflate(R.layout.sc_updating_list_view,container,false);

        final List<SchoolUpdatingData> schoolList = getAllSchoolUpdatingLIist();


        butUploadServer = (Button) schoolUpdatingListView.findViewById(R.id.but_su_upload_server);
        lstSchoolUpdateList = (ListView) schoolUpdatingListView.findViewById(R.id.suLogListView);
        lstSchoolUpdateList.setAdapter(new CustomizeSuListViewAdapter(schoolUpdatingListView.getContext(),schoolList));
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
                        .baseUrl("http://192.168.27.87:8080/stcEdu/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                SchoolUpdatingRefrofitInterface schoolUpdateInterface = retrofit.create(SchoolUpdatingRefrofitInterface.class);
                Call<ResponseData> schoolListcall = schoolUpdateInterface.uploadSchoolListtToserver(schoolWrapper);
                SchoolUpdatingListWrapper schoolWrapper = new SchoolUpdatingListWrapper();
                Gson gson = new Gson();
                String schoolUpdatingJson = "";
                if(muploadSchoolList.size()>0)
                {
                    schoolWrapper.setSchoolLsit(muploadSchoolList);
                    schoolUpdatingJson   = gson.toJson(schoolWrapper);
                }

                if(schoolUpdatingJson.equals(""))
                {
                    Toast.makeText(schoolUpdatingListView.getContext(),"There is no data to upload server!",Toast.LENGTH_LONG).show();
                }else
                {
                    schoolListcall.enqueue(new Callback<ResponseData>() {
                        @Override
                        public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                            ResponseData res = response.body();
                            if(res.isServerError())
                            {
                                Toast.makeText(schoolUpdatingListView.getContext(),"Server Error!",Toast.LENGTH_LONG).show();

                            }else
                            {
                                if(res.getErrorScCodeList().size()>0)
                                {
                                    String errorCode = "";
                                    for(int i = 0 ; i<res.getErrorScCodeList().size() ; i++)
                                    {
                                        errorCode += res.getErrorScCodeList().get(i)+",";
                                    }
                                    Toast.makeText(schoolUpdatingListView.getContext(),"Error Code:"+errorCode,Toast.LENGTH_LONG).show();
                                }

                                if(res.getSaveScCodeList().size()>0)
                                {
                                    for(String code : res.getSaveScCodeList())
                                    {
                                        deleteSchoolUpdating(code);
                                    }
                                }

                                lstSchoolUpdateList.setAdapter(new CustomizeSuListViewAdapter(schoolUpdatingListView.getContext(),getAllSchoolUpdatingLIist()));
                            }


                        }

                        @Override
                        public void onFailure(Call<ResponseData> call, Throwable t) {
                            Toast.makeText(schoolUpdatingListView.getContext(),"Can't connect to server!",Toast.LENGTH_LONG).show();

                        }
                    });
                }
            }
        });

        return schoolUpdatingListView;
    }
}
