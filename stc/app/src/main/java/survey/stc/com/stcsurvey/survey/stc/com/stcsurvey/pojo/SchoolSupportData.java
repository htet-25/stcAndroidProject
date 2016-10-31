package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import io.realm.RealmObject;

public class SchoolSupportData extends RealmObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5327108809765912324L;
	int id;
	int parentid;
	String support_lbl;
	int support_type;
	String  school_code;
	String supporter_name;


	public String getSupporter_name() {
		return supporter_name;
	}
	public void setSupporter_name(String supporter_name) {
		this.supporter_name = supporter_name;
	}
	public String getSchool_code() {
		return school_code;
	}
	public void setSchool_code(String school_code) {
		this.school_code = school_code;
	}
	public int getSupport_type() {
		return support_type;
	}
	public void setSupport_type(int support_type) {
		this.support_type = support_type;
	}

	
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


	public String getSupport_lbl() {
		return support_lbl;
	}
	public void setSupport_lbl(String support_lbl) {
		this.support_lbl = support_lbl;
	}
	public SchoolSupportData()
	{
		this.id = 0;
		this.support_lbl = "";
		this.parentid = 0;
		this.support_type = 0;
		this.school_code = "";
		this.supporter_name = "";
		
	}
	
	
}
