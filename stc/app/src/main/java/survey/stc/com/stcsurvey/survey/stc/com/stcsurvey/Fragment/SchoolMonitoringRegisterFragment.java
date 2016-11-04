package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolSupportData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SurveyData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.util.CustomizeToast;

/**
 * Created by Htet Aung Naing on 10/18/2016.
 */

public class SchoolMonitoringRegisterFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    EditText txtSchoolCode;
    EditText txtTownship;
    EditText txtVillagename;
    EditText buildingSize;
    EditText compoundSize;
    EditText txtLatrine;
    RadioGroup rgAvailability;
    RadioButton rdoAvailabilityYes;
    RadioButton rdoAvailabilityNo;
    int availabilityWater;
    Spinner spDstBtwEccdServiceTown;
    Spinner spDstBtwEccdServiceSchool;
    Spinner spFrequencyMeeting;
    Spinner activityType;
    EditText txtRevolvingFund;
    EditText txtProfitRevlovingFund;
    EditText txtFeeFromParents;
    EditText txtOtherIncome;
    EditText txtMonthlyIncome;
    EditText txtCaregiverSalary;
    EditText txtGeneralExpense;
    EditText txtTotalExpense;
    EditText txtMontlyBalance;
    EditText txtIssue;
    RadioGroup rgCompletelyResolve;
    RadioButton rdoCompletelyResolveYes;
    RadioButton rdoCompletelyResolveNo;
    RadioGroup rgoCenterFunction;
    RadioButton rdoCenterFunctionOpen;
    RadioButton rdoCenterFunctionClose;
    int centerFunction;
    EditText txtScoreEccdApe;
    EditText txtTechnicalSupport;
    EditText txtFundingSupport;
    EditText txtTlmsSupport;
    EditText txtMaleChildrenVillage0T3;
    EditText txtFemaleChildrenVillage0T3;
    EditText txtDescriptionChindrenVillage0T3;
    EditText txtMaleChildrenVillage3T5;
    EditText txtFemaleChildrenVillage3T5;
    EditText txtDescriptionChindrenVillage3T5;
    EditText txtMaleEnrolledVillage0T3;
    EditText txtFemaleEnrolledVillage0T3;
    EditText txtDescriptionEnrolledVillage0T3;
    EditText txtMaleEnrolledVillage3T5;
    EditText txtFemaleEnrolledVillage3T5;
    EditText txtDescriptionEnrolledVillage3T5;
    EditText txtMaleAttendingChildren;
    EditText txtFemaleAttendingChildren;
    EditText txtDescriptionAttendingChildren;
    EditText txtMaleTransitionBe;
    EditText txtFemaleTransitionBe;
    EditText txtDescriptionTransitionBe;
    EditText txtMaleEnrolledPoorChildren0T3;
    EditText txtFemaleEnrolledPoorChildren0T3;
    EditText txtDescriptionEnrolledPoorChildren0T3;
    EditText txtDescriptionEnrolledPoorChildren3T5;
    EditText txtDescriptionEnrolledChildren0T3;
    EditText txtMaleEnrolledPoorChildren3T5;
    EditText txtFemaleEnrolledPoorChildren3T5;
    EditText txtDescriptionEnrolledChildren3T5;
    EditText txtMaleEnrolledDisable0T3;
    EditText txtFemaleEnrolledDisable0T3;
    EditText txtDescriptionEnrolledDisable0T3;
    EditText txtMaleEnrolledDisable3T5;
    EditText txtFemaleEnrolledDisable3T5;
    EditText txtDescriptionEnrolledDisable3T5;
    EditText txtMaleVillageDisable0T3;
    EditText txtFemaleVillageDisable0T3;
    EditText txtDescriptionVillageDisable0T3;
    EditText txtMaleVillageDisable3T5;
    EditText txtFemaleVillageDisable3T5;
    EditText txtDescriptionVillageDisable3T5;
    EditText txtMaleDisableAttending;
    EditText txtFeMaleDisableAttending;
    EditText txtDescriptionDisableAttending;
    EditText txtMaleTransitionKg;
    EditText txtFemaleTransitionKg;
    EditText txtDescriptionTransitionKg;
    EditText txtMaleEnrollmentEthnic0T3;
    EditText txtFemaleEnrollmentEthnic0T3;
    EditText txtDescriptionEnrollmentEthnic0T3;
    EditText txtMaleEnrollmentEthnic3t5;
    EditText txtFemaleEnrollmentEthnic3T5;
    EditText txtDescriptionEnrollmentEthnic3T5;
    EditText txtMaleCareGivers;
    EditText txtFemaleCareGivers;
    EditText txtDescriptionCareGivers;
    EditText txtMaleTrainedCareGivers;
    EditText txtFemaleTrainedCareGivers;
    EditText txtDescriptionTrainedCareGivers;
    EditText txtMalePefs;
    EditText txtFemalePefs;
    EditText txtDescriptionPefs;
    EditText txtMaleTrainedPefs;
    EditText txtFemaleTrainedPefs;
    EditText txtDescriptionTrainedPefs;
    EditText txtMaleEccdMcs;
    EditText txtFemaleEccdMcs;
    EditText txtDescriptionEccdMcs;
    EditText txtMaleTrainedEccdMcs;
    EditText txtFemaleTrainedEccdMcs;
    EditText txtDescriptionTrainedEccdMcs;
    TextView lblTechnicalSupport;
    TextView lblFundingSupport;
    TextView lblTlmsSupport;
    Button butSave;
    View schoolUpdatingView;
    int activityKey = 0;
    int dstBtwServiceTown = 0;
    int dstBtwServiceSchool = 0;
    int meetingType = 0;
    List <String> activityList;
    List<String>meetingList;
    List<String>dstBtwServiceTownList;
    List<String>dstBtwServiceSchoolList;
    Button btnUpdateDate;
    Date updatingDate;
    Button btnEstablishDate;
    Date estabishDate;
    String username;
    String userid;
    int id = 0;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public SchoolMonitoringRegisterFragment(int id)
    {
        this.id = id;
    }

    public void matchUi()
    {

        txtSchoolCode = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_sccode);
        txtTownship = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_Township);
        txtVillagename = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_villageName);
        btnUpdateDate = (Button) schoolUpdatingView.findViewById(R.id.btn_sm_date);
        butSave = (Button) schoolUpdatingView.findViewById(R.id.but_sm_save);
        activityType = (Spinner) schoolUpdatingView.findViewById(R.id.sp_sm_sc_activity);
        btnEstablishDate = (Button) schoolUpdatingView.findViewById(R.id.btn_sm_estiblish_date);
        buildingSize = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_building_size);
        compoundSize = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_sc_compound_size);
        txtLatrine = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_latrine);
        rgAvailability = (RadioGroup) schoolUpdatingView.findViewById(R.id.rdoCleanWaterGroup);
        rdoAvailabilityYes = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoSmCleanWaterYes);
        rdoAvailabilityNo = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoSmCleanWaterNo);
        spDstBtwEccdServiceTown = (Spinner) schoolUpdatingView.findViewById(R.id.sp_sm_distance_service_town);
        spDstBtwEccdServiceSchool = (Spinner) schoolUpdatingView.findViewById(R.id.sp_sm_distance_service_school);
        spFrequencyMeeting = (Spinner) schoolUpdatingView.findViewById(R.id.sp_sm_meeting_frequency);
        txtRevolvingFund = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_revolving);
        txtProfitRevlovingFund = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_profit_revolving_fund);
        txtFeeFromParents = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_fee_parent);
        txtOtherIncome = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_other_income);
        txtMonthlyIncome = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_total_monthly_income);
        txtCaregiverSalary = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_caregiver_salary);
        txtGeneralExpense = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_general_expense);
        txtTotalExpense = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_total_expense);
        txtMontlyBalance = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_monthly_balance);
        txtIssue = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_issues);
        rgCompletelyResolve = (RadioGroup) schoolUpdatingView.findViewById(R.id.rdoCompleteResolveGroup);
        rdoCompletelyResolveYes = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoSmResolveGroupYes);
        rdoCompletelyResolveNo = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoSmResolveGroupNo);
        rgoCenterFunction = (RadioGroup) schoolUpdatingView.findViewById(R.id.rdoCenterFunctionGroup);
        rdoCenterFunctionOpen = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoCentralFunctionGroupOpen);
        rdoCenterFunctionClose = (RadioButton) schoolUpdatingView.findViewById(R.id.rdoCentralFunctionGroupClose);
        txtScoreEccdApe = (EditText) schoolUpdatingView.findViewById(R.id.txt_smEccdApeScore);
        txtTechnicalSupport = (EditText) schoolUpdatingView.findViewById(R.id.txtTechnicalSupport);
        txtFundingSupport = (EditText) schoolUpdatingView.findViewById(R.id.txtFundingSupport);
        txtTlmsSupport = (EditText) schoolUpdatingView.findViewById(R.id.txtTlmsSupport);
        txtMaleChildrenVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_children_village_0_3);
        txtFemaleChildrenVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_children_village_0_3);
        txtDescriptionChindrenVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_description_children_village_0_3);
        txtMaleChildrenVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_children_village_3_5);
        txtFemaleChildrenVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_children_village_3_5);
        txtDescriptionChindrenVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_children_village_3_5);
        txtMaleEnrolledVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_enrolled_children_0_3);
        txtFemaleEnrolledVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_enrolled_children_0_3);
        txtDescriptionEnrolledVillage0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_enrolled_children_0_3);
        txtMaleEnrolledVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_enrolled_children_3_5);
        txtFemaleEnrolledVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_enrolled_children_3_5);
        txtDescriptionEnrolledVillage3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_enrolled_children_3_5);
        txtMaleAttendingChildren = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_children_attending);
        txtFemaleAttendingChildren = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_children_attending);
        txtDescriptionAttendingChildren = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_children_attending);
        txtMaleTransitionBe = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_transition_be);
        txtFemaleTransitionBe = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_transition_be);
        txtDescriptionTransitionBe = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_transition_be);
        txtMaleEnrolledPoorChildren0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_poor_children_enroll_0_3);
        txtFemaleEnrolledPoorChildren0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_poor_children_enroll_0_3);
        txtDescriptionEnrolledPoorChildren0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_poor_children_enroll_0_3);
        txtMaleEnrolledPoorChildren3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_poor_children_enroll_3_5);
        txtFemaleEnrolledPoorChildren3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_poor_children_enroll_3_5);
        txtDescriptionEnrolledPoorChildren3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_poor_children_enroll_3_5);
        txtMaleVillageDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_disable_children_village_0_3);
        txtFemaleVillageDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_disable_children_village_0_3);
        txtDescriptionVillageDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_disable_children_village_0_3);
        txtMaleVillageDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_disable_children_village_3_5);
        txtFemaleVillageDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_disable_children_village_3_5);
        txtDescriptionVillageDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_disable_children_village_3_5);
        txtMaleEnrolledDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_disable_children_enroll_0_3);
        txtFemaleEnrolledDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_disable_children_enroll_0_3);
        txtDescriptionEnrolledDisable0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_disable_children_enroll_0_3);
        txtMaleEnrolledDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_disable_children_enroll_3_5);
        txtFemaleEnrolledDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_disable_children_enroll_3_5);
        txtDescriptionEnrolledDisable3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_disable_children_enroll_3_5);
        txtMaleDisableAttending = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_disable_children_attend);
        txtFeMaleDisableAttending = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_disable_children_attend);
        txtDescriptionDisableAttending = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_disable_children_attend);
        txtMaleTransitionKg = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_transition_kg);
        txtFemaleTransitionKg = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_transition_kg);
        txtDescriptionTransitionKg = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_transition_kg);
        txtMaleEnrollmentEthnic0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_ethnic_enroll_0_3);
        txtFemaleEnrollmentEthnic0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_ethnic_enroll_0_3);
        txtDescriptionEnrollmentEthnic0T3 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_ethnic_enroll_0_3);
        txtMaleEnrollmentEthnic3t5= (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_ethnic_enroll_3_5);
        txtFemaleEnrollmentEthnic3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_ethnic_enroll_3_5);
        txtDescriptionEnrollmentEthnic3T5 = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_ethnic_enroll_3_5);
        txtMaleCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_no_of_caregiver);
        txtFemaleCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_no_of_caregiver);
        txtDescriptionCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_no_of_caregiver);
        txtMaleTrainedCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_no_of_trained_caregiver);
        txtFemaleTrainedCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_no_of_trained_caregiver);
        txtDescriptionTrainedCareGivers = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_no_of_trained_caregiver);
        txtMalePefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_no_of_pefs);
        txtFemalePefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_no_of_pefs);
        txtDescriptionPefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_pefs);
        txtMaleTrainedPefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_no_of_trained_pefs);
        txtFemaleTrainedPefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_no_of_trained_pefs);
        txtDescriptionTrainedPefs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_trained_pefs);
        txtMaleEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_eccd_mcs);
        txtFemaleEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_eccd_mcs);
        txtDescriptionEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_eccd_mcs);
        txtMaleTrainedEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_male_trained_eccd_mcs);
        txtFemaleTrainedEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_female_trained_eccd_mcs);
        txtDescriptionTrainedEccdMcs = (EditText) schoolUpdatingView.findViewById(R.id.txt_sm_description_trained_eccd_mcs);
        lblFundingSupport = (TextView) schoolUpdatingView.findViewById(R.id.lbl_sm_funding_support);
        lblTechnicalSupport = (TextView) schoolUpdatingView.findViewById(R.id.lbl_sm_technicalSupport);
        lblTlmsSupport = (TextView) schoolUpdatingView.findViewById(R.id.lbl_sm_tlmsSupport);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(id == 0)
        {
            schoolUpdatingView  = inflater.inflate(R.layout.school_monitoring_register,container,false);
            Bundle bundle = this.getArguments();
            if(bundle != null)
            {
                userid = bundle.getString("userid");
                username = bundle.getString("username");
            }
            matchUi();
            createActivitySpinner();
            createDstBtwSchoolServiceSpinner();
            createDstBtwSchoolTownSpinner();
            createFrequencyMeetingSpinner();
            butSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(isValidate(schoolUpdatingView.getContext()))
                    {
                        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingView.getContext()).deleteRealmIfMigrationNeeded().build();
                        Realm realm = Realm.getInstance(realmConfig);
                        realm.beginTransaction();
                        SchoolMonitoringData school = realm.createObject(SchoolMonitoringData.class);
                        prepareData(school , realm);
                        realm.commitTransaction();

                        CustomizeToast cuToast = new CustomizeToast("info");
                        Toast toast = cuToast.getCustomizeToast(schoolUpdatingView.getContext(),"Save Successfully!");
                        toast.show();
                        school = new SchoolMonitoringData();
                        updateData(school);
                    }

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

            btnEstablishDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new DatePickerFragment(btnEstablishDate , estabishDate);
                    newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                }
            });

        }else
        {
            schoolUpdatingView  = inflater.inflate(R.layout.school_monitoring_register,container,false);
           final SchoolMonitoringData school = getSchoolMonitoringDataById(id , schoolUpdatingView.getContext());
            matchUi();
            createActivitySpinner();
            createDstBtwSchoolServiceSpinner();
            createDstBtwSchoolTownSpinner();
            createFrequencyMeetingSpinner();
            updateData(school);
            butSave.setText("Update");

            butSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(isValidate(schoolUpdatingView.getContext()))
                    {
                        RealmConfiguration realmConfig = new RealmConfiguration.Builder(schoolUpdatingView.getContext()).deleteRealmIfMigrationNeeded().build();
                        Realm realm = Realm.getInstance(realmConfig);
                        realm.beginTransaction();
                        SchoolMonitoringData updateSchool = realm.where(SchoolMonitoringData.class)
                                .equalTo("id", school.getId()).findFirst();
                        prepareData(updateSchool , realm);
                        realm.commitTransaction();

                        CustomizeToast cuToast = new CustomizeToast("info");
                        Toast toast = cuToast.getCustomizeToast(schoolUpdatingView.getContext(),"Update Successfully!");
                        toast.show();
                    }

                }
            });

            btnUpdateDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new DatePickerFragment(btnUpdateDate , updatingDate);
                    newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                }
            });
            btnEstablishDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogFragment newFragment = new DatePickerFragment(btnEstablishDate , estabishDate);
                    newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");

                }
            });
        }
       return  schoolUpdatingView;
    }

    public boolean isValidate(Context context)
    {
        boolean flag = true;

        if(txtSchoolCode.getText().toString().equals(""))
        {
            flag = false;
            showCustomizeToast("School Code must not be empty!" , context);
        }else if(txtTownship.getText().toString().equals(""))
        {
            flag = false;
            showCustomizeToast("Township must not be empty!",context);
        }else if(txtVillagename.getText().toString().equals(""))
        {
            flag = false;
            showCustomizeToast("Village name must not be empty!",context);
        }else if(activityKey == 0)
        {
            flag = false;
            showCustomizeToast("Select Type of Activity!",context);
        }else if(btnUpdateDate.getText().toString().equalsIgnoreCase("choose date"))
        {
            flag = false;
            showCustomizeToast("Choose Updating Date!",context);
        }else if(btnEstablishDate.getText().toString().equalsIgnoreCase("choose date"))
        {
            flag = false;
            showCustomizeToast("Choose Established Date!",context);
        }else if(buildingSize.getText().toString().equals(""))
        {
            flag = false;
            showCustomizeToast("Building Size must not be empty!",context);
        }else if(compoundSize.getText().toString().equals(""))
        {
            flag = false;
            showCustomizeToast("Village name must not be empty!",context);
        }else if(dstBtwServiceTown == 0 )
        {
            flag = false;
            showCustomizeToast("Select Distance Type from Service and Town!",context);
        }else if(dstBtwServiceSchool == 0 )
        {
            flag = false;
            showCustomizeToast("Select Distance Type from Service and School!",context);
        }else if(meetingType == 0)
        {
            flag = false;
            showCustomizeToast("Select Meeting Type!",context);
        }

        return flag;
    }

    public void showCustomizeToast(String error,Context context)
    {
        CustomizeToast cuToast = new CustomizeToast("warn");
        Toast toast = cuToast.getCustomizeToast(context,error);
        toast.show();
    }

    public void updateData(SchoolMonitoringData school)
    {
        List<SurveyData> surveyList = school.getSurveyList();
        txtSchoolCode.setText(school.getSchoolCode());
        txtTownship.setText(school.getTowonship());
        txtVillagename.setText(school.getVillagName());
        activityType.setSelection(school.getActivityType());
        btnUpdateDate.setText(df.format(school.getMonitoringDate()));
        btnEstablishDate.setText(df.format(school.getEstablishDate()));
        buildingSize.setText(school.getBuildingsize());
        compoundSize.setText(school.getCompundSize());
        txtLatrine.setText(String.valueOf(school.getNoOfToilet()));
        spDstBtwEccdServiceTown.setSelection(school.getEccdServiceTownDistance());
        spDstBtwEccdServiceSchool.setSelection(school.getEccdServiceSchoolDistace());
        spFrequencyMeeting.setSelection(school.getFrequencyMeetingType());
        txtRevolvingFund.setText(String.valueOf(school.getAmountrevolvingfund()));
        txtProfitRevlovingFund.setText(String.valueOf(school.getMonthlyRevolvingFund()));
        txtFeeFromParents.setText(String.valueOf(school.getFeeFromParent()));
        txtOtherIncome.setText(String.valueOf(school.getOtherIncome()));
        txtMonthlyIncome.setText(String.valueOf(school.getTotalMonthlyIncome()));
        txtCaregiverSalary.setText(String.valueOf(school.getCaregiverSalary()));
        txtGeneralExpense.setText(String.valueOf(school.getGeneralExpense()));
        txtTotalExpense.setText(String.valueOf(school.getTotalexpense()));
        txtMontlyBalance.setText(String.valueOf(school.getMonthlyBalance()));
        txtIssue.setText(school.getIssue());
        if(school.getCompleteResolve() == 0)
        {
            rdoCompletelyResolveYes.setChecked(false);
            rdoCompletelyResolveNo.setChecked(true);
        }else
        {
            rdoCompletelyResolveYes.setChecked(true);
            rdoCompletelyResolveNo.setChecked(false);
        }
        if(school.getOpenClose()==0)
        {
            rdoCenterFunctionOpen.setChecked(false);
            rdoCenterFunctionClose.setChecked(true);
        }else
        {
            rdoCenterFunctionOpen.setChecked(true);
            rdoCenterFunctionClose.setChecked(false);
        }
        if(school.getGetWater()==0)
        {
            rdoAvailabilityYes.setChecked(false);
            rdoAvailabilityNo.setChecked(true);
        }else
        {
            rdoAvailabilityYes.setChecked(true);
            rdoAvailabilityNo.setChecked(false);
        }


        txtScoreEccdApe.setText(school.getMinScoreOfEccdApe());
        if(school.getSupportList().size()>0)
        {
            txtTechnicalSupport.setText(school.getSupportList().get(0).getSupporter_name());
            txtFundingSupport.setText(school.getSupportList().get(1).getSupporter_name());
            txtTlmsSupport.setText(school.getSupportList().get(2).getSupporter_name());
        }else
        {
            txtTechnicalSupport.setText("");
            txtFundingSupport.setText("");
            txtTlmsSupport.setText("");
        }

        if(school.getSurveyList().size()>0)
        {
            txtMaleChildrenVillage0T3.setText(String.valueOf(school.getSurveyList().get(0).getMalecount()));
            txtFemaleChildrenVillage0T3.setText(String.valueOf(school.getSurveyList().get(0).getFemalecount()));
            txtDescriptionChindrenVillage0T3.setText(school.getSurveyList().get(0).getDescription());
            txtMaleChildrenVillage3T5.setText(String.valueOf(school.getSurveyList().get(1).getMalecount()));
            txtFemaleChildrenVillage3T5.setText(String.valueOf(school.getSurveyList().get(1).getFemalecount()));
            txtDescriptionChindrenVillage3T5.setText(school.getSurveyList().get(1).getDescription());

            txtMaleEnrolledVillage0T3.setText(String.valueOf(school.getSurveyList().get(2).getMalecount()));
            txtFemaleEnrolledVillage0T3.setText(String.valueOf(school.getSurveyList().get(2).getFemalecount()));
            txtDescriptionEnrolledVillage0T3.setText(school.getSurveyList().get(2).getDescription());
            txtMaleEnrolledVillage3T5.setText(String.valueOf(school.getSurveyList().get(3).getMalecount()));
            txtFemaleEnrolledVillage3T5.setText(String.valueOf(school.getSurveyList().get(3).getFemalecount()));
            txtDescriptionEnrolledVillage3T5.setText(school.getSurveyList().get(3).getDescription());

            txtMaleAttendingChildren.setText(String.valueOf(school.getSurveyList().get(4).getMalecount()));
            txtFemaleAttendingChildren.setText(String.valueOf(school.getSurveyList().get(4).getFemalecount()));
            txtDescriptionAttendingChildren.setText(school.getSurveyList().get(4).getDescription());

            txtMaleTransitionBe.setText(String.valueOf(school.getSurveyList().get(5).getMalecount()));
            txtFemaleTransitionBe.setText(String.valueOf(school.getSurveyList().get(5).getFemalecount()));
            txtDescriptionTransitionBe.setText(school.getSurveyList().get(5).getDescription());

            txtMaleEnrolledPoorChildren0T3.setText(String.valueOf(school.getSurveyList().get(6).getMalecount()));
            txtFemaleEnrolledPoorChildren0T3.setText(String.valueOf(school.getSurveyList().get(6).getFemalecount()));
            txtDescriptionEnrolledPoorChildren0T3.setText(school.getSurveyList().get(6).getDescription());
            txtMaleEnrolledPoorChildren3T5.setText(String.valueOf(school.getSurveyList().get(7).getMalecount()));
            txtFemaleEnrolledPoorChildren3T5.setText(String.valueOf(school.getSurveyList().get(7).getFemalecount()));
            txtDescriptionEnrolledPoorChildren3T5.setText(school.getSurveyList().get(7).getDescription());

            txtMaleVillageDisable0T3.setText(String.valueOf(school.getSurveyList().get(8).getMalecount()));
            txtFemaleVillageDisable0T3.setText(String.valueOf(school.getSurveyList().get(8).getFemalecount()));
            txtDescriptionVillageDisable0T3.setText(school.getSurveyList().get(8).getDescription());
            txtMaleVillageDisable3T5.setText(String.valueOf(school.getSurveyList().get(9).getMalecount()));
            txtFemaleVillageDisable3T5.setText(String.valueOf(school.getSurveyList().get(9).getFemalecount()));
            txtDescriptionVillageDisable3T5.setText(school.getSurveyList().get(9).getDescription());

            txtMaleEnrolledDisable0T3.setText(String.valueOf(school.getSurveyList().get(10).getMalecount()));
            txtFemaleEnrolledDisable0T3.setText(String.valueOf(school.getSurveyList().get(10).getFemalecount()));
            txtDescriptionEnrolledDisable0T3.setText(school.getSurveyList().get(10).getDescription());
            txtMaleEnrolledDisable3T5.setText(String.valueOf(school.getSurveyList().get(11).getMalecount()));
            txtFemaleEnrolledDisable3T5.setText(String.valueOf(school.getSurveyList().get(11).getFemalecount()));
            txtDescriptionEnrolledDisable3T5.setText(school.getSurveyList().get(11).getDescription());

            txtMaleDisableAttending.setText(String.valueOf(school.getSurveyList().get(12).getMalecount()));
            txtFeMaleDisableAttending.setText(String.valueOf(school.getSurveyList().get(12).getFemalecount()));
            txtDescriptionDisableAttending.setText(school.getSurveyList().get(12).getDescription());

            txtMaleTransitionKg.setText(String.valueOf(school.getSurveyList().get(13).getMalecount()));
            txtFemaleTransitionKg.setText(String.valueOf(school.getSurveyList().get(13).getFemalecount()));
            txtDescriptionTransitionKg.setText(school.getSurveyList().get(13).getDescription());

            txtMaleEnrollmentEthnic0T3.setText(String.valueOf(school.getSurveyList().get(14).getMalecount()));
            txtFemaleEnrollmentEthnic0T3.setText(String.valueOf(school.getSurveyList().get(14).getFemalecount()));
            txtDescriptionEnrollmentEthnic0T3.setText(school.getSurveyList().get(14).getDescription());
            txtMaleEnrollmentEthnic3t5.setText(String.valueOf(school.getSurveyList().get(15).getMalecount()));
            txtFemaleEnrollmentEthnic3T5.setText(String.valueOf(school.getSurveyList().get(15).getFemalecount()));
            txtDescriptionEnrollmentEthnic3T5.setText(school.getSurveyList().get(15).getDescription());

            txtMaleCareGivers.setText(String.valueOf(school.getSurveyList().get(16).getMalecount()));
            txtFemaleCareGivers.setText(String.valueOf(school.getSurveyList().get(16).getFemalecount()));
            txtDescriptionCareGivers.setText(school.getSurveyList().get(16).getDescription());

            txtMaleTrainedCareGivers.setText(String.valueOf(school.getSurveyList().get(17).getMalecount()));
            txtFemaleTrainedCareGivers.setText(String.valueOf(school.getSurveyList().get(17).getFemalecount()));
            txtDescriptionTrainedCareGivers.setText(school.getSurveyList().get(17).getDescription());

            txtMalePefs.setText(String.valueOf(school.getSurveyList().get(18).getMalecount()));
            txtFemalePefs.setText(String.valueOf(school.getSurveyList().get(18).getFemalecount()));
            txtDescriptionPefs.setText(school.getSurveyList().get(18).getDescription());

            txtMaleTrainedPefs.setText(String.valueOf(school.getSurveyList().get(19).getMalecount()));
            txtFemaleTrainedPefs.setText(String.valueOf(school.getSurveyList().get(19).getFemalecount()));
            txtDescriptionTrainedPefs.setText(school.getSurveyList().get(19).getDescription());

            txtMaleEccdMcs.setText(String.valueOf(school.getSurveyList().get(20).getMalecount()));
            txtFemaleEccdMcs.setText(String.valueOf(school.getSurveyList().get(20).getFemalecount()));
            txtDescriptionEccdMcs.setText(school.getSurveyList().get(20).getDescription());

            txtMaleTrainedEccdMcs.setText(String.valueOf(school.getSurveyList().get(21).getMalecount()));
            txtFemaleTrainedEccdMcs.setText(String.valueOf(school.getSurveyList().get(21).getFemalecount()));
            txtDescriptionTrainedEccdMcs.setText(school.getSurveyList().get(21).getDescription());
        }else
        {
            txtMaleChildrenVillage0T3.setText(String.valueOf(0));
            txtFemaleChildrenVillage0T3.setText(String.valueOf(0));
            txtDescriptionChindrenVillage0T3.setText("");
            txtMaleChildrenVillage3T5.setText(String.valueOf(0));
            txtFemaleChildrenVillage3T5.setText(String.valueOf(0));
            txtDescriptionChindrenVillage3T5.setText("");

            txtMaleEnrolledVillage0T3.setText(String.valueOf(0));
            txtFemaleEnrolledVillage0T3.setText(String.valueOf(0));
            txtDescriptionEnrolledVillage0T3.setText("");
            txtMaleEnrolledVillage3T5.setText(String.valueOf(0));
            txtFemaleEnrolledVillage3T5.setText(String.valueOf(0));
            txtDescriptionEnrolledVillage3T5.setText("");

            txtMaleAttendingChildren.setText(String.valueOf(0));
            txtFemaleAttendingChildren.setText(String.valueOf(0));
            txtDescriptionAttendingChildren.setText("");

            txtMaleTransitionBe.setText(String.valueOf(0));
            txtFemaleTransitionBe.setText(String.valueOf(0));
            txtDescriptionTransitionBe.setText("");

            txtMaleEnrolledPoorChildren0T3.setText(String.valueOf(0));
            txtFemaleEnrolledPoorChildren0T3.setText(String.valueOf(0));
            txtDescriptionEnrolledPoorChildren0T3.setText("");
            txtMaleEnrolledPoorChildren3T5.setText(String.valueOf(0));
            txtFemaleEnrolledPoorChildren3T5.setText(String.valueOf(0));
            txtDescriptionEnrolledPoorChildren3T5.setText("");

            txtMaleVillageDisable0T3.setText(String.valueOf(0));
            txtFemaleVillageDisable0T3.setText(String.valueOf(0));
            txtDescriptionVillageDisable0T3.setText("");
            txtMaleVillageDisable3T5.setText(String.valueOf(0));
            txtFemaleVillageDisable3T5.setText(String.valueOf(0));
            txtDescriptionVillageDisable3T5.setText("");

            txtMaleEnrolledDisable0T3.setText(String.valueOf(0));
            txtFemaleEnrolledDisable0T3.setText(String.valueOf(0));
            txtDescriptionEnrolledDisable0T3.setText("");
            txtMaleEnrolledDisable3T5.setText(String.valueOf(0));
            txtFemaleEnrolledDisable3T5.setText(String.valueOf(0));
            txtDescriptionEnrolledDisable3T5.setText("");

            txtMaleDisableAttending.setText(String.valueOf(0));
            txtFeMaleDisableAttending.setText(String.valueOf(0));
            txtDescriptionDisableAttending.setText("");

            txtMaleTransitionKg.setText(String.valueOf(0));
            txtFemaleTransitionKg.setText(String.valueOf(0));
            txtDescriptionTransitionKg.setText("");

            txtMaleEnrollmentEthnic0T3.setText(String.valueOf(0));
            txtFemaleEnrollmentEthnic0T3.setText(String.valueOf(0));
            txtDescriptionEnrollmentEthnic0T3.setText("");
            txtMaleEnrollmentEthnic3t5.setText(String.valueOf(0));
            txtFemaleEnrollmentEthnic3T5.setText(String.valueOf(0));
            txtDescriptionEnrollmentEthnic3T5.setText("");

            txtMaleCareGivers.setText(String.valueOf(0));
            txtFemaleCareGivers.setText(String.valueOf(0));
            txtDescriptionCareGivers.setText("");

            txtMaleTrainedCareGivers.setText(String.valueOf(0));
            txtFemaleTrainedCareGivers.setText(String.valueOf(0));
            txtDescriptionTrainedCareGivers.setText("");

            txtMalePefs.setText(String.valueOf(0));
            txtFemalePefs.setText(String.valueOf(0));
            txtDescriptionPefs.setText("");

            txtMaleTrainedPefs.setText(String.valueOf(0));
            txtFemaleTrainedPefs.setText(String.valueOf(0));
            txtDescriptionTrainedPefs.setText("");

            txtMaleEccdMcs.setText(String.valueOf(0));
            txtFemaleEccdMcs.setText(String.valueOf(0));
            txtDescriptionEccdMcs.setText("");

            txtMaleTrainedEccdMcs.setText(String.valueOf(0));
            txtFemaleTrainedEccdMcs.setText(String.valueOf(0));
            txtDescriptionTrainedEccdMcs.setText("");
        }



    }

    public SchoolMonitoringData getSchoolMonitoringDataById(int id, Context contex)
    {
        SchoolMonitoringData school = new SchoolMonitoringData();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> results = realm.where(SchoolMonitoringData.class).equalTo("id",id).findAll();
        List<SchoolMonitoringData> schoolList = realm.copyFromRealm(results);
        school = schoolList.get(0);
        userid = school.getCreatedUsername();

        realm.commitTransaction();
        return  school;
    }

    public void prepareData(SchoolMonitoringData school , Realm realm)
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
            school.setGetWater(getAvailabilityWater());
            school.setMonitoringDate(df.parse(btnUpdateDate.getText().toString()));
            school.setEstablishDate(df.parse(btnEstablishDate.getText().toString()));
            school.setBuildingsize(buildingSize.getText().toString());
            school.setCompundSize(compoundSize.getText().toString());
            if(!txtLatrine.getText().toString().equals(""))
                school.setNoOfToilet(Integer.parseInt(txtLatrine.getText().toString()));
            else school.setNoOfToilet(0);
            school.setEccdServiceTownDistance(dstBtwServiceTown);
            school.setEccdServiceSchoolDistace(dstBtwServiceSchool);
            school.setFrequencyMeetingType(meetingType);
            if(!txtRevolvingFund.getText().toString().equals(""))
                school.setAmountrevolvingfund(Double.parseDouble(txtRevolvingFund.getText().toString()));
            else school.setAmountrevolvingfund(0);
            if(!txtProfitRevlovingFund.getText().toString().equals(""))
                school.setMonthlyRevolvingFund(Double.parseDouble(txtProfitRevlovingFund.getText().toString()));
            else school.setMonthlyRevolvingFund(0);
            if(!txtFeeFromParents.getText().toString().equals(""))
                school.setFeeFromParent(Double.parseDouble(txtFeeFromParents.getText().toString()));
            else school.setFeeFromParent(0);
            if(!txtOtherIncome.getText().toString().equals(""))
                school.setOtherIncome(Double.parseDouble(txtOtherIncome.getText().toString()));
            else school.setOtherIncome(0);
            school.setTotalMonthlyIncome(Double.parseDouble(txtOtherIncome.getText().toString())+Double.parseDouble(txtFeeFromParents.getText().toString())+Double.parseDouble(txtRevolvingFund.getText().toString()));
           if(!txtCaregiverSalary.getText().toString().equals(""))
                school.setCaregiverSalary(Double.parseDouble(txtCaregiverSalary.getText().toString()));
            else school.setCaregiverSalary(0);
            if(!txtGeneralExpense.getText().toString().equals(""))
                school.setGeneralExpense(Double.parseDouble(txtGeneralExpense.getText().toString()));
            else school.setGeneralExpense(0);
            school.setTotalexpense(Double.parseDouble(txtCaregiverSalary.getText().toString())+Double.parseDouble(txtGeneralExpense.getText().toString()));
            school.setMonthlyBalance(school.getTotalMonthlyIncome() - school.getTotalexpense());
            school.setCompleteResolve(getCompletelyResolve());
            school.setOpenClose(getCenterFuncion());
            school.setGetWater(getAvailabilityWater());
            school.setMinScoreOfEccdApe(txtScoreEccdApe.getText().toString());

            if(id == 0)
            {
                school.setId(getIdKey(realm));
                prepareSurveyData(school,realm);
                prepareSupportDatat(school,realm);
            }else
            {
                prepareSurveyUpdateData(school);
                prepareSupportUpdateDatat(school);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getAvailabilityWater()
    {
        int res = 0;
        int rid = rgAvailability.getCheckedRadioButtonId();
        if(rid == rdoAvailabilityYes.getId())
            res = 1;
        else if (rid == rdoAvailabilityNo.getId())
            res = 0 ;
        return res;
    }

    public int getCompletelyResolve()
    {
        int res = 0;
        int rid = rgCompletelyResolve.getCheckedRadioButtonId();
        if(rid == rdoCompletelyResolveYes.getId())
            res = 1;
        else if (rid == rdoCompletelyResolveNo.getId())
            res = 0 ;
        return res;
    }

    public int getCenterFuncion()
    {
        int res = 0;
        int rid = rgoCenterFunction.getCheckedRadioButtonId();
        if(rid == rdoCenterFunctionOpen.getId())
            res = 1;
        else if (rid == rdoCenterFunctionClose.getId())
            res = 0 ;
        return res;
    }

    public int getIdKey(Realm realm)
    {
        int id = 0;
        id = realm.where(SchoolMonitoringData.class).max("id").intValue() + 1;
        return id;
    }

    public void prepareSurveyUpdateData(SchoolMonitoringData school)
    {
    /*   setSurveyUpdateData(school.getSchoolSurveyList().get(0),txtMaleEnrolled.getText().toString()),txtFemaleEnrolled.getText().toString()),
                CommonEnum.SchoolSurveyRequirement.enrollChildren.value(),CommonEnum.SchoolSurveyRequirement.enrollChildren.description(),txtDescEnrolled.getText().toString());
*/

        setSurveyUpdateData(school.getSurveyList().get(0),txtMaleChildrenVillage0T3.getText().toString(),txtFemaleChildrenVillage0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildren0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildren0To3.description(),txtDescriptionChindrenVillage0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(1),txtMaleChildrenVillage3T5.getText().toString(),txtFemaleChildrenVillage3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildren3To5.description(),txtDescriptionChindrenVillage3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(2),txtMaleEnrolledVillage0T3.getText().toString(),txtFemaleEnrolledVillage0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll0To3.description(),txtDescriptionEnrolledVillage0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(3),txtMaleEnrolledVillage3T5.getText().toString(),txtFemaleEnrolledVillage3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll3To5.description(),txtDescriptionEnrolledVillage3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(4),txtMaleAttendingChildren.getText().toString(),txtMaleAttendingChildren.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenAttending.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenAttending.description(),txtDescriptionAttendingChildren.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(5),txtMaleTransitionBe.getText().toString(),txtFemaleTransitionBe.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.transitionBE.value(),CommonEnum.SchoolMonitoringSurveyData.transitionBE.description(),txtDescriptionTransitionBe.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(6),txtMaleEnrolledPoorChildren0T3.getText().toString(),txtFemaleEnrolledPoorChildren0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPoor0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPoor0To3.description(),txtDescriptionEnrolledPoorChildren0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(7),txtMaleEnrolledPoorChildren3T5.getText().toString(),txtFemaleEnrolledPoorChildren3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPoor3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPoor3To5.description(),txtDescriptionEnrolledPoorChildren3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(8),txtMaleVillageDisable0T3.getText().toString(),txtFemaleVillageDisable0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren0to3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren0to3.description(),txtDescriptionVillageDisable0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(9),txtMaleVillageDisable3T5.getText().toString(),txtFemaleVillageDisable3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren3To5.description(),txtDescriptionVillageDisable3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(10),txtMaleEnrolledDisable0T3.getText().toString(),txtFemaleEnrolledDisable0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll0To3.description(),txtDescriptionEnrolledDisable0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(11),txtMaleEnrolledDisable3T5.getText().toString(),txtFemaleEnrolledDisable3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll3To5.description(),txtDescriptionEnrolledDisable3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(12),txtMaleDisableAttending.getText().toString(),txtFeMaleDisableAttending.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOFDisableChildrenAttending.value(),CommonEnum.SchoolMonitoringSurveyData.noOFDisableChildrenAttending.description(),txtDescriptionDisableAttending.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(13),txtMaleTransitionKg.getText().toString(),txtFemaleTransitionKg.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.transitionToKG.value(),CommonEnum.SchoolMonitoringSurveyData.transitionToKG.description(),txtDescriptionTransitionKg.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(14),txtMaleEnrollmentEthnic0T3.getText().toString(),txtFemaleEnrollmentEthnic0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren0To3.description(),txtDescriptionEnrollmentEthnic0T3.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(15),txtMaleEnrollmentEthnic3t5.getText().toString(),txtFemaleEnrollmentEthnic3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren3To5.description(),txtDescriptionEnrollmentEthnic3T5.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(16),txtMaleCareGivers.getText().toString(),txtFemaleCareGivers.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfCareGivers.value(),CommonEnum.SchoolMonitoringSurveyData.noOfCareGivers.description(),txtDescriptionCareGivers.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(17),txtMaleTrainedCareGivers.getText().toString(),txtFemaleTrainedCareGivers.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainCareGiver.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainCareGiver.description(),txtDescriptionTrainedCareGivers.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(18),txtMalePefs.getText().toString(),txtFemalePefs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPefs.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPefs.description(),txtDescriptionPefs.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(19),txtMaleTrainedPefs.getText().toString(),txtFemaleTrainedPefs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainedPefs.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainedPefs.description(),txtDescriptionTrainedPefs.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(20),txtMaleEccdMcs.getText().toString(),txtFemaleEccdMcs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEccd.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEccd.description(),txtDescriptionEccdMcs.getText().toString());
        setSurveyUpdateData(school.getSurveyList().get(21),txtMaleTrainedEccdMcs.getText().toString(),txtFemaleTrainedEccdMcs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainedEccd.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainedEccd.description(),txtDescriptionTrainedEccdMcs.getText().toString());

    }

    public void prepareSurveyData(SchoolMonitoringData school,Realm realm)
    {
        school.getSurveyList().add(setSurveyData(realm,txtMaleChildrenVillage0T3.getText().toString(),txtFemaleChildrenVillage0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildren0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildren0To3.description(),txtDescriptionChindrenVillage0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleChildrenVillage3T5.getText().toString(),txtFemaleChildrenVillage3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildren3To5.description(),txtDescriptionChindrenVillage3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledVillage0T3.getText().toString(),txtFemaleEnrolledVillage0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll0To3.description(),txtDescriptionEnrolledVillage0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledVillage3T5.getText().toString(),txtFemaleEnrolledVillage3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenEnroll3To5.description(),txtDescriptionEnrolledVillage3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleAttendingChildren.getText().toString(),txtMaleAttendingChildren.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfChildrenAttending.value(),CommonEnum.SchoolMonitoringSurveyData.noOfChildrenAttending.description(),txtDescriptionAttendingChildren.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleTransitionBe.getText().toString(),txtFemaleTransitionBe.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.transitionBE.value(),CommonEnum.SchoolMonitoringSurveyData.transitionBE.description(),txtDescriptionTransitionBe.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledPoorChildren0T3.getText().toString(),txtFemaleEnrolledPoorChildren0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPoor0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPoor0To3.description(),txtDescriptionEnrolledPoorChildren0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledPoorChildren3T5.getText().toString(),txtFemaleEnrolledPoorChildren3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPoor3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPoor3To5.description(),txtDescriptionEnrolledPoorChildren3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleVillageDisable0T3.getText().toString(),txtFemaleVillageDisable0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren0to3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren0to3.description(),txtDescriptionVillageDisable0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleVillageDisable3T5.getText().toString(),txtFemaleVillageDisable3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableCildren3To5.description(),txtDescriptionVillageDisable3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledDisable0T3.getText().toString(),txtFemaleEnrolledDisable0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll0To3.description(),txtDescriptionEnrolledDisable0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrolledDisable3T5.getText().toString(),txtFemaleEnrolledDisable3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfDisableChildrenEnroll3To5.description(),txtDescriptionEnrolledDisable3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleDisableAttending.getText().toString(),txtFeMaleDisableAttending.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOFDisableChildrenAttending.value(),CommonEnum.SchoolMonitoringSurveyData.noOFDisableChildrenAttending.description(),txtDescriptionDisableAttending.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleTransitionKg.getText().toString(),txtFemaleTransitionKg.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.transitionToKG.value(),CommonEnum.SchoolMonitoringSurveyData.transitionToKG.description(),txtDescriptionTransitionKg.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrollmentEthnic0T3.getText().toString(),txtFemaleEnrollmentEthnic0T3.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren0To3.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren0To3.description(),txtDescriptionEnrollmentEthnic0T3.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEnrollmentEthnic3t5.getText().toString(),txtFemaleEnrollmentEthnic3T5.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren3To5.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEthnicChildren3To5.description(),txtDescriptionEnrollmentEthnic3T5.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleCareGivers.getText().toString(),txtFemaleCareGivers.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfCareGivers.value(),CommonEnum.SchoolMonitoringSurveyData.noOfCareGivers.description(),txtDescriptionCareGivers.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleTrainedCareGivers.getText().toString(),txtFemaleTrainedCareGivers.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainCareGiver.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainCareGiver.description(),txtDescriptionTrainedCareGivers.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMalePefs.getText().toString(),txtFemalePefs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfPefs.value(),CommonEnum.SchoolMonitoringSurveyData.noOfPefs.description(),txtDescriptionPefs.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleTrainedPefs.getText().toString(),txtFemaleTrainedPefs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainedPefs.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainedPefs.description(),txtDescriptionTrainedPefs.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleEccdMcs.getText().toString(),txtFemaleEccdMcs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfEccd.value(),CommonEnum.SchoolMonitoringSurveyData.noOfEccd.description(),txtDescriptionEccdMcs.getText().toString()));
        school.getSurveyList().add(setSurveyData(realm,txtMaleTrainedEccdMcs.getText().toString(),txtFemaleTrainedEccdMcs.getText().toString(),
                CommonEnum.SchoolMonitoringSurveyData.noOfTrainedEccd.value(),CommonEnum.SchoolMonitoringSurveyData.noOfTrainedEccd.description(),txtDescriptionTrainedEccdMcs.getText().toString()));
    }

    public void prepareSupportDatat(SchoolMonitoringData school , Realm realm)
    {
        school.getSupportList().add(setSupportData(realm,lblTechnicalSupport.getText().toString(),CommonEnum.SupportTitle.Technical.value(),txtTechnicalSupport.getText().toString()));
        school.getSupportList().add(setSupportData(realm,lblFundingSupport.getText().toString(),CommonEnum.SupportTitle.Funding.value(),txtFundingSupport.getText().toString()));
        school.getSupportList().add(setSupportData(realm,lblTlmsSupport.getText().toString(),CommonEnum.SupportTitle.Tlms.value(),txtTlmsSupport.getText().toString()));
    }

    public void prepareSupportUpdateDatat(SchoolMonitoringData school )
    {
        setSupportUpdateData(school.getSupportList().get(0),lblTechnicalSupport.getText().toString(),CommonEnum.SupportTitle.Technical.value(),txtTechnicalSupport.getText().toString());
        setSupportUpdateData(school.getSupportList().get(1),lblFundingSupport.getText().toString(),CommonEnum.SupportTitle.Funding.value(),txtFundingSupport.getText().toString());
        setSupportUpdateData(school.getSupportList().get(2),lblTlmsSupport.getText().toString(),CommonEnum.SupportTitle.Tlms.value(),txtTlmsSupport.getText().toString());
    }

    public SurveyData setSurveyData(Realm realm,String malecount, String femalecount, int typeid , String lbl , String description)
    {
        SurveyData survey = realm.createObject(SurveyData.class);
        survey.setCreatedUserName(userid);
        survey.setModifiedUserName(userid);
        survey.setCreatedDate(new Date());
        survey.setModifiedDate(new Date());
        if(!malecount.equals(""))
            survey.setMalecount(Integer.parseInt(malecount));
        else survey.setMalecount(0);
        if(!femalecount.equals(""))
             survey.setFemalecount(Integer.parseInt(femalecount));
        else survey.setFemalecount(0);
        survey.setTypeId(typeid);
        survey.setLabel(lbl);
        survey.setDescription(description);
        return survey;
    }

    public SchoolSupportData setSupportData(Realm realm,String support_lbl , int support_type ,String support_name)
    {
        SchoolSupportData support = realm.createObject(SchoolSupportData.class);
        support.setSchool_code(txtSchoolCode.getText().toString());
        support.setSupport_lbl(support_lbl);
        support.setSupport_type(support_type);
        support.setSupporter_name(support_name);
        return support;
    }

    public void setSupportUpdateData(SchoolSupportData support,String support_lbl , int support_type ,String support_name)
    {
        support.setSchool_code(txtSchoolCode.getText().toString());
        support.setSupport_lbl(support_lbl);
        support.setSupport_type(support_type);
        support.setSupporter_name(support_name);
    }


    public void setSurveyUpdateData(SurveyData survey,String malecount, String femalecount, int typeid , String lbl , String description)
    {
        survey.setCreatedUserName(userid);
        survey.setModifiedUserName(userid);
        survey.setCreatedDate(new Date());
        survey.setModifiedDate(new Date());
        if(!malecount.equals(""))
            survey.setMalecount(Integer.parseInt(malecount));
        else survey.setMalecount(0);
        if(!femalecount.equals(""))
            survey.setFemalecount(Integer.parseInt(femalecount));
        else survey.setFemalecount(0);
        survey.setTypeId(typeid);
        survey.setLabel(lbl);
        survey.setDescription(description);
    }

    public void createActivitySpinner()
    {
        activityList = getActivityData();
        activityType.setOnItemSelectedListener(this);
        ArrayAdapter<String> rarray = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, activityList);
        rarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activityType.setAdapter(rarray);
    }

    public void createDstBtwSchoolTownSpinner()
    {
        dstBtwServiceTownList = getEccdServiceTownData();
        spDstBtwEccdServiceTown.setOnItemSelectedListener(this);
        ArrayAdapter<String> rarray = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, dstBtwServiceTownList);
        rarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDstBtwEccdServiceTown.setAdapter(rarray);
    }

    public void createDstBtwSchoolServiceSpinner()
    {
        dstBtwServiceSchoolList = getEccdServiceSchoolData();
        spDstBtwEccdServiceSchool.setOnItemSelectedListener(this);
        ArrayAdapter<String> rarray = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, dstBtwServiceSchoolList);
        rarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDstBtwEccdServiceSchool.setAdapter(rarray);
    }

    public void createFrequencyMeetingSpinner()
    {
        meetingList = getMeetingData();
        spFrequencyMeeting.setOnItemSelectedListener(this);
        ArrayAdapter<String> rarray = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, meetingList);
        rarray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFrequencyMeeting.setAdapter(rarray);
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

    public List<String> getEccdServiceTownData()
    {
        List<String>res = new ArrayList<String>() ;
        for(CommonEnum.DistanceEccdBtwTown g : CommonEnum.DistanceEccdBtwTown.values())
        {
            res.add(g.description());
        }

        return res;
    }

    public List<String> getEccdServiceSchoolData()
    {
        List<String>res = new ArrayList<String>() ;
        for(CommonEnum.DistanceEccdBtwSchool g : CommonEnum.DistanceEccdBtwSchool.values())
        {
            res.add(g.description());
        }

        return res;
    }

    public List<String> getMeetingData()
    {
        List<String>res = new ArrayList<String>() ;
        for(CommonEnum.FrequencyMeeting g : CommonEnum.FrequencyMeeting.values())
        {
            res.add(g.description());
        }

        return res;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l)
    {
        Spinner mspinner = (Spinner) parent;
        if(mspinner.getId() == R.id.sp_sm_sc_activity)
        {
            activityKey = position;
        }else if(mspinner.getId() == R.id.sp_sm_distance_service_town)
        {
            dstBtwServiceTown = position;
        }else if(mspinner.getId() == R.id.sp_sm_distance_service_school)
        {
            dstBtwServiceSchool = position;
        }else if(mspinner.getId() == R.id.sp_sm_meeting_frequency)
        {
            meetingType = position;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
