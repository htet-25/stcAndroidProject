package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;


public class SchoolMonitoringData extends RealmObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5240403358266000204L;
	String schoolCode;
	String towonship;
	String  villagName;
	int activityType;
	Date monitoringDate;
	Date createdDate;
	Date modifiedDate;
	Date establishDate;
	String buildingsize;
	String  compundSize;
	int frequencyMeetingType;
	String  frequencyMeetinglbl;
	String moniDate;
	String createdUsername;
	String modifiedUsername;
	String estabalDate;
	int noOfToilet;
	int getWater;
	double generalExpense;
	double totalexpense;
	double monthlyBalance;

	public RealmList<SchoolHistoryData> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(RealmList<SchoolHistoryData> historyList) {
		this.historyList = historyList;
	}

	RealmList<SchoolHistoryData> historyList;
	
	public double getGeneralExpense() {
		return generalExpense;
	}
	public void setGeneralExpense(double generalExpense) {
		this.generalExpense = generalExpense;
	}
	public double getTotalexpense() {
		return totalexpense;
	}
	public void setTotalexpense(double totalexpense) {
		this.totalexpense = totalexpense;
	}
	public double getMonthlyBalance() {
		return monthlyBalance;
	}
	public void setMonthlyBalance(double monthlyBalance) {
		this.monthlyBalance = monthlyBalance;
	}
	public int getNoOfToilet() {
		return noOfToilet;
	}
	public void setNoOfToilet(int noOfToilet) {
		this.noOfToilet = noOfToilet;
	}
	public int getGetWater() {
		return getWater;
	}
	public void setGetWater(int getWater) {
		this.getWater = getWater;
	}
	public String getEstabalDate() {
		return estabalDate;
	}
	public void setEstabalDate(String estabalDate) {
		this.estabalDate = estabalDate;
	}

	int recordStatus;
	int id;
	int eccdServiceTownDistance;
	String eccdServiceTownDistancelbl;
	int eccdServiceSchoolDistace;
	String eccdServiceSchoolDistancelbl;
	String activityLabel;
	public RealmList<SchoolSupportData> supportList;
	public RealmList<SurveyData> surveyList;
	double amountrevolvingfund;
	double monthlyRevolvingFund;
	double feeFromParent;
	double otherIncome;
	double totalMonthlyIncome;
	double caregiverSalary;
	String issue;
	int completeResolve;
	int openClose;
	String minScoreOfEccdApe;
	
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
	public Date getEstablishDate() {
		return establishDate;
	}
	public void setEstablishDate(Date establishDate) {
		this.establishDate = establishDate;
	}
	public String getBuildingsize() {
		return buildingsize;
	}
	public void setBuildingsize(String buildingsize) {
		this.buildingsize = buildingsize;
	}
	public String getCompundSize() {
		return compundSize;
	}
	public void setCompundSize(String compundSize) {
		this.compundSize = compundSize;
	}
	public int getFrequencyMeetingType() {
		return frequencyMeetingType;
	}
	public void setFrequencyMeetingType(int frequencyMeetingType) {
		this.frequencyMeetingType = frequencyMeetingType;
	}
	public String getFrequencyMeetinglbl() {
		return frequencyMeetinglbl;
	}
	public void setFrequencyMeetinglbl(String frequencyMeetinglbl) {
		this.frequencyMeetinglbl = frequencyMeetinglbl;
	}
	public String getMoniDate() {
		return moniDate;
	}
	public void setMoniDate(String moniDate) {
		this.moniDate = moniDate;
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
	public int getEccdServiceTownDistance() {
		return eccdServiceTownDistance;
	}
	public void setEccdServiceTownDistance(int eccdServiceTownDistance) {
		this.eccdServiceTownDistance = eccdServiceTownDistance;
	}
	public String getEccdServiceTownDistancelbl() {
		return eccdServiceTownDistancelbl;
	}
	public void setEccdServiceTownDistancelbl(String eccdServiceTownDistancelbl) {
		this.eccdServiceTownDistancelbl = eccdServiceTownDistancelbl;
	}
	public int getEccdServiceSchoolDistace() {
		return eccdServiceSchoolDistace;
	}
	public void setEccdServiceSchoolDistace(int eccdServiceSchoolDistace) {
		this.eccdServiceSchoolDistace = eccdServiceSchoolDistace;
	}
	public String getEccdServiceSchoolDistancelbl() {
		return eccdServiceSchoolDistancelbl;
	}
	public void setEccdServiceSchoolDistancelbl(String eccdServiceSchoolDistancelbl) {
		this.eccdServiceSchoolDistancelbl = eccdServiceSchoolDistancelbl;
	}
	public String getActivityLabel() {
		return activityLabel;
	}
	public void setActivityLabel(String activityLabel) {
		this.activityLabel = activityLabel;
	}

	public RealmList<SchoolSupportData> getSupportList() {
		return supportList;
	}
	public void setSupportList(RealmList<SchoolSupportData> supportList) {
		this.supportList = supportList;
	}
	public RealmList<SurveyData> getSurveyList() {
		return surveyList;
	}
	public void setSurveyList(RealmList<SurveyData> surveyList) {
		this.surveyList = surveyList;
	}
	public double getAmountrevolvingfund() {
		return amountrevolvingfund;
	}
	public void setAmountrevolvingfund(double amountrevolvingfund) {
		this.amountrevolvingfund = amountrevolvingfund;
	}
	public double getMonthlyRevolvingFund() {
		return monthlyRevolvingFund;
	}
	public void setMonthlyRevolvingFund(double monthlyRevolvingFund) {
		this.monthlyRevolvingFund = monthlyRevolvingFund;
	}
	public double getFeeFromParent() {
		return feeFromParent;
	}
	public void setFeeFromParent(double feeFromParent) {
		this.feeFromParent = feeFromParent;
	}
	public double getOtherIncome() {
		return otherIncome;
	}
	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}
	public double getTotalMonthlyIncome() {
		return totalMonthlyIncome;
	}
	public void setTotalMonthlyIncome(double totalMonthlyIncome) {
		this.totalMonthlyIncome = totalMonthlyIncome;
	}
	public double getCaregiverSalary() {
		return caregiverSalary;
	}
	public void setCaregiverSalary(double caregiverSalary) {
		this.caregiverSalary = caregiverSalary;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public int getCompleteResolve() {
		return completeResolve;
	}
	public void setCompleteResolve(int completeResolve) {
		this.completeResolve = completeResolve;
	}
	public int getOpenClose() {
		return openClose;
	}
	public void setOpenClose(int openClose) {
		this.openClose = openClose;
	}
	public String getMinScoreOfEccdApe() {
		return minScoreOfEccdApe;
	}
	public void setMinScoreOfEccdApe(String minScoreOfEccdApe) {
		this.minScoreOfEccdApe = minScoreOfEccdApe;
	}

	public SchoolMonitoringData()
	{
		this.activityLabel="";
		this.activityType =0 ;
		this.amountrevolvingfund = 0;
		this.buildingsize =  "";
		this.caregiverSalary = 0;
		this.completeResolve = 3;
		this.compundSize = "";
		this.createdDate = new Date();
		this.createdUsername = "";
		this.eccdServiceSchoolDistace = 0 ;
		this.eccdServiceSchoolDistancelbl = "";
		this.eccdServiceTownDistance = 0 ;
		this.eccdServiceTownDistancelbl = "";
		this.establishDate = new Date();
		this.feeFromParent =  0;
		this.frequencyMeetinglbl = "";
		this.frequencyMeetingType = 0;
		this.id = 0 ;
		this.issue = "";
		this.minScoreOfEccdApe = "";
		this.modifiedDate = new Date();
		this.modifiedUsername = "";
		this.moniDate = "";
		this.monitoringDate = new Date();
		this.monthlyRevolvingFund = 0;
		this.openClose = 3;
		this.otherIncome = 0;
		this.recordStatus = 0;
		this.schoolCode = "";
		this.supportList = new RealmList<SchoolSupportData>();
		this.surveyList = new RealmList<SurveyData>();
		this.totalMonthlyIncome = 0;
		this.towonship = "";
		this.villagName = "";
		this.estabalDate = "";
		this.getWater = 3;
		this.noOfToilet = 0;
		this.generalExpense = 0;
		this.totalexpense = 0;
		this.monthlyBalance = 0;
		this.historyList = new RealmList<>();
	}

}
