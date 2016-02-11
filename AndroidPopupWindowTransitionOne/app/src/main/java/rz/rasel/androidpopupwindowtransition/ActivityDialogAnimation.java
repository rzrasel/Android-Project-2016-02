package rz.rasel.androidpopupwindowtransition;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class ActivityDialogAnimation extends AppCompatActivity {
    //|------------------------------------|
    //|------------------------------------|
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_animation);
        //|------------------------------------|
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnLeftToRight(View view) {
        openDialog(R.style.DialogAnimLeftToRight);
        //overridePendingTransition(R.anim.enter_anim, R.anim.exit_anim);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnRightToLeft(View view) {
        openDialog(R.style.DialogAnimRightToLeft);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnTopToBottom(View view) {
        openDialog(R.style.DialogAnimTopToBottom);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnCustom(View view) {
        openDialog(R.style.DialogAnimCustom);
        //overridePendingTransition(R.anim.dialog_custom_on, R.anim.dialog_custom_off);
    }

    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
    public void sysOnClickBtnBottomToTop(View view) {
        openDialog(R.style.DialogAnimBottomTop);
    }

    private void openDialog(int agrLayoutId) {
        final Context contextDialog = this;
        final Activity activityDialog = this;
        final Dialog dialogAnimation = new Dialog(this);
        dialogAnimation.getWindow().getAttributes().windowAnimations = agrLayoutId;
        dialogAnimation.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogAnimation.setContentView(R.layout.dialog_layout);
        dialogAnimation.show();
    }
    //|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|
}
