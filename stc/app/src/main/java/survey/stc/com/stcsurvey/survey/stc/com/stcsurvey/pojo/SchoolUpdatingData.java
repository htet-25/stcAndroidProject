package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import io.realm.RealmList;
import io.realm.RealmObject;

public class SchoolUpdatingData extends RealmObject implements Serializable{


	
	String schoolCode;
	String towonship;
	String  villagName;
	int activityType;
	Date monitoringDate;
	Date createdDate;
	Date modifiedDate;
	String moniDate;
	String createdUsername;
	String modifiedUsername;
	int recordStatus;
	int id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	String activityLabel;
	String description;
	public RealmList<SurveyData> schoolSurveyList;

	
	public String getActivityLabel() {
		return activityLabel;
	}
	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}
	
	public String getMoniDate() {
		return moniDate;
	}
	public void setMoniDate(String moniDate) {
		this.moniDate = moniDate;
	}

	public RealmList<SurveyData> getSchoolSurveyList() {
		return schoolSurveyList;
	}

	public void setSchoolSurveyList(RealmList<SurveyData> schoolSurveyList) {
		this.schoolSurveyList = schoolSurveyList;
	}

	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getTowonship() {
		return towonship;
	}
	public void setTowonship(String towonship) {
		this.towonship = towonship;
	}
	public String getVillagName() {
		return villagName;
	}
	public void setVillagName(String villagName) {
		this.villagName = villagName;
	}
	public int getActivityType() {
		return activityType;
	}
	public void setActivityType(int activityType) {
		this.activityType = activityType;
	}
	public Date getMonitoringDate() {
		return monitoringDate;
	}
	public void setMonitoringDate(Date monitoringDate) {
		this.monitoringDate = monitoringDate;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedUsername() {
		return createdUsername;
	}
	public void setCreatedUsername(String createdUsername) {
		this.createdUsername = createdUsername;
	}
	public String getModifiedUsername() {
		return modifiedUsername;
	}
	public void setModifiedUsername(String modifiedUsername) {
		this.modifiedUsername = modifiedUsername;
	}
	public int getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(int recordStatus) {
		this.recordStatus = recordStatus;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public SchoolUpdatingData()
	{
		Calendar calendar = Calendar.getInstance();
	     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
	     
		this.activityType = 0 ;
		this.monitoringDate = startDate;
		this.schoolCode = "";
		this.towonship = "";
		this.villagName = "";
		this.schoolSurveyList = new RealmList<>();
		this.createdDate = startDate;
		this.modifiedDate=startDate;
		this.createdUsername = "";
		this.modifiedUsername = "";
		this.id = 0;
		this.recordStatus = 1;
		this.activityLabel = "";
		this.moniDate = "";
		this.description = "";
	}
	

}
