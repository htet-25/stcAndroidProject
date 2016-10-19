package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Htet Aung Naing on 10/17/2016.
 */

public class SurveyData implements Serializable {

    String label;
    int malecount;
    int femalecount;
    int id;
    String createdUserName;
    int parentid;
    int typeId;
    String modifiedUserName;
    Date modifiedDate;
    Date createdDate;
    Integer addnewMaleCount;
    Integer addnewFemaleCount;
    String description;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getMalecount() {
        return malecount;
    }

    public void setMalecount(int malecount) {
        this.malecount = malecount;
    }

    public int getFemalecount() {
        return femalecount;
    }

    public void setFemalecount(int femalecount) {
        this.femalecount = femalecount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getModifiedUserName() {
        return modifiedUserName;
    }

    public void setModifiedUserName(String modifiedUserName) {
        this.modifiedUserName = modifiedUserName;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getAddnewMaleCount() {
        return addnewMaleCount;
    }

    public void setAddnewMaleCount(Integer addnewMaleCount) {
        this.addnewMaleCount = addnewMaleCount;
    }

    public Integer getAddnewFemaleCount() {
        return addnewFemaleCount;
    }

    public void setAddnewFemaleCount(Integer addnewFemaleCount) {
        this.addnewFemaleCount = addnewFemaleCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SurveyData()
    {
        this.femalecount = 0;
        this.malecount = 0;
        this.label = "";
        this.parentid = 0 ;
        this.id = 0 ;
        this.typeId = 0;
        this.createdUserName = "";
        this.modifiedUserName = "";
        this.addnewFemaleCount = 0;
        this.addnewMaleCount = 0;
        this.description = "";
    }
}
