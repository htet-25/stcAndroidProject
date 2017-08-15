package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import survey.stc.com.stcsurvey.R;

/**
 * Created by Htet Aung Naing on 10/27/2016.
 */

public class CustomizeToast {
    String toast_type = "";

    public CustomizeToast(String type)
    {
        this.toast_type = type;
    }


    public  Toast getCustomizeToast(Context context , String infotext)
    {
        Toast toast = new Toast(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout;
        if(toast_type.equals("info"))
        {
            layout = inflater.inflate(R.layout.customize_toast , null);
            TextView txtInfo = (TextView) layout.findViewById(R.id.txtInfotoast);
            txtInfo.setText(infotext);

        }else if(toast_type.equals("error"))
        {
            layout = inflater.inflate(R.layout.customize_error_toast , null);
            TextView txtInfo = (TextView) layout.findViewById(R.id.txt_error_toast);
            txtInfo.setText(infotext);
        }else if(toast_type.equals("lbl"))
        {
            layout = inflater.inflate(R.layout.customize_lbltransl_toast , null);
            TextView txtInfo = (TextView) layout.findViewById(R.id.txt_lbl_toast);
            txtInfo.setText(infotext);
        }
        else
        {
            layout = inflater.inflate(R.layout.customize_warn_toast , null);
            TextView txtInfo = (TextView) layout.findViewById(R.id.txt_error_toast);
            txtInfo.setText(infotext);
        }
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        return toast;
    }


}
