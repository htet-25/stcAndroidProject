package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.Date;


import io.realm.RealmObject;

public class SchoolHistoryData extends RealmObject implements Serializable{


	
	int id;
	int parentid;
	String label;
	int typeid;
	int maleCount;
	int femaleCount;
	String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	Date monitoringDate;
	String modifiedUser;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getMaleCount() {
		return maleCount;
	}
	public void setMaleCount(int maleCount) {
		this.maleCount = maleCount;
	}
	public int getFemaleCount() {
		return femaleCount;
	}
	public void setFemaleCount(int femaleCount) {
		this.femaleCount = femaleCount;
	}

	public Date getMonitoringDate() {
		return monitoringDate;
	}
	public void setMonitoringDate(Date monitoringDate) {
		this.monitoringDate = monitoringDate;
	}
	public SchoolHistoryData()
	{
		this.femaleCount = 0;
		this.id = 0 ;
		this.parentid = 0 ;
		this.label = "";
		this.maleCount= 0 ;
		this.typeid = 0;
		this.modifiedUser = "";
		this.date = "";
	}

}
