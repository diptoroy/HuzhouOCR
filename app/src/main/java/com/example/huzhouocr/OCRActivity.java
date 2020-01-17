package com.example.huzhouocr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;

public class OCRActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView selectCamera,selectGallery;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);

        init();
    }

    private void init() {

        selectCamera = findViewById(R.id.camera);
        selectGallery = findViewById(R.id.gallery);

        selectGallery.setOnClickListener(this);
        selectCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.camera:
                sCamera();
                break;

            case R.id.gallery:
                sGallery();
                break;

            default:
        }

    }

    private void sGallery() {

        //gallery code here
        CropImage.startPickImageActivity(OCRActivity.this);
    }

    private void sCamera() {

        //camera code here
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                uri = result.getUri();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
