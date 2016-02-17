package rz.rasel.androidgetlistofinstalledapplicationsone;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ActivityListOfInstalledApps extends AppCompatActivity {
    //|------------------------------------|
    private TextView sysLblPackageData;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_installed_apps);
        //|------------------------------------|
        sysLblPackageData = (TextView) findViewById(R.id.sysLblPackageData);
        sysLblPackageData.setMovementMethod(new ScrollingMovementMethod());
        //|------------------------------------|
        new RzInstalledAppList(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //initTestOne();
                //Toast.makeText(getApplicationContext(), getRandomInRange(4, 10) + "", Toast.LENGTH_LONG).show();
                System.out.println("RZ_MSG:- Random:- " + getRandomInRange(4, 10));
                Log.d("RZ_MSG: ", "Random:- " + getRandomInRange(4, 10));
            }
        }).start();
        //|------------------------------------|
    }

    public int getRandomInRange(int argMinVal, int argMaxVal) {
        if (argMinVal > argMaxVal) {
            int tempVal = argMaxVal;
            argMaxVal = argMinVal;
            argMinVal = tempVal;
        }
        Random random = new Random();
        int retVal = random.nextInt(argMaxVal - argMinVal + 1) + argMinVal;
        return retVal;
    }

    public void initTestOne() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASE");
        intent.setClassName("com.android.vending", "rz.rasel.recipeenglish.ActivitySplash");
        //intent.putExtra(EXTRA_NAME, EXTRA_VALUE);
        startActivityForResult(intent, 0);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public class RzInstalledAppList {
        private Context context;
        private PackageManager packageManager = null;
        private List<ApplicationInfo> applist = null;

        //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
        public RzInstalledAppList(Context argContext) {
            this.context = argContext;
            packageManager = argContext.getPackageManager();
            new RzLoadApplications().execute();
        }

        //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
        private class RzLoadApplications extends AsyncTask<Void, Void, List<ApplicationInfo>> {
            private ProgressDialog progress = null;

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            @Override
            protected List<ApplicationInfo> doInBackground(Void... params) {
                applist = checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
                //Collections.sort(applist);
                return applist;
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            @Override
            protected void onCancelled() {
                super.onCancelled();
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            @Override
            protected void onPostExecute(List<ApplicationInfo> result) {
                //setListAdapter(listadaptor);
                /*Iterator<ApplicationInfo> iterator = result.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }*/
                //Collections.sort(result);
                int counter = 0;
                for (ApplicationInfo list : result) {
                    counter++;
                    ApplicationInfo applicationInfo = list;
                    System.out.println("RZ_MSG:- Application Info:- " + applicationInfo.packageName);
                    sysLblPackageData.append(counter + ") " + applicationInfo.loadLabel(packageManager) + "\n");
                    sysLblPackageData.append("\t" + applicationInfo.packageName + "\n");
                    if (counter == 1) {
                        //packageManager.getLaunchIntentForPackage(applicationInfo.packageName);
                        launchApp(applicationInfo.packageName);
                    }
                    //iconview.setImageDrawable(applicationInfo.loadIcon(packageManager));
                }
                progress.dismiss();
                super.onPostExecute(result);
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            @Override
            protected void onPreExecute() {
                progress = ProgressDialog.show(context, null, "Loading application info...");
                super.onPreExecute();
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list) {
                ArrayList<ApplicationInfo> applist = new ArrayList<ApplicationInfo>();
                for (ApplicationInfo info : list) {
                    try {
                        if (null != packageManager.getLaunchIntentForPackage(info.packageName)) {
                            applist.add(info);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return applist;
            }

            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
            protected void launchApp(String packageName) {
                Intent mIntent = getPackageManager().getLaunchIntentForPackage(
                        packageName);
                if (mIntent != null) {
                    try {
                        startActivity(mIntent);
                    } catch (ActivityNotFoundException e) {
                        /*Toast toast = Toast.makeText(getApplicationContext(), R.string.app_not_found, Toast.LENGTH_SHORT);
                        toast.show();*/
                        System.out.println("RZ_MSG_ERROR:- " + e.getMessage().toString());
                    }
                }
            }
            //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
        }
        //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}