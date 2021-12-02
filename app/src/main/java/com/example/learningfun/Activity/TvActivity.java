package com.example.learningfun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
    }
}