package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.CommonEnum;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SurveyData;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class SchoolMonitoringCustomizeDialog extends AlertDialog{

    private View myDialogView;
    TextView txtSchoolCode;
    TextView txtTownship;
    TextView txtVillagename;
    TextView buildingSize;
    TextView compoundSize;
    TextView txtLatrine;
    TextView rgAvailability;
    TextView spDstBtwEccdServiceTown;
    TextView spDstBtwEccdServiceSchool;
    TextView spFrequencyMeeting;
    TextView activityType;
    TextView txtRevolvingFund;
    TextView txtProfitRevlovingFund;
    TextView txtFeeFromParents;
    TextView txtOtherIncome;
    TextView txtMonthlyIncome;
    TextView txtCaregiverSalary;
    TextView txtGeneralExpense;
    TextView txtTotalExpense;
    TextView txtMontlyBalance;
    TextView txtIssue;
    TextView rgCompletelyResolve;
    TextView rgoCenterFunction;
    TextView txtScoreEccdApe;
    TextView txtTechnicalSupport;
    TextView txtFundingSupport;
    TextView txtTlmsSupport;
    TextView txtMaleChildrenVillage0T3;
    TextView txtFemaleChildrenVillage0T3;
    TextView txtDescriptionChindrenVillage0T3;
    TextView txtMaleChildrenVillage3T5;
    TextView txtFemaleChildrenVillage3T5;
    TextView txtDescriptionChindrenVillage3T5;
    TextView txtMaleEnrolledVillage0T3;
    TextView txtFemaleEnrolledVillage0T3;
    TextView txtDescriptionEnrolledVillage0T3;
    TextView txtMaleEnrolledVillage3T5;
    TextView txtFemaleEnrolledVillage3T5;
    TextView txtDescriptionEnrolledVillage3T5;
    TextView txtMaleAttendingChildren;
    TextView txtFemaleAttendingChildren;
    TextView txtDescriptionAttendingChildren;
    TextView txtMaleTransitionBe;
    TextView txtFemaleTransitionBe;
    TextView txtDescriptionTransitionBe;
    TextView txtMaleEnrolledPoorChildren0T3;
    TextView txtFemaleEnrolledPoorChildren0T3;
    TextView txtDescriptionEnrolledPoorChildren0T3;
    TextView txtDescriptionEnrolledPoorChildren3T5;
    TextView txtDescriptionEnrolledChildren0T3;
    TextView txtMaleEnrolledPoorChildren3T5;
    TextView txtFemaleEnrolledPoorChildren3T5;
    TextView txtDescriptionEnrolledChildren3T5;
    TextView txtMaleEnrolledDisable0T3;
    TextView txtFemaleEnrolledDisable0T3;
    TextView txtDescriptionEnrolledDisable0T3;
    TextView txtMaleEnrolledDisable3T5;
    TextView txtFemaleEnrolledDisable3T5;
    TextView txtDescriptionEnrolledDisable3T5;
    TextView txtMaleVillageDisable0T3;
    TextView txtFemaleVillageDisable0T3;
    TextView txtDescriptionVillageDisable0T3;
    TextView txtMaleVillageDisable3T5;
    TextView txtFemaleVillageDisable3T5;
    TextView txtDescriptionVillageDisable3T5;
    TextView txtMaleDisableAttending;
    TextView txtFeMaleDisableAttending;
    TextView txtDescriptionDisableAttending;
    TextView txtMaleTransitionKg;
    TextView txtFemaleTransitionKg;
    TextView txtDescriptionTransitionKg;
    TextView txtMaleEnrollmentEthnic0T3;
    TextView txtFemaleEnrollmentEthnic0T3;
    TextView txtDescriptionEnrollmentEthnic0T3;
    TextView txtMaleEnrollmentEthnic3t5;
    TextView txtFemaleEnrollmentEthnic3T5;
    TextView txtDescriptionEnrollmentEthnic3T5;
    TextView txtMaleCareGivers;
    TextView txtFemaleCareGivers;
    TextView txtDescriptionCareGivers;
    TextView txtMaleTrainedCareGivers;
    TextView txtFemaleTrainedCareGivers;
    TextView txtDescriptionTrainedCareGivers;
    TextView txtMalePefs;
    TextView txtFemalePefs;
    TextView txtDescriptionPefs;
    TextView txtMaleTrainedPefs;
    TextView txtFemaleTrainedPefs;
    TextView txtDescriptionTrainedPefs;
    TextView txtMaleEccdMcs;
    TextView txtFemaleEccdMcs;
    TextView txtDescriptionEccdMcs;
    TextView txtMaleTrainedEccdMcs;
    TextView txtFemaleTrainedEccdMcs;
    TextView txtDescriptionTrainedEccdMcs;
  

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    int id = 0;

    protected SchoolMonitoringCustomizeDialog(Context context , int id) {
        super(context);
        myDialogView = View.inflate(context, R.layout.sc_monitoring_list_detail, null);

        this.id = id;
        setView(myDialogView);
        matchUi();
        updateData(getSchoolMonitoringDatabyId(id,context));
    }

    @Override
    public void setTitle(CharSequence title) {
        title = "Scoot Information";
        super.setTitle(title);
    }

    public SchoolMonitoringData getSchoolMonitoringDatabyId(int id , Context context)
    {
        SchoolMonitoringData school = new SchoolMonitoringData();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolMonitoringData> results = realm.where(SchoolMonitoringData.class).equalTo("id",id).findAll();
        List<SchoolMonitoringData> schoolList = realm.copyFromRealm(results);
        school = schoolList.get(0);
        realm.commitTransaction();
        realm.close();
        return school;
    }

    public  String getMeetingData(int id)
    {
        String ans = "";
        for(CommonEnum.FrequencyMeeting g : CommonEnum.FrequencyMeeting.values())
        {
            if(id == g.value())
            {
                ans = g.description();
                break;
            }
        }

        return ans;
    }

    public  String getDistanceBtwServiceSchool(int id)
    {
        String ans = "";
        for(CommonEnum.DistanceEccdBtwSchool g : CommonEnum.DistanceEccdBtwSchool.values())
        {
            if(id == g.value())
            {
                ans = g.description();
                break;
            }
        }

        return ans;
    }

    public  String getDistanceBtwServiceTown(int id)
    {
        String ans = "";
        for(CommonEnum.DistanceEccdBtwTown g : CommonEnum.DistanceEccdBtwTown.values())
        {
            if(id == g.value())
            {
                ans = g.description();
                break;
            }
        }

        return ans;
    }

    public void updateData(SchoolMonitoringData school)
    {
        List<SurveyData> surveyList = school.getSurveyList();
        txtSchoolCode.setText(school.getSchoolCode());
        txtTownship.setText(school.getTowonship());
        txtVillagename.setText(school.getVillagName());
        buildingSize.setText(school.getBuildingsize());
        compoundSize.setText(school.getCompundSize());
        txtLatrine.setText(String.valueOf(school.getNoOfToilet()));
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
        txtScoreEccdApe.setText(school.getMinScoreOfEccdApe());
        if(school.getGetWater() == 1)
         rgAvailability.setText("Yes");
        else rgAvailability.setText("No");

        if(school.getCompleteResolve() == 1)
            rgCompletelyResolve.setText("Yes");
        else rgCompletelyResolve.setText("No");

        if(school.getOpenClose() == 1)
            rgoCenterFunction.setText("Open");
        else rgoCenterFunction.setText("Close");
        activityType.setText((school.getActivityType()==1)? CommonEnum.ActivityStatus.eccd.description():CommonEnum.ActivityStatus.ape.description());
        spDstBtwEccdServiceSchool.setText(getDistanceBtwServiceSchool(school.getEccdServiceSchoolDistace()));
        spDstBtwEccdServiceTown.setText(getDistanceBtwServiceTown(school.getEccdServiceTownDistance()));
        spFrequencyMeeting.setText(getMeetingData(school.getFrequencyMeetingType()));
        txtTechnicalSupport.setText(school.getSupportList().get(0).getSupporter_name());
        txtFundingSupport.setText(school.getSupportList().get(1).getSupporter_name());
            txtTlmsSupport.setText(school.getSupportList().get(2).getSupporter_name());
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

    }

    public void matchUi()
    {
        txtSchoolCode = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_sccode);
        txtTownship = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_township);
        txtVillagename = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_village_name);
       
        activityType = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_activity_type);

        buildingSize = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_building_size);
        compoundSize = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_compound_size);
        txtLatrine = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_latrine);
        rgAvailability = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_clean_water);

        spDstBtwEccdServiceTown = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_dstBtw_service_town);
        spDstBtwEccdServiceSchool = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_dstBtw_service_school);
        spFrequencyMeeting = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_meeting_type);
        txtRevolvingFund = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_revolving_fund);
        txtProfitRevlovingFund = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_profit_revolving_fund);
        txtFeeFromParents = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_fee_parent);
        txtOtherIncome = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_other_income);
        txtMonthlyIncome = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_monthly_income);
        txtCaregiverSalary = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_cargiver_salary);
        txtGeneralExpense = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_general_expense);
        txtTotalExpense = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_total_expense);
        txtMontlyBalance = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_monthly_balance);
        txtIssue = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_issue);
        rgCompletelyResolve = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_complete_resolve);

        rgoCenterFunction = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_center_function);
      
        txtScoreEccdApe = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_eccdApe_score);
        txtTechnicalSupport = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_technical_support);
        txtFundingSupport = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_funding_support);
        txtTlmsSupport = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_tlms_support);
        txtMaleChildrenVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_children_village_0_3);
        txtFemaleChildrenVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_children_village_0_3);
        txtDescriptionChindrenVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_children_village_0_3);
        txtMaleChildrenVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_children_village_3_5);
        txtFemaleChildrenVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_children_village_3_5);
        txtDescriptionChindrenVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_children_village_3_5);
        txtMaleEnrolledVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_enrolled_children_0_3);
        txtFemaleEnrolledVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_enrolled_children_0_3);
        txtDescriptionEnrolledVillage0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_enrolled_children_0_3);
        txtMaleEnrolledVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_enrolled_children_3_5);
        txtFemaleEnrolledVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_enrolled_children_3_5);
        txtDescriptionEnrolledVillage3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_enrolled_children_3_5);
        txtMaleAttendingChildren = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_children_attending);
        txtFemaleAttendingChildren = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_female_children_attending);

        txtDescriptionAttendingChildren = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_children_attending);
        txtMaleTransitionBe = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_transition_be);
        txtFemaleTransitionBe = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_transition_be);
        txtDescriptionTransitionBe = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_transition_be);
        txtMaleEnrolledPoorChildren0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_male_poor_children_enroll_0_3);
        txtFemaleEnrolledPoorChildren0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_poor_children_enroll_0_3);
        txtDescriptionEnrolledPoorChildren0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_poor_children_enroll_0_3);
        txtMaleEnrolledPoorChildren3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_poor_children_enroll_3_5);
        txtFemaleEnrolledPoorChildren3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_poor_children_enroll_3_5);
        txtDescriptionEnrolledPoorChildren3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_poor_children_enroll_3_5);
        txtMaleVillageDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_disable_children_village_0_3);
        txtFemaleVillageDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_female_disable_children_village_0_3);
        txtDescriptionVillageDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_disable_children_village_0_3);
        txtMaleVillageDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_disable_children_village_3_5);
        txtFemaleVillageDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_disable_children_village_3_5);
        txtDescriptionVillageDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_disable_children_village_3_5);
        txtMaleEnrolledDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_disable_children_enroll_0_3);
        txtFemaleEnrolledDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_disable_children_enroll_0_3);
        txtDescriptionEnrolledDisable0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_disable_children_enroll_0_3);
        txtMaleEnrolledDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_disable_children_enroll_3_5);
        txtFemaleEnrolledDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_disable_children_enroll_3_5);
        txtDescriptionEnrolledDisable3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_disable_children_enroll_3_5);
        txtMaleDisableAttending = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_disable_children_attend);
        txtFeMaleDisableAttending = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_disable_children_attend);
        txtDescriptionDisableAttending = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_disable_children_attend);
        txtMaleTransitionKg = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_transition_kg);
        txtFemaleTransitionKg = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_transition_kg);
        txtDescriptionTransitionKg = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_transition_kg);
        txtMaleEnrollmentEthnic0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_ethnic_enroll_0_3);
        txtFemaleEnrollmentEthnic0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_ethnic_enroll_0_3);
        txtDescriptionEnrollmentEthnic0T3 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_ethnic_enroll_0_3);
        txtMaleEnrollmentEthnic3t5= (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_ethnic_enroll_3_5);
        txtFemaleEnrollmentEthnic3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_ethnic_enroll_3_5);
        txtDescriptionEnrollmentEthnic3T5 = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_ethnic_enroll_3_5);
        txtMaleCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_no_of_caregiver);
        txtFemaleCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_no_of_caregiver);
        txtDescriptionCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_no_of_caregiver);
        txtMaleTrainedCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_no_of_trained_caregiver);
        txtFemaleTrainedCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_no_of_trained_caregiver);
        txtDescriptionTrainedCareGivers = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_no_of_trained_caregiver);
        txtMalePefs = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_no_of_pefs);
        txtFemalePefs = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_no_of_pefs);
        txtDescriptionPefs = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_pefs);
        txtMaleTrainedPefs = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_no_of_trained_pefs);
        txtFemaleTrainedPefs = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_no_of_trained_pefs);
        txtDescriptionTrainedPefs = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_trained_pefs);
        txtMaleEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_eccd_mcs);
        txtFemaleEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_eccd_mcs);
        txtDescriptionEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_eccd_mcs);
        txtMaleTrainedEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_male_detail_trained_eccd_mcs);
        txtFemaleTrainedEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_female_detail_trained_eccd_mcs);
        txtDescriptionTrainedEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_sm_detail_description_trained_eccd_mcs);
    }


}
