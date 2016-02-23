package rz.rasel.androidlazyloadinglistviewone;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ActivityLazyLoadingListView extends AppCompatActivity {
    //|------------------------------------|
    private List<LstItmModelLazyLoading> listData = new ArrayList<LstItmModelLazyLoading>();
    private ArrayAdapterLazyLoading adapterListView;
    private ListView sysLstViewLazyLoading;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_loading_list_view);
        //|------------------------------------|
        sysLstViewLazyLoading = (ListView) findViewById(R.id.sysLstViewLazyLoading);
        setDataInModel();
        adapterListView = new ArrayAdapterLazyLoading(this, R.layout.layout_lazy_loading_item, listData);
        sysLstViewLazyLoading.setAdapter(adapterListView);
        //|------------------------------------|
        sysLstViewLazyLoading.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                /*LauncherActivity.ListItem newsData = (LauncherActivity.ListItem) sysLstViewLazyLoading.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();*/
                Toast.makeText(getApplicationContext(), "Selected :" + " " + listData.get(position), Toast.LENGTH_LONG).show();
            }
        });
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setDataInModel()
    {
        //|------------------------------------|
        //List<LstItmModelLazyLoading> listMockData = new ArrayList<LstItmModelLazyLoading>();
        LstItmModelLazyLoading listMockData;
        listMockData = new LstItmModelLazyLoading();
        listMockData.setHeadline("Test Head Line");
        listMockData.setReporterName("Rz Rasel");
        listMockData.setDate("February 23, 2016, 12:35");
        listMockData.setUrl("http://androidexample.com/media/webservice/LazyListView_images/image0.png");
        listData.add(listMockData);
        //|------------------------------------|
        listMockData = new LstItmModelLazyLoading();
        listMockData.setHeadline("Test Head Line");
        listMockData.setReporterName("Rz Rasel");
        listMockData.setDate("February 23, 2016, 12:35");
        listMockData.setUrl("http://androidexample.com/media/webservice/LazyListView_images/image1.png");
        listData.add(listMockData);
        //|------------------------------------|
        listMockData = new LstItmModelLazyLoading();
        listMockData.setHeadline("Test Head Line");
        listMockData.setReporterName("Rz Rasel");
        listMockData.setDate("February 23, 2016, 12:35");
        listMockData.setUrl("http://coderzheaven.com/sample_folder/android_1.png");
        listData.add(listMockData);
        //|------------------------------------|
        listMockData = new LstItmModelLazyLoading();
        listMockData.setHeadline("Test Head Line");
        listMockData.setReporterName("Rz Rasel");
        listMockData.setDate("February 23, 2016, 12:35");
        listMockData.setUrl("http://androidexample.com/media/webservice/LazyListView_images/image2.png");
        listData.add(listMockData);
        //|------------------------------------|
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    /*public LstItmModelLazyLoading funGetSetModelData(String argSourceDest, String argPayment, String argVehicleNum, String argTripDate) {
        return new LstItmModelLazyLoading(argSourceDest, argPayment, argVehicleNum, argTripDate);
    }*/
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}
/*
Simplest Lazy Loading ListView Example in Android with data populated from a MySQL database using php
http://www.coderzheaven.com/2012/09/23/simplest-lazy-loading-listview-android-data-populated-mysql-database-php/
Loading Image Asynchronously in Android ListView
http://javatechig.com/android/loading-image-asynchronously-in-android-listview
Download Images From Web And Lazy Load In ListView - Android Example
http://androidexample.com/Download_Images_From_Web_And_Lazy_Load_In_ListView_-_Android_Example/index.php?view=article_discription&aid=112&aaid=134
Android – Asynchronous image loading in ListView
http://www.technotalkative.com/android-asynchronous-image-loading-in-listview/
Android Development Tutorial: Asynchronous Lazy Loading and Caching of ListView Images
http://www.codehenge.net/2011/06/android-development-tutorial-asynchronous-lazy-loading-and-caching-of-listview-images/
*/