package survey.stc.com.stcsurvey.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.ResponseData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolMonitoringListWrapper;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingListWrapper;

/**
 * Created by Htet Aung Naing on 10/24/2016.
 */

public interface SchoolMonitoringRefrofitInterface {

  /*  @POST("stc/api/schoolapi/insert/")
    Call<String> uploadSchoolListtToserver(@Body List<SchoolUpdatingData> schoolList);*/

    @POST("stc/api/schoolapi/insert/")
    Call<ResponseData> uploadSchoolListtToserver(@Body SchoolMonitoringListWrapper schoolList);


}
