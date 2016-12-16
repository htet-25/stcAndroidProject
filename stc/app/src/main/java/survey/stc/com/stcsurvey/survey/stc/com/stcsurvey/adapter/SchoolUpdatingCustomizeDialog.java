package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.CommonEnum;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SurveyData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class SchoolUpdatingCustomizeDialog extends AlertDialog{

    private View myDialogView;
    TextView txtSchoolCode;
    TextView txtTownship;
    TextView txtVillagename;
    TextView activityType;
    TextView txtMaleEnrolled;
    TextView txtFemaleEnrolled;
    TextView txtMaleEnrolledPoor;
    TextView txtFemaleEnrolledPoor;
    TextView txtMaleEnrolledDisable;
    TextView txtFemaleEnrolledDisable;
    TextView txtMaleEnrollmentData;
    TextView txtFemaleEnrollmentData;
    TextView txtMaleEccdCgs;
    TextView txtFemaleEccdCgs;
    TextView txtMalePefs;
    TextView txtFemalePefs;
    TextView txtMaleEccdMcs;
    TextView txtFemaleEccdMcs;
    TextView txtUpdatingDate;
    TextView txtDescEnrolled;
    TextView txtDescEnrolledPoor;
    TextView txtDescEnrolledDisable;
    TextView txtDescEnrollment;
    TextView txtDescEccdCgs;
    TextView txtDescEccdPefs;
    TextView txtDescEccdMcs;

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    int id = 0;

    protected SchoolUpdatingCustomizeDialog(Context context , int id) {
        super(context);
        myDialogView = View.inflate(context, R.layout.su_update_list_detail, null);

        this.id = id;
        setView(myDialogView);
        matchUi();
        updateData(getSchoolUpdatingDatabyId(id,context),context);
    }

    @Override
    public void setTitle(CharSequence title) {
        title = "Scoot Information";
        super.setTitle(title);
    }

    public SchoolUpdatingData getSchoolUpdatingDatabyId(int id , Context context)
    {
        SchoolUpdatingData school = new SchoolUpdatingData();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        RealmResults<SchoolUpdatingData> results = realm.where(SchoolUpdatingData.class).equalTo("id",id).findAll();
        List<SchoolUpdatingData> schoolList = realm.copyFromRealm(results);
        school = schoolList.get(0);
        realm.commitTransaction();
        realm.close();
        return school;
    }

    public void matchUi()
    {
        txtSchoolCode = (TextView) myDialogView.findViewById(R.id.txt_su_detail_sccode);
        txtTownship = (TextView) myDialogView.findViewById(R.id.txt_su_detail_Township);
        txtVillagename = (TextView) myDialogView.findViewById(R.id.txt_su_detail_villageName);
        activityType = (TextView) myDialogView.findViewById(R.id.txt_su_detail_activity);
        txtMaleEnrolled = (TextView) myDialogView.findViewById(R.id.txt_male_detail_enrolled_children_1);
        txtFemaleEnrolled = (TextView) myDialogView.findViewById(R.id.txt_female_detail_enrolled_children_1);
        txtMaleEnrolledPoor = (TextView) myDialogView.findViewById(R.id.txt_male_detail_enrolled_poor_2);
        txtFemaleEnrolledPoor = (TextView) myDialogView.findViewById(R.id.txt_female_detail_enrolled_poor_2);
        txtMaleEnrolledDisable = (TextView) myDialogView.findViewById(R.id.txt_male_detail_enrolled_disable_3);
        txtFemaleEnrolledDisable = (TextView) myDialogView.findViewById(R.id.txt_female_detail_enrolled_disable_3);
        txtMaleEnrollmentData = (TextView) myDialogView.findViewById(R.id.txt_male_detail_enrollment_4);
        txtFemaleEnrollmentData =  (TextView) myDialogView.findViewById(R.id.txt_female_detail_enrollment_4);
        txtMaleEccdCgs = (TextView) myDialogView.findViewById(R.id.txt_male_detail_eccds_cgs_5);
        txtFemaleEccdCgs = (TextView) myDialogView.findViewById(R.id.txt_female_detail_eccds_cgs_5);
        txtMalePefs = (TextView) myDialogView.findViewById(R.id.txt_male_detail_pefs_6);
        txtFemalePefs = (TextView) myDialogView.findViewById(R.id.txt_female_detail_pefs_6);
        txtMaleEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_male_detail_eccds_mcs_7);
        txtFemaleEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_female_detail_eccds_mcs_7);
        txtDescEnrolled = (TextView) myDialogView.findViewById(R.id.txt_description_detail_enrolled_children_1);
        txtDescEnrolledPoor = (TextView) myDialogView.findViewById(R.id.txt_description_detail_enrolled_poor_2);
        txtDescEnrolledDisable = (TextView) myDialogView.findViewById(R.id.txt_description_detail_enrolled_disable_3);
        txtDescEnrollment = (TextView) myDialogView.findViewById(R.id.txt_description_detail_enrollment_4);
        txtDescEccdCgs = (TextView) myDialogView.findViewById(R.id.txt_description_detail_eccds_cgs_5);
        txtDescEccdPefs = (TextView) myDialogView.findViewById(R.id.txt_description_detail_pefs_6);
        txtDescEccdMcs = (TextView) myDialogView.findViewById(R.id.txt_description_detail_eccds_mcs_7);
        txtUpdatingDate = (TextView) myDialogView.findViewById(R.id.txt_su_detail_updatingdate);
    }

    public void updateData(SchoolUpdatingData school , Context contex)
    {

     /*   RealmConfiguration realmConfig = new RealmConfiguration.Builder(contex).deleteRealmIfMigrationNeeded().build();
        Realm realm = Realm.getInstance(realmConfig);
        realm.beginTransaction();
        List<SurveyData>surveyList = realm.copyFromRealm(school.getSchoolSurveyList());
        realm.commitTransaction();*/
        List<SurveyData> surveyList = school.getSchoolSurveyList();
        txtSchoolCode.setText(school.getSchoolCode());
        txtTownship.setText(school.getTowonship());
        txtVillagename.setText(school.getVillagName());
        activityType.setText((school.getActivityType()==1)? CommonEnum.ActivityStatus.eccd.description():CommonEnum.ActivityStatus.ape.description());
        txtUpdatingDate.setText(df.format(school.getMonitoringDate()));
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
        txtDescEccdPefs.setText(surveyList.get(5).getDescription());
        txtDescEccdMcs.setText(surveyList.get(6).getDescription());
    }


}
