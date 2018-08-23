package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
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

public class SchoolMonitoringListViewFragment extends  Fragment {

    View schoolMonitoringListView;
    View mProgressView;
    View schoolMonitoringView;
    List<SchoolMonitoringData> muploadSchoolList = new ArrayList<SchoolMonitoringData>();
    User user;
    SchoolMonitoringListWrapper schoolWrapper = new SchoolMonitoringListWrapper();


    public void deleteSchoolUpdating(String key)
    {
        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).equalTo("schoolCode",key).findAll();
        realmResults.deleteAllFromRealm();
        realm.commitTransaction();
        realm.close();
    }

    public List<SchoolMonitoringData> getAllSchoolMonitoringLIist()
    {
        List<SchoolMonitoringData>resList = new ArrayList<>();
        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> realmResults = realm.where(SchoolMonitoringData.class).findAll();

        muploadSchoolList = realm.copyFromRealm(realmResults);
        resList =  realm.copyFromRealm(realmResults);
        realm.commitTransaction();
        realm.close();
        return resList;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            schoolMonitoringView.setVisibility(show ? View.GONE : View.VISIBLE);
            schoolMonitoringView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    schoolMonitoringView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            schoolMonitoringView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Button butUploadServer;
        final ListView lstSchoolUpdateList;

        schoolMonitoringListView = inflater.inflate(R.layout.sc_monitoring_list_view,container,false);

        final List<SchoolMonitoringData> schoolList = getAllSchoolMonitoringLIist();

        mProgressView =  schoolMonitoringListView.findViewById(R.id.school_monitoring_list_view_progress);
        schoolMonitoringView = schoolMonitoringListView.findViewById(R.id.school_monitoring_list_view);
        butUploadServer = (Button) schoolMonitoringListView.findViewById(R.id.but_sm_upload_server);
        lstSchoolUpdateList = (ListView) schoolMonitoringListView.findViewById(R.id.smLogListView);
        lstSchoolUpdateList.setAdapter(new CustomizeSMListViewAdapter(schoolMonitoringListView.getContext(),schoolList));
        lstSchoolUpdateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int id = schoolList.get(position).getId();
                Fragment fragment =  SchoolMonitoringRegisterFragment.newInstance(id);
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

                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setDateFormat("yyyy-MM-dd");
                Gson gson = gsonBuilder.create();


                final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .readTimeout(60, TimeUnit.SECONDS)
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .build();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(getString(R.string.server_url))
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(okHttpClient)
                        .build();

                SchoolMonitoringRefrofitInterface schoolUpdateInterface = retrofit.create(SchoolMonitoringRefrofitInterface.class);
                Call<ResponseData> schoolListcall = schoolUpdateInterface.uploadSchoolListtToserver(schoolWrapper);
                SchoolMonitoringListWrapper schoolWrapper = new SchoolMonitoringListWrapper();

                String schoolUpdatingJson = "";
                if(muploadSchoolList.size()>0)
                {
                    schoolWrapper.setSchoolLsit(muploadSchoolList);
                    schoolUpdatingJson   = gson.toJson(schoolWrapper);
                }

                if(schoolUpdatingJson.equals(""))
                {
                    CustomizeToast cuToast = new CustomizeToast("error");
                    Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),"There is no data to upload!");
                    toast.show();
                }else
                {
                    showProgress(true);
                    schoolListcall.enqueue(new Callback<ResponseData>() {
                        @Override
                        public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                            ResponseData res = response.body();
                            String err = response.message();
                            if(res.isServerError())
                            {
                                showProgress(false);
                                CustomizeToast cuToast = new CustomizeToast("error");
                                Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),"Server Error!");
                                toast.show();
                              /*  Toast.makeText(schoolMonitoringListView.getContext(),"Server Error!",Toast.LENGTH_LONG).show();*/

                            }else
                            {
                                showProgress(false);
                                if(res.getErrorScCodeList().size()>0)
                                {
                                    String errorCode = "";
                                    for(int i = 0 ; i<res.getErrorScCodeList().size() ; i++)
                                    {
                                        errorCode += res.getErrorScCodeList().get(i)+",";
                                    }
                                    CustomizeToast cuToast = new CustomizeToast("error");
                                    Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),"Error Code:"+errorCode);
                                    toast.show();
                                }

                                if(res.getSaveScCodeList().size()>0)
                                {
                                    String saveCode = "";
                                    for(String code : res.getSaveScCodeList())
                                    {
                                        saveCode += code+",";
                                        deleteSchoolUpdating(code);
                                    }
                                    CustomizeToast cuToast = new CustomizeToast("info");
                                    Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),saveCode +" are uploaded to server successfully!");
                                    toast.show();
                                }



                                lstSchoolUpdateList.setAdapter(new CustomizeSMListViewAdapter(schoolMonitoringListView.getContext(),getAllSchoolMonitoringLIist()));
                            }


                        }

                        @Override
                        public void onFailure(Call<ResponseData> call, Throwable t) {
                            showProgress(false);
                            CustomizeToast cuToast = new CustomizeToast("error");
                            Toast toast = cuToast.getCustomizeToast(schoolMonitoringListView.getContext(),"Can't connect to server!");
                            toast.show();
                        }
                    });
                }
            }
        });

        return schoolMonitoringListView;
    }
}
