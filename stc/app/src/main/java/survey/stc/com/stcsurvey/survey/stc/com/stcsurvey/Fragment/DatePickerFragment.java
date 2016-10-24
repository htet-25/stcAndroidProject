package survey.stc.com.stcsurvey.survey.stc.com.stcsurvey.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Htet Aung Naing on 10/19/2016.
 */

public  class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    Button btnDate;
    Date updatingDate;
    public DatePickerFragment(Button btnDate , Date updatingDate) {
        this.btnDate = btnDate;
        this.updatingDate = updatingDate;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        btnDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        updatingDate = calendar.getTime();

    }
}