package rz.rasel.androidlazyloadinglistviewone;

import android.widget.ProgressBar;

/**
 * Created by nextdot on 2/23/16.
 */
public class LstItmModelLazyLoading {
    //|------------------------------------|
    private String headline;
    private String reporterName;
    private String date;
    private String url;
    private ProgressBar progressBar;
    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    public String getUrl() {
        return url;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setUrl(String url) {
        this.url = url;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public String getHeadline() {
        return headline;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public String getReporterName() {
        return reporterName;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public String getDate() {
        return date;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setDate(String date) {
        this.date = date;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public ProgressBar getProgressBar() {
        return this.progressBar;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void setProgressBar(ProgressBar pb) {
        this.progressBar = pb;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    public String toString() {
        return "[ headline=" + headline + ", reporter Name=" + reporterName + " , date=" + date + "]";
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}