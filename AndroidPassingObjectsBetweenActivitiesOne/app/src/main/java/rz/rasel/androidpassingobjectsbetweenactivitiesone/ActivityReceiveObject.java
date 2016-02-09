package rz.rasel.androidpassingobjectsbetweenactivitiesone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityReceiveObject extends AppCompatActivity {
    //|------------------------------------|
    private RzSendObjectToActivity rzSendObjectToActivity;
    private TextView sysLblInfo;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_object);
        //|------------------------------------|
        rzSendObjectToActivity = (RzSendObjectToActivity) getIntent().getSerializableExtra("rzObjectToActivity");
        //|------------------------------------|
        sysLblInfo = (TextView) findViewById(R.id.sysLblInfo);
        //|------------------------------------|
        System.out.println("RZ_MSG:- (ActivityReceiveObject) Name: " + rzSendObjectToActivity.getName() + " Serial ID: " + rzSendObjectToActivity.getSerialUID());
        sysLblInfo.setText("Name: " + rzSendObjectToActivity.getName() + "\nSerial ID: " + rzSendObjectToActivity.getSerialUID());
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}