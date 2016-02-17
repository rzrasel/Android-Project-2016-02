package rz.rasel.androidcameraorgalleryphotoone;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ActivityTakePhotoOne extends AppCompatActivity {
    //|------------------------------------|
    private static final int IMAGE_PICK = 1;
    private static final int IMAGE_CAPTURE = 2;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    //|------------------------------------|
    private ImageView sysImageViewShowPhoto;

    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_photo_one);
        //|------------------------------------|
        sysImageViewShowPhoto = (ImageView) findViewById(R.id.sysImageViewShowPhoto);
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void onClickBtnPhotoFromGallery(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void onClickBtnPhotoFromCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //http://tscolari.me/2011/10/10/android-camera-and-image-gallery/
        //https://github.com/theappguruz/Android-Take-Photo-From-Camera-and-Gallery-Code-Sample
        //----http://stackoverflow.com/questions/29262509/show-four-button-in-same-line-without-any-space-between-them/29262672
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onImageSelectFromGalleryResult(resultCode, data);
            else if (requestCode == REQUEST_CAMERA)
                onImageCameraCaptureResult(resultCode, data);
        }
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void onImageCameraCaptureResult(int resultCode, Intent data) {
        //this.imageView.setImageBitmap((Bitmap) data.getExtras().get("data"));
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        bitmapSaveToSdCard(thumbnail);
        sysImageViewShowPhoto.setImageBitmap(thumbnail);
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|

    /**
     * Image result from gallery * @param resultCode * @param data
     */
    private void onImageSelectFromGalleryResult(int resultCode, Intent data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();
        sysImageViewShowPhoto.setImageBitmap(BitmapFactory.decodeFile(filePath));
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    private void bitmapSaveToSdCard(Bitmap argSourceBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        //argSourceBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        argSourceBitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(), "rz_rasel_"+System.currentTimeMillis() + ".png");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}