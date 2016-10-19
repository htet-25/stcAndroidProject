package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.retrofit.UserRetrofitInterface;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.User;

/**
 * Created by Htet Aung Naing on 10/15/2016.
 */

public class TestActivity extends AppCompatActivity {

    Button btn;
    User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        btn = (Button) findViewById(R.id.tstBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://128.199.132.190:8080/stcEdu/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                UserRetrofitInterface loginInterface = retrofit.create(UserRetrofitInterface.class);
                Call<User> userCall = loginInterface.getUser("admin","root");
                userCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        user = new User();
                        user = response.body();
                        Toast.makeText(getApplicationContext(),"user",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"user",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
