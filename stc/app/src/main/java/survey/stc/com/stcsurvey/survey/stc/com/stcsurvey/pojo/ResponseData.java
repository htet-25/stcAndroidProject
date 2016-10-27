package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Htet Aung Naing on 10/27/2016.
 */

public class ResponseData implements Serializable{
    ArrayList<String> saveScCodeList;
    ArrayList<String> errorScCodeList;
    boolean serverError;

    public ArrayList<String> getSaveScCodeList() {
        return saveScCodeList;
    }

    public void setSaveScCodeList(ArrayList<String> saveScCodeList) {
        this.saveScCodeList = saveScCodeList;
    }

    public ArrayList<String> getErrorScCodeList() {
        return errorScCodeList;
    }

    public void setErrorScCodeList(ArrayList<String> errorScCodeList) {
        this.errorScCodeList = errorScCodeList;
    }

    public boolean isServerError() {
        return serverError;
    }

    public void setServerError(boolean serverError) {
        this.serverError = serverError;
    }

    public ResponseData()
    {
        this.errorScCodeList = new ArrayList<>();
        this.saveScCodeList = new ArrayList<>();
        this.serverError = false;
    }
}
