package com.example.huzhouocr;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class OCRActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView selectCamera,resultView;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocr);

        init();
    }

    private void init() {

        selectCamera = findViewById(R.id.camera);
        resultView = findViewById(R.id.result_image);

        selectCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.camera:
                sCamera();
                break;

            default:
        }

    }

    private void sCamera() {

        //camera code here
        CropImage.startPickImageActivity(OCRActivity.this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri imageUri = CropImage.getPickImageResultUri(this,data);
            if (CropImage.isReadExternalStoragePermissionsRequired(this,imageUri)){
                uri = imageUri;
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
            }else{
                startCrop(imageUri);
            }
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){
                resultView.setImageURI(result.getUri());
                Toast.makeText(this,"Image update Successfully",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startCrop(Uri imageUri) {

        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(this);
    }
}
