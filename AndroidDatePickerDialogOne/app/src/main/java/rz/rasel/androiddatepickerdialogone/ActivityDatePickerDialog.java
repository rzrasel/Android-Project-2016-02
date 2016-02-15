package rz.rasel.androiddatepickerdialogone;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityDatePickerDialog extends AppCompatActivity {
    //|------------------------------------|
    private Button sysOnClickBtnSetDate;
    private TextView sysTxtViewDate;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private Calendar datePickerCalendar;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);
        //|------------------------------------|
        sysOnClickBtnSetDate = (Button) findViewById(R.id.sysOnClickBtnSetDate);
        sysTxtViewDate = (TextView) findViewById(R.id.sysTxtViewDate);
        //|------------------------------------|
        simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        //|------------------------------------|
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        sysTxtViewDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(mDay).append("-").append(funGetMonthName(mMonth + 1)).append("-")
                .append(mYear).append(" "));
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnSetDate(View view) {
        //|------------------------------------|
        datePickerCalendar = Calendar.getInstance();
        //|------------------------------------|
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //|------------------------------------|
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                sysTxtViewDate.setText(simpleDateFormat.format(newDate.getTime()));
                //|------------------------------------|
            }

        }, datePickerCalendar.get(Calendar.YEAR), datePickerCalendar.get(Calendar.MONTH), datePickerCalendar.get(Calendar.DAY_OF_MONTH));
        //|------------------------------------|
        datePickerDialog.setTitle("Select Date");
        datePickerDialog.show();
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public String funGetMonthName(int argNumOfMonth) {
        String retVal = null;
        String monthName = "";
        if (argNumOfMonth == 1) {
            retVal = "January";
        } else if (argNumOfMonth == 2) {
            retVal = "February";
        } else if (argNumOfMonth == 3) {
            retVal = "March";
        } else if (argNumOfMonth == 4) {
            retVal = "April";
        } else if (argNumOfMonth == 5) {
            retVal = "May";
        } else if (argNumOfMonth == 6) {
            retVal = "June";
        } else if (argNumOfMonth == 7) {
            retVal = "July";
        } else if (argNumOfMonth == 8) {
            retVal = "August";
        } else if (argNumOfMonth == 9) {
            retVal = "September";
        } else if (argNumOfMonth == 10) {
            retVal = "October";
        } else if (argNumOfMonth == 11) {
            retVal = "November";
        } else if (argNumOfMonth == 12) {
            retVal = "December";
        }
        retVal = retVal.substring(0, 3);
        return retVal;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnSetDateNew(View view) {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        sysTxtViewDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
        dpd.show();
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}