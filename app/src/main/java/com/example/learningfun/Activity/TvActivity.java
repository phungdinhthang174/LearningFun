package com.example.learningfun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.learningfun.R;
import com.example.learningfun.TVLV.TVLV2Activity;
import com.example.learningfun.TVLV.TVLV3Activity;
import com.example.learningfun.TVLV.TVLV4Activity;
import com.example.learningfun.TVLV.TVLV5Activity;
import com.example.learningfun.TVLV.TVLVActivity;

public class TvActivity extends AppCompatActivity {

    Button btnLv1,btnLV2,btnLv3,btnLv4,btnLv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        btnLv1 =  findViewById(R.id.btn_tv_lv1);
        btnLV2 =  findViewById(R.id.btn_tv_lv2);
        btnLv3 =  findViewById(R.id.btn_tv_lv3);
        btnLv4 =  findViewById(R.id.btn_tv_lv4);
        btnLv5 =  findViewById(R.id.btn_tv_lv5);

        btnLv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvActivity.this, TVLVActivity.class);
                startActivity(intent);

            }
        });
        btnLV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvActivity.this, TVLV2Activity.class);
                startActivity(intent);

            }
        });
        btnLv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvActivity.this, TVLV3Activity.class);
                startActivity(intent);

            }
        });
        btnLv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvActivity.this, TVLV4Activity.class);
                startActivity(intent);

            }
        });
        btnLv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TvActivity.this, TVLV5Activity.class);
                startActivity(intent);

            }
        });
        Animation btn1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);
        btnLv1.startAnimation(btn1);
        Animation btn2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        btnLV2.startAnimation(btn2);
        Animation btn3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.righttoleft);
        btnLv3.startAnimation(btn3);
        Animation btn4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        btnLv4.startAnimation(btn4);
        Animation btn5 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        btnLv5.startAnimation(btn5);
    }
}