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

import java.util.ArrayList;
import java.util.List;

import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.CommonEnum;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SetupData;

/**
 * Created by Htet Aung Naing on 10/18/2016.
 */

public class SchoolUpdatingRegisterFragment  extends Fragment implements AdapterView.OnItemSelectedListener{

    Context context;
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
    Button butSave;
    View schoolUpdatingView;
    int activityKey = 0;
    List <String> activityList;
    Button btnUpdateDate;

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
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        schoolUpdatingView  = inflater.inflate(R.layout.school_updating_register,container,false);
        matchUi();
        createSpinner();
        butSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnUpdateDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment(btnUpdateDate);
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

            }
        });

       return  schoolUpdatingView;
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
