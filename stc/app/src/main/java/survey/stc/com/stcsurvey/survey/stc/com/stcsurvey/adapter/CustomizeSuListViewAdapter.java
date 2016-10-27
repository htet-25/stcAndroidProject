package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import survey.stc.com.stcsurvey.R;
import survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.pojo.SchoolUpdatingData;

/**
 * Created by Htet Aung Naing on 10/21/2016.
 */

public class CustomizeSuListViewAdapter extends  ArrayAdapter<SchoolUpdatingData>{

    Context contex;

    public CustomizeSuListViewAdapter(Context context,   List<SchoolUpdatingData> schoolList) {

        super(context, R.layout.customize_su_list_view_layout,  schoolList);
        contex = context;
        notifyDataSetChanged();

    }



    @NonNull
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {


            LayoutInflater inflater = ((Activity) contex).getLayoutInflater();
            View row = inflater.inflate(R.layout.customize_su_list_view_layout,null);
            TextView txtViewNo = (TextView) row.findViewById(R.id.txtViewNum);
            TextView txtSchoolCode = (TextView) row.findViewById(R.id.txt_view_su_code);
            ImageView imgInfo = (ImageView) row.findViewById(R.id.img_su_info);



        final SchoolUpdatingData school = getItem(position);
        if(school != null)
        {
            txtViewNo.setText(position+1+".");
            txtSchoolCode.setText(school.getSchoolCode()+" ("+school.getTowonship()+")");
            imgInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    SchoolUpdatingCustomizeDialog customizeDialog = new SchoolUpdatingCustomizeDialog(contex,school.getId());
                    customizeDialog.show();
                }
            });
        }

        return row;
    }
}
