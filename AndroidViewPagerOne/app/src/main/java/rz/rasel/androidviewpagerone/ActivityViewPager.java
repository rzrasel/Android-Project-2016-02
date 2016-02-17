package rz.rasel.androidviewpagerone;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityViewPager extends AppCompatActivity {
    //|------------------------------------|
    private ViewPager sysViewPager;
    private ToolsPagerAdapter adapterViewPager;
    private List<ResPageItem> dataModelViewPager = new ArrayList<ResPageItem>();

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //|------------------------------------|
        sysViewPager = (ViewPager) findViewById(R.id.sysViewPager);
        //|------------------------------------|
        dataModelViewPager.add(funGetSetModelData(R.drawable.image_001));
        dataModelViewPager.add(funGetSetModelData(R.drawable.image_002));
        dataModelViewPager.add(funGetSetModelData(R.drawable.image_003));
        dataModelViewPager.add(funGetSetModelData(R.drawable.image_004));
        dataModelViewPager.add(funGetSetModelData(R.drawable.image_005));
        //|------------------------------------|
        adapterViewPager = new ToolsPagerAdapter(this, dataModelViewPager);
        sysViewPager.setAdapter(adapterViewPager);
        sysViewPager.setCurrentItem(0);
        //|------------------------------------|
        /*sysViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int index) {
                Log.v("onPageSelected", String.valueOf(index));
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // Log.v("onPageScrolled", "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Log.v("onPageScrollStateChanged", String.valueOf(state));

                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    int index = sysViewPager.getCurrentItem();
                    if (index == 0)
                        sysViewPager.setCurrentItem(adapterViewPager.getCount() - 2 * 0, false);
                    else if (index == adapterViewPager.getCount() - 1)
                        sysViewPager.setCurrentItem(1, false);
                }
            }
        });*/
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public ResPageItem funGetSetModelData(int argResImageId) {
        return new ResPageItem(argResImageId);
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}