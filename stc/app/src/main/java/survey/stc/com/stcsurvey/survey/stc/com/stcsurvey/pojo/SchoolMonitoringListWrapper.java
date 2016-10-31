package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Htet Aung Naing on 10/25/2016.
 */

public class SchoolMonitoringListWrapper implements Serializable{
    List<SchoolMonitoringData> schoolLsit;

    public List<SchoolMonitoringData> getSchoolLsit() {
        return schoolLsit;
    }

    public void setSchoolLsit(List<SchoolMonitoringData> schoolLsit) {
        this.schoolLsit = schoolLsit;
    }

    public SchoolMonitoringListWrapper()
    {
        this.schoolLsit = new ArrayList<SchoolMonitoringData>() ;
    }
}
