package rz.rasel.androidpassingobjectsbetweenactivitiesone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySplash extends AppCompatActivity {
    //|------------------------------------|
    private RzSendObjectToActivity rzSendObjectToActivity;
    private TextView sysLblInfo;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //|------------------------------------|
        rzSendObjectToActivity = new RzSendObjectToActivity();
        rzSendObjectToActivity.setName("Rz Rasel");
        rzSendObjectToActivity.setSerialUID(1l);
        //|------------------------------------|
        sysLblInfo = (TextView) findViewById(R.id.sysLblInfo);
        //|------------------------------------|
        System.out.println("RZ_MSG:- (ActivitySplash) Name: " + rzSendObjectToActivity.getName() + " Serial ID: " + rzSendObjectToActivity.getSerialUID());
        sysLblInfo.setText("Name: " + rzSendObjectToActivity.getName() + "\nSerial ID: " + rzSendObjectToActivity.getSerialUID());
        //|------------------------------------|
        Intent intent = new Intent(getApplicationContext(), ActivityReceiveObject.class);
        intent.putExtra("rzObjectToActivity", rzSendObjectToActivity);
        startActivity(intent);
        finish();
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}