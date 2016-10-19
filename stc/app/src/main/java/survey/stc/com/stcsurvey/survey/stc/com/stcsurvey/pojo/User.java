package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;

import io.realm.RealmObject;

/**
 * Created by Htet Aung Naing on 10/13/2016.
 */

public class User extends RealmObject implements Serializable{

    public String userName;
    public String userId;
    public String rolelbl;


    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRolelbl() {
        return rolelbl;
    }

    public void setRolelbl(String rolelbl) {
        this.rolelbl = rolelbl;
    }

    public void User()
    {
        this.id = 0;
        this.rolelbl = "";
        this.userId = "";
        this.userId = "";

    }
}
