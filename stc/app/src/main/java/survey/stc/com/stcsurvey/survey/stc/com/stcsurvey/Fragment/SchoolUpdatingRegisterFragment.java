package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;


import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.CommonEnum;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SetupData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SurveyData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.util.CustomizeToast;

/**
 * Created by Htet Aung Naing on 10/18/2016.
 */

public class SchoolUpdatingRegisterFragment  extends Fragment implements AdapterView.OnItemSelectedListener{

    EditText txtSchoolCode;
    EditText txtTownship;
    EditText txtVillagename;
    Spinner activityType;
    EditText txtMaleEnrolled;
    EditText txtFemaleEnrolled;
    EditText txtMaleEnrolledPoor;
    EditText txtFemaleEnrolledPoor;
    EditText txtMaleEnrolledDisable;
    EditText txtFemaleEnrolledDisable;
    EditText txtMaleEnrollmentData;
    EditText txtFemaleEnrollmentData;
    EditText txtMaleEccdCgs;
    EditText txtFemaleEccdCgs;
    EditText txtMalePefs;
    EditText txtFemalePefs;
    EditText txtMaleEccdMcs;
    EditText txtFemaleEccdMcs;
    EditText txtDescEnrolled;
    EditText txtDescEnrolledPoor;
    EditText txtDescEnrolledDisable;
    EditText txtDescEnrollment;
    EditText txtDescEccdCgs;
    EditText txtDescEccdpfs;
    EditText txtDescEccdMcs;
    Button butSave;
    View schoolUpdatingView;
    int activityKey = 0;
    List <String> activityList;
    Button btnUpdateDate;
    Date updatingDate;
    String username;
    String userid;
    int id = 0;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public SchoolUpdatingRegisterFragment(int id)
    {
        this.id = id;
    }

