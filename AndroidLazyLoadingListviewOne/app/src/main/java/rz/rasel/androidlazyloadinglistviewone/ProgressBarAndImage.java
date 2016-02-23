package rz.rasel.androidlazyloadinglistviewone;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by nextdot on 2/23/16.
 */
public class ProgressBarAndImage {
    private ImageView imageView;
    private ProgressBar progressBar;

    public ImageView getImg() {
        return imageView;
    }

    public void setImg(ImageView argImageView) {
        this.imageView = argImageView;
    }

    public ProgressBar getPb() {
        return progressBar;
    }

    public void setPb(ProgressBar argProgressBar) {
        this.progressBar = argProgressBar;
    }
}