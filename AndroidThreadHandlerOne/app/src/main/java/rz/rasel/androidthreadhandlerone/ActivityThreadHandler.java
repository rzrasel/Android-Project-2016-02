package rz.rasel.androidthreadhandlerone;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class ActivityThreadHandler extends AppCompatActivity {
    //|------------------------------------|
    private Handler mainUIHandler;
    private Handler threadHandler;
    //|------------------------------------|
    private TextView sysTxtHandlerMsg;
    private TextView sysTxtThreadMsg;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_handler);
        //|------------------------------------|
        sysTxtHandlerMsg = (TextView) findViewById(R.id.sysTxtHandlerMsg);
        sysTxtThreadMsg = (TextView) findViewById(R.id.sysTxtThreadMsg);
        sysTxtHandlerMsg.setMovementMethod(new ScrollingMovementMethod());
        sysTxtThreadMsg.setMovementMethod(new ScrollingMovementMethod());
        //|------------------------------------|
        Thread myThread = new Thread(uiRunnable);
        myThread.start();
        //uiThread.start();
        //threadHandler.sendMessage(threadHandler.obtainMessage());
        /*Message message = threadHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putString("run_msg", "from on click of button");
        message.setData(bundle);
        threadHandler.sendMessage(message);*/
        uiThread.start();
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private Handler uiHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //http://stackoverflow.com/questions/1921514/how-to-run-a-runnable-thread-in-android
            if (msg.what == 1) {
                Bundle bundle = msg.getData();
                String string = bundle.getString("key");
                //TextView myTextView = (TextView)findViewById(R.id.textView1);
                //myTextView.setText(string);
                System.out.println("RZ_MSG:- Handler " + string);
                //sysTxtHandlerMsg.setText(string);
                scrollMessage(sysTxtHandlerMsg, string);
                this.postDelayed(uiRunnable, 200);
            }
            if (msg.what == 2) {
                Bundle bundle = msg.getData();
                String string = bundle.getString("key");
                //TextView myTextView = (TextView)findViewById(R.id.textView1);
                //myTextView.setText(string);
                System.out.println("RZ_MSG:- Handler " + string);
                //sysTxtHandlerMsg.setText(string);
                scrollMessage(sysTxtThreadMsg, string);
                this.postDelayed(uiThread, 150);
            }
            if (threadHandler != null) {
                Message message = threadHandler.obtainMessage();
                Bundle bundle = new Bundle();
                bundle.putString("run_msg", "from on click of button");
                message.setData(bundle);
                threadHandler.sendMessage(message);
            }
            //uiHandler
        }
    };
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private Runnable uiRunnable = new Runnable() {
        //|------------------------------------|
        public void run() {
            //|------------------------------------|
            /*Message message = uiHandler.obtainMessage();
            Bundle bundle = new Bundle();
            SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
            String dateString = dateformat.format(new Date());
            bundle.putString("key", dateString);
            //specify the type of message
            message.what = 1;
            message.setData(bundle);
            uiHandler.sendMessage(message);*/
            //|------------------------------------|
            //Looper.prepare();
            /*threadHandler = new Handler() {

                @Override
                public void handleMessage(Message msg) {
                    // TODO Auto-generated method stub
                    Bundle bundle = msg.getData();
                    String string = bundle.getString("run_msg");
                    System.out.println("RZ_MSG:- Thread " + string);
                    //sysTxtHandlerMsg.append(string + "\n");
                    //Toast.makeText(getApplicationContext(), bundle.getString("hello_msg"), Toast.LENGTH_SHORT).show();
                    try {
                        // Perform some task that need to be updated to UI
                        // thread after completion
                        //Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };*/
            if (uiHandler != null) {
                /*Message message = mainUIHandler.obtainMessage();
                message.obj = new Random().nextInt(100);
                mainUIHandler.sendMessage(message);*/
                Message message = uiHandler.obtainMessage();
                Bundle bundleMsg = new Bundle();
                SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
                String dateString = dateformat.format(new Date());
                bundleMsg.putString("key", dateString);
                //specify the type of message
                message.what = 1;
                message.setData(bundleMsg);
                uiHandler.sendMessage(message);
            }
            // Run the message queue in this thread call Looper.loop()
            //Looper.loop();
            //|------------------------------------|
        }
        //|------------------------------------|
    };

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    Thread uiThread = new Thread() {
        public void run() {
            //Looper.prepare();

            // In this thread we create a handler which is associated with this thread
            //    thus, everything executed by this handler is executed on this separate thread
            //    and as a result, we are not blocking the UI thread
            /*try{
                //task to be done
                uiHandler.postDelayed(this, 0);
            }
            catch (Exception e) {
                // TODO: handle exception
            }
            threadHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    *//*Message message = uiHandler.obtainMessage();
                    Bundle bundleMsg = new Bundle();
                    SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
                    String dateString = dateformat.format(new Date());
                    bundleMsg.putString("key", dateString);
                    //specify the type of message
                    message.what = 1;
                    message.setData(bundleMsg);
                    uiHandler.sendMessage(message);*//*
                    Bundle bundle = msg.getData();
                    String string = bundle.getString("run_msg");
                    scrollMessage(sysTxtThreadMsg, string);
                    try {
                        //Thread.sleep(1000);
                    } catch (Exception e) {
                        Log.v("Error: ", e.toString());
                        scrollMessage(sysTxtThreadMsg, e.toString());
                    }
                }
            };*/
            Message message = uiHandler.obtainMessage();
            Bundle bundleMsg = new Bundle();
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");
            String dateString = dateFormat.format(new Date());
            bundleMsg.putString("key", dateString);
            //specify the type of message
            message.what = 2;
            message.setData(bundleMsg);
            uiHandler.sendMessage(message);
            //Looper.loop();
        }
    };

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void scrollMessage(TextView argTextView, String msg) {
        //http://stackoverflow.com/questions/3506696/auto-scrolling-textview-in-android-to-bring-text-into-view
        argTextView.append(msg + "\n");
        String string = argTextView.getText().toString();
        // find the amount we need to scroll.  This works by
        // asking the TextView's internal layout for the position
        // of the final line and then subtracting the TextView's height
        try {
            int scrollAmount = argTextView.getLayout().getLineTop(argTextView.getLineCount()) - argTextView.getHeight();
            // if there is no need to scroll, scrollAmount will be <=0
            if (scrollAmount > 0)
                argTextView.scrollTo(0, scrollAmount);
            else
                argTextView.scrollTo(0, 0);
        } catch (Exception e) {
            //
        }
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private int mDelay = 1000;
    public void threadTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(mDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //Get the Img
                //mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.smileimg);

                //Post a new Runnable(some work) to the UI thread

                sysTxtThreadMsg.post(new Runnable() {
                    @Override
                    public void run() {
                        //mImageView.setImageBitmap(mBitmap);
                    }
                });

            }
        }).start();
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}