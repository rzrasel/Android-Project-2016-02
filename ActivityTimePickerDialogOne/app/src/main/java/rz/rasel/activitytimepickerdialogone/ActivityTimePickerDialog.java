package rz.rasel.activitytimepickerdialogone;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityTimePickerDialog extends AppCompatActivity {
    //|------------------------------------|
    private Button sysOnClickBtnSetTime;
    private TextView sysTxtViewTime;
    private TimePickerDialog timePickerDialog;
    private SimpleDateFormat simpleDateFormat;
    private Calendar timePickerCalendar;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog);
        //|------------------------------------|
        sysOnClickBtnSetTime = (Button) findViewById(R.id.sysOnClickBtnSetTime);
        sysTxtViewTime = (TextView) findViewById(R.id.sysTxtViewTime);
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnSetTime(View view) {
        //|------------------------------------|
        timePickerCalendar = Calendar.getInstance();
        /*int mHour = timePickerCalendar.HOUR;
        int mMinute = timePickerCalendar.MINUTE;*/
        int mHour = timePickerCalendar.get(Calendar.HOUR_OF_DAY);
        int mMinute = timePickerCalendar.get(Calendar.MINUTE);
        //|------------------------------------|
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                sysTxtViewTime.setText(hourOfDay + ":" + minute);
            }
        }, mHour, mMinute, false);
        //|------------------------------------|
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}