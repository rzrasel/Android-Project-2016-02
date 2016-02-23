package rz.rasel.androidlazyloadinglistviewone;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by nextdot on 2/23/16.
 */
public class AscTaskDownloadImage extends AsyncTask<ProgressBarAndImage, Void, Bitmap> {
    //|------------------------------------|
    private ImageView imageView = null;
    private ProgressBar progressBar = null;
    private String requestUrl = "";
    private MemoryCache memoryCache = new MemoryCache();

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected Bitmap doInBackground(ProgressBarAndImage... params) {
        //return downloadBitmap(params[0]);
        this.imageView = (ImageView) params[0].getImg();
        this.progressBar = (ProgressBar) params[0].getPb();
        //|------------------------------------|
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                requestUrl = (String) imageView.getTag();
            }
        }).start();*/
        try {
            requestUrl = (String) imageView.getTag();
        } catch (Exception e) {
            //
        }
        Bitmap bitmap = memoryCache.get(requestUrl);
        if (bitmap == null) {
            bitmap = getBitmapDownloaded(requestUrl);
            try {
                memoryCache.put(requestUrl, bitmap);
            } catch (Throwable ex) {
                ex.printStackTrace();
                if (ex instanceof OutOfMemoryError)
                    memoryCache.clear();
            }
        }
        else
        {
            System.out.println("RZ_MSG:- Get Cache data");
        }
        //|------------------------------------|
        return bitmap;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onPostExecute(Bitmap result) {
        System.out.println(requestUrl);
        System.out.println("<span id='IL_AD2' class='IL_AD'>Downloaded</span> " + requestUrl);
        //System.out.println("<span id="IL_AD2" class="IL_AD">Downloaded</span> " + imageView.getId());
        imageView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);  // hide the progressbar after <span id="IL_AD3" class="IL_AD">downloading</span> the image.
        imageView.setImageBitmap(result); //set the bitmap to the imageview.
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    /**
     * This function downloads the image and returns the Bitmap
     **/
    private Bitmap getBitmapDownloaded(String url) {
        System.out.println("String URL " + url);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream((InputStream) new URL(url)
                    .getContent());
            bitmap = getResizedBitmap(bitmap, 50, 50);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private Bitmap downloadBitmap(String url) {
        HttpURLConnection urlConnection = null;
        try {
            URL uri = new URL(url);
            urlConnection = (HttpURLConnection) uri.openConnection();
            int statusCode = urlConnection.getResponseCode();
            //if (statusCode != HttpStatus.SC_OK) {
            if (statusCode != 200) {
                return null;
            }

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream != null) {
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        } catch (Exception e) {
            urlConnection.disconnect();
            //Log.w("ImageDownloader", "Error downloading image from " + url);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return null;
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    /**
     * decodes image and scales it to reduce memory consumption
     **/
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}