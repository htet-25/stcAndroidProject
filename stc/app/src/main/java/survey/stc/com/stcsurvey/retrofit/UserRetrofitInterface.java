package survey.stc.com.stcsurvey.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/13/2016.
 */

public interface UserRetrofitInterface {

    @GET("stc/api/userapi/login/{code}/{password}")
    Call<User> getUser(@Path("code") String code , @Path("password") String password);
}