    public void matchUi()
    {
        txtSchoolCode = (EditText) schoolUpdatingView.findViewById(R.id.txt_su_sccode);
        txtTownship = (EditText) schoolUpdatingView.findViewById(R.id.txt_su_Township);
        txtVillagename = (EditText) schoolUpdatingView.findViewById(R.id.txt_su_villageName);
        btnUpdateDate = (Button) schoolUpdatingView.findViewById(R.id.btn_su_date);
        activityType = (Spinner) schoolUpdatingView.findViewById(R.id.sp_su_sc_activity);
        txtMaleEnrolled = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_enrolled_children_1);
        txtFemaleEnrolled = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_enrolled_children_1);
        txtMaleEnrolledPoor = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_enrolled_poor_2);
        txtFemaleEnrolledPoor = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_enrolled_poor_2);
        txtMaleEnrolledDisable = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_enrolled_disable_3);
        txtFemaleEnrolledDisable = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_enrolled_disable_3);
        txtMaleEnrollmentData = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_enrollment_4);
        txtFemaleEnrollmentData =  (EditText) schoolUpdatingView.findViewById(R.id.txt_female_enrollment_4);
        txtMaleEccdCgs = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_eccds_cgs_5);
        txtFemaleEccdCgs = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_eccds_cgs_5);
        txtMalePefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_pefs_6);
        txtFemalePefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_pefs_6);
        txtMaleEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_male_eccds_mcs_7);
        txtFemaleEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_female_eccds_mcs_7);
        butSave = (Button) schoolUpdatingView.findViewById(R.id.but_su_save);
        txtDescEnrolled = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_enrolled_children_1);
        txtDescEnrolledPoor = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_enrolled_poor_2);
        txtDescEnrolledDisable = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_enrolled_disable_3);
        txtDescEnrollment = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_enrollment_4);
        txtDescEccdCgs = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_eccds_cgs_5);
        txtDescEccdpfs = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_pefs_6);
        txtDescEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_eccds_mcs_7);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(id == 0)
        {
            schoolUpdatingView  = inflater.inflate(R.layout.school_updating_register,container,false);
            Bundle bundle = this.getArguments();
            if(bundle != null)
            {
                userid = bundle.getString("userid");
                username = bundle.getString("username");
            }
            matchUi();
            createSpinner();
            butSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingView.getContext()).deleteRealmIfMigrationNeeded().build();
                    Realm realm = Realm.getInstance(realmConfig);
                    realm.beginTransaction();
                    SchoolUpdatingData school = realm.createObject(SchoolUpdatingData.class);
                    prepareData(school , realm);
                    realm.commitTransaction();
                    CustomizeToast cuToast = new CustomizeToast("info");
                    Toast toast = cuToast.getCustomizeToast(schoolUpdatingView.getContext(),"Save Successfully!");
                    toast.show();
                    school = new SchoolUpdatingData();
                    updateData(school);
                   /* Toast.makeText(schoolUpdatingView.getContext(),"Save Successfully!",Toast.LENGTH_LONG).show();
*/
                }
            });

            btnUpdateDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new DatePickerFragment(btnUpdateDate , updatingDate);
                    newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                }
            });
        }else
        {
            schoolUpdatingView  = inflater.inflate(R.layout.school_updating_register,container,false);
           final SchoolUpdatingData school = getSchoolUpdatingDataById(id , schoolUpdatingView.getContext());
            matchUi();
            createSpinner();
          updateData(school);
            butSave.setText("Update");

            butSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingView.getContext()).deleteRealmIfMigrationNeeded().build();
                    Realm realm = Realm.getInstance(realmConfig);
                    realm.beginTransaction();
                    SchoolUpdatingData updateSchool = realm.where(SchoolUpdatingData.class)
                            .equalTo("id", school.getId()).findFirst();
                    prepareData(updateSchool , realm);
                    realm.commitTransaction();
                    Toast.makeText(schoolUpdatingView.getContext(),"Save Successfully!",Toast.LENGTH_LONG).show();

                }
            });

            btnUpdateDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new DatePickerFragment(btnUpdateDate , updatingDate);
                    newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                }
            });
        }


       return  schoolUpdatingView;
    }

    public void updateData(SchoolUpdatingData school)
    {
        List<SurveyData> surveyList = school.getSchoolSurveyList();
        txtSchoolCode.setText(school.getSchoolCode());
        txtTownship.setText(school.getTowonship());
        txtVillagename.setText(school.getVillagName());
        activityType.setSelection(school.getActivityType());
        btnUpdateDate.setText(df.format(school.getMonitoringDate()));
        txtMaleEnrolled.setText(String.valueOf(surveyList.get(0).getMalecount()));
        txtFemaleEnrolled.setText(String.valueOf(surveyList.get(0).getFemalecount()));
        txtMaleEnrolledPoor.setText(String.valueOf(surveyList.get(1).getMalecount()));
        txtFemaleEnrolledPoor.setText(String.valueOf(surveyList.get(1).getFemalecount()));
        txtMaleEnrolledDisable.setText(String.valueOf(surveyList.get(2).getMalecount()));
        txtFemaleEnrolledDisable.setText(String.valueOf(surveyList.get(2).getFemalecount()));
        txtMaleEnrollmentData.setText(String.valueOf(surveyList.get(3).getMalecount()));
        txtFemaleEnrollmentData.setText(String.valueOf(surveyList.get(3).getFemalecount()));
        txtMaleEccdCgs.setText(String.valueOf(surveyList.get(4).getMalecount()));
        txtFemaleEccdCgs.setText(String.valueOf(surveyList.get(4).getFemalecount()));
        txtMalePefs.setText(String.valueOf(surveyList.get(5).getMalecount()));
        txtFemalePefs.setText(String.valueOf(surveyList.get(5).getFemalecount()));
        txtMaleEccdMcs.setText(String.valueOf(surveyList.get(6).getMalecount()));
        txtFemaleEccdMcs.setText(String.valueOf(surveyList.get(6).getFemalecount()));
        txtDescEnrolled.setText(surveyList.get(0).getDescription());
        txtDescEnrolledPoor.setText(surveyList.get(1).getDescription());
        txtDescEnrolledDisable.setText(surveyList.get(2).getDescription());
        txtDescEnrollment.setText(surveyList.get(3).getDescription());
        txtDescEccdCgs.setText(surveyList.get(4).getDescription());
        txtDescEccdpfs.setText(surveyList.get(5).getDescription());
        txtDescEccdMcs.setText(surveyList.get(6).getDescription());
    }

    public SchoolUpdatingData getSchoolUpdatingDataById(int id,Context contex)
    {
        SchoolUpdatingData school = new SchoolUpdatingData();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> results = realm.where(SchoolUpdatingData.class).equalTo("id",id).findAll();
        List<SchoolUpdatingData> schoolList = realm.copyFromRealm(results);
        school = schoolList.get(0);
        userid = school.getCreatedUsername();

        realm.commitTransaction();
        return  school;
    }

    public void prepareData(SchoolUpdatingData school , Realm realm)
    {
        try {
        school.setCreatedUsername(userid);
        school.setModifiedUsername(userid);
        school.setCreatedDate(new Date());
        school.setModifiedDate(new Date());
        school.setSchoolCode(txtSchoolCode.getText().toString());
        school.setTowonship(txtTownship.getText().toString());
        school.setActivityType(activityKey);
        school.setVillagName(txtVillagename.getText().toString());
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        school.setMonitoringDate(df.parse(btnUpdateDate.getText().toString()));
        if(id == 0)
        {
            school.setId(getIdKey(realm));
            prepareSurveyData(school,realm);
        }else
        {
            prepareSurveyUpdateData(school,realm);
        }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getIdKey(Realm realm)
    {
        int id = 0;
        id = realm.where(SchoolUpdatingData.class).max("id").intValue() + 1;
        return id;
    }

    public void prepareSurveyUpdateData(SchoolUpdatingData school,Realm realm)
    {
       setSurveyUpdateData(school.getSchoolSurveyList().get(0),Integer.parseInt(txtMaleEnrolled.getText().toString()),Integer.parseInt(txtFemaleEnrolled.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.enrollChildren.value(),CommonEnum.SchoolSurveyRequirement.enrollChildren.description(),txtDescEnrolled.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(1),Integer.parseInt(txtMaleEnrolledPoor.getText().toString()),Integer.parseInt(txtFemaleEnrolledPoor.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.poorChildEnrollment.value(),CommonEnum.SchoolSurveyRequirement.poorChildEnrollment.description(),txtDescEnrolledPoor.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(2),Integer.parseInt(txtMaleEnrolledDisable.getText().toString()),Integer.parseInt(txtFemaleEnrolledDisable.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.disableChildEnrollment.value(),CommonEnum.SchoolSurveyRequirement.disableChildEnrollment.description(),txtDescEnrolledDisable.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(3),Integer.parseInt(txtMaleEnrollmentData.getText().toString()),Integer.parseInt(txtFemaleEnrollmentData.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.enrollEthnic.value(),CommonEnum.SchoolSurveyRequirement.enrollEthnic.description(),txtDescEnrollment.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(4),Integer.parseInt(txtMaleEccdCgs.getText().toString()),Integer.parseInt(txtFemaleEccdCgs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainEccd.value(),CommonEnum.SchoolSurveyRequirement.trainEccd.description(),txtDescEccdCgs.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(5),Integer.parseInt(txtMalePefs.getText().toString()),Integer.parseInt(txtFemalePefs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainPefs.value(),CommonEnum.SchoolSurveyRequirement.trainPefs.description(),txtDescEccdpfs.getText().toString());
        setSurveyUpdateData(school.getSchoolSurveyList().get(6),Integer.parseInt(txtMaleEccdMcs.getText().toString()),Integer.parseInt(txtFemaleEccdMcs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainedECCDMcs.value(),CommonEnum.SchoolSurveyRequirement.trainedECCDMcs.description(),txtDescEccdMcs.getText().toString());
    }

    public void prepareSurveyData(SchoolUpdatingData school,Realm realm)
    {
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEnrolled.getText().toString()),Integer.parseInt(txtFemaleEnrolled.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.enrollChildren.value(),CommonEnum.SchoolSurveyRequirement.enrollChildren.description(),txtDescEnrolled.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEnrolledPoor.getText().toString()),Integer.parseInt(txtFemaleEnrolledPoor.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.poorChildEnrollment.value(),CommonEnum.SchoolSurveyRequirement.poorChildEnrollment.description(),txtDescEnrolledPoor.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEnrolledDisable.getText().toString()),Integer.parseInt(txtFemaleEnrolledDisable.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.disableChildEnrollment.value(),CommonEnum.SchoolSurveyRequirement.disableChildEnrollment.description(),txtDescEnrolledDisable.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEnrollmentData.getText().toString()),Integer.parseInt(txtFemaleEnrollmentData.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.enrollEthnic.value(),CommonEnum.SchoolSurveyRequirement.enrollEthnic.description(),txtDescEnrollment.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEccdCgs.getText().toString()),Integer.parseInt(txtFemaleEccdCgs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainEccd.value(),CommonEnum.SchoolSurveyRequirement.trainEccd.description(),txtDescEccdCgs.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMalePefs.getText().toString()),Integer.parseInt(txtFemalePefs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainPefs.value(),CommonEnum.SchoolSurveyRequirement.trainPefs.description(),txtDescEccdpfs.getText().toString()));
        school.getSchoolSurveyList().add(setSurveyData(realm,Integer.parseInt(txtMaleEccdMcs.getText().toString()),Integer.parseInt(txtFemaleEccdMcs.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.trainedECCDMcs.value(),CommonEnum.SchoolSurveyRequirement.trainedECCDMcs.description(),txtDescEccdMcs.getText().toString()));
    }

    public SurveyData setSurveyData(Realm realm,int malecount, int femalecount, int typeid , String lbl , String description)
    {
        SurveyData survey = realm.createObject(SurveyData.class);
        survey.setCreatedUserName(userid);
        survey.setModifiedUserName(userid);
        survey.setCreatedDate(new Date());
        survey.setModifiedDate(new Date());
        survey.setMalecount(malecount);
        survey.setFemalecount(femalecount);
        survey.setTypeId(typeid);
        survey.setLabel(lbl);
        survey.setDescription(description);
        return survey;
    }

    public void setSurveyUpdateData(SurveyData survey,int malecount, int femalecount, int typeid , String lbl , String description)
    {
        survey.setCreatedUserName(userid);
        survey.setModifiedUserName(userid);
        survey.setCreatedDate(new Date());
        survey.setModifiedDate(new Date());
        survey.setMalecount(malecount);
        survey.setFemalecount(femalecount);
        survey.setTypeId(typeid);
        survey.setLabel(lbl);
        survey.setDescription(description);
    }

    public void createSpinner()
    {
        activityList = getActivityData();
        activityType.setOnItemSelectedListener(this);
        ArrayAdapter<String> rarray = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, activityList);
        rarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityType.setAdapter(rarray);
    }

    public List<String> getActivityData()
        {
        List<String>res = new ArrayList<String>() ;
        for(CommonEnum.ActivityStatus g : CommonEnum.ActivityStatus.values())
        {
            res.add(g.description());
        }

        return res;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
    {
        activityKey = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
