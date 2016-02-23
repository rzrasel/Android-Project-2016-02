package rz.rasel.androidlazyloadinglistviewone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nextdot on 2/23/16.
 */
public class ArrayAdapterLazyLoading extends ArrayAdapter<LstItmModelLazyLoading> {
    //|------------------------------------|
    private Context context;
    private List<LstItmModelLazyLoading> listData;
    private int layoutResourceId;
    private LayoutInflater layoutInflater;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public ArrayAdapterLazyLoading(Context argContext, int argLayoutResourceId, List<LstItmModelLazyLoading> argListData) {
        super(argContext, argLayoutResourceId, argListData);
        this.listData = argListData;
        this.context = argContext;
        this.layoutResourceId = argLayoutResourceId;
        //layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutInflater = LayoutInflater.from(argContext);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    public int getCount() {
        return listData.size();
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    public long getItemId(int position) {
        return position;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //View view = null;
        if (convertView == null) {
            //|------------------------------------|
            /*
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.list_layout, null);
            */
            //|------------------------------------|
            convertView = layoutInflater.inflate(layoutResourceId, null);
            holder = new ViewHolder();
            holder.sysLblTitle = (TextView) convertView.findViewById(R.id.sysLblTitle);
            holder.sysLblReporter = (TextView) convertView.findViewById(R.id.sysLblReporter);
            holder.sysLblDate = (TextView) convertView.findViewById(R.id.sysLblDate);
            holder.sysImgViewThumb = (ImageView) convertView.findViewById(R.id.sysImgViewThumb);
            holder.sysImgViewThumb.setVisibility(View.GONE);
            holder.sysProgBar = (ProgressBar) convertView.findViewById(R.id.sysProgBar);
            convertView.setTag(holder);

        } else {
            //view = convertView;
            holder = (ViewHolder) convertView.getTag();
        }
        //ViewHolder holder = (ViewHolder) view.getTag();

        LstItmModelLazyLoading lstItemData = listData.get(position);
        holder.sysLblTitle.setText(lstItemData.getHeadline());
        holder.sysLblReporter.setText("By, " + lstItemData.getReporterName());
        holder.sysLblDate.setText(lstItemData.getDate());

        holder.sysImgViewThumb.setTag(lstItemData.getUrl().toString());
        holder.sysImgViewThumb.setId(position);

        if (holder.sysImgViewThumb != null) {
            ProgressBarAndImage pb_and_image = new ProgressBarAndImage();
            pb_and_image.setImg(holder.sysImgViewThumb);
            pb_and_image.setPb(holder.sysProgBar);
            //new AscTaskDownloadImage(holder.sysImgViewThumb).execute(lstItemData.getUrl());
            new AscTaskDownloadImage().execute(pb_and_image);
        }
        return convertView;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    static class ViewHolder {
        TextView sysLblTitle;
        TextView sysLblReporter;
        TextView sysLblDate;
        ImageView sysImgViewThumb;
        ProgressBar sysProgBar;
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}