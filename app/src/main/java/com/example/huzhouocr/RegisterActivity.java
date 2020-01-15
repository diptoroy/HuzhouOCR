package com.example.huzhouocr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button regBtn,sendBtn;
    private ImageView wechat,qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        init();
    }

    private void init() {

        regBtn = findViewById(R.id.regBtn);
        sendBtn = findViewById(R.id.sendBtn);

        wechat = findViewById(R.id.wechat);
        qq = findViewById(R.id.qq);

        regBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
        wechat.setOnClickListener(this);
        qq.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.regBtn:
                startActivity(new Intent(getApplicationContext(),OCRActivity.class));
                break;

            case R.id.sendBtn:
                Toast.makeText(getApplicationContext(),"Successfully Send",Toast.LENGTH_SHORT).show();
                sendBtnWork();
                break;

            case R.id.wechat:
                Toast.makeText(getApplicationContext(),"Clicked wechat",Toast.LENGTH_SHORT).show();
                wechatCode();
                break;

            case R.id.qq:
                Toast.makeText(getApplicationContext(),"Clicked qq",Toast.LENGTH_SHORT).show();
                qqCode();
                break;

            default:
        }
    }

    private void qqCode() {

        //write here qq code
    }

    private void wechatCode() {

        //write here wechat code
    }

    private void sendBtnWork() {

        //write here send button code
    }
}
