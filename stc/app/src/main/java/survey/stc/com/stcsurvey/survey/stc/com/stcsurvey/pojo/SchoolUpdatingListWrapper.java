package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Htet Aung Naing on 10/25/2016.
 */

public class SchoolUpdatingListWrapper implements Serializable{
    List<SchoolUpdatingData> schoolLsit;

    public List<SchoolUpdatingData> getSchoolLsit() {
        return schoolLsit;
    }

    public void setSchoolLsit(List<SchoolUpdatingData> schoolLsit) {
        this.schoolLsit = schoolLsit;
    }

    public SchoolUpdatingListWrapper()
    {
        this.schoolLsit = new ArrayList<SchoolUpdatingData>() ;
    }
}
