package com.example.huzhouocr;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtnAction,sendBtn;
    private ImageView wechat,qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {

        loginBtnAction = findViewById(R.id.loginBtnAction);
        sendBtn = findViewById(R.id.sendBtn);

        wechat = findViewById(R.id.wechat);
        qq = findViewById(R.id.qq);

        loginBtnAction.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
        wechat.setOnClickListener(this);
        qq.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.loginBtnAction:
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
