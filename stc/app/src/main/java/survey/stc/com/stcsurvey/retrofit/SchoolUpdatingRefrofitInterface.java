package survey.stc.com.stcsurvey.retrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.ResponseData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingListWrapper;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/24/2016.
 */

public interface SchoolUpdatingRefrofitInterface {

  /*  @POST("stc/api/schoolapi/insert/")
    Call<String> uploadSchoolListtToserver(@Body List<SchoolUpdatingData> schoolList);*/

    @POST("stc/api/schoolupdating/insert/")
    Call<ResponseData> uploadSchoolListtToserver(@Body SchoolUpdatingListWrapper schoolList);


}
