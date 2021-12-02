package com.example.learningfun.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learningfun.DoVui.DVLV1Activity;
import com.example.learningfun.DoVui.DVLV2Activity;
import com.example.learningfun.DoVui.DVLV3Activity;
import com.example.learningfun.DoVui.DVLV4Activity;
import com.example.learningfun.DoVui.DVLV5Activity;
import com.example.learningfun.R;

public class DoVuiActivity extends AppCompatActivity {
    Button btnLv1,btnLV2,btnLv3,btnLv4,btnLv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_vui);
        btnLv1 =  findViewById(R.id.btn_dv_lv1);
        btnLV2 =  findViewById(R.id.btn_dv_lv2);
        btnLv3 =  findViewById(R.id.btn_dv_lv3);
        btnLv4 =  findViewById(R.id.btn_dv_lv4);
        btnLv5 =  findViewById(R.id.btn_dv_lv5);

        btnLv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoVuiActivity.this, DVLV1Activity.class);
                startActivity(intent);
            }
        });
        btnLV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoVuiActivity.this, DVLV2Activity.class);
                startActivity(intent);
            }
        });
        btnLv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoVuiActivity.this, DVLV3Activity.class);
                startActivity(intent);
            }
        });
        btnLv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoVuiActivity.this, DVLV4Activity.class);
                startActivity(intent);
            }
        });
        btnLv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoVuiActivity.this, DVLV5Activity.class);
                startActivity(intent);
            }
        });
    }
}