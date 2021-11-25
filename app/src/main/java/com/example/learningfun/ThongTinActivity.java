package com.example.learningfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThongTinActivity extends AppCompatActivity {
    Button btnCamonhoc,btnThongtin,btn_Chinhsua,btnDangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);
        btnCamonhoc = findViewById(R.id.btn_Cacmonhoc);
        btnThongtin = findViewById(R.id.btn_ThongTin);
        btn_Chinhsua = findViewById(R.id.btn_ChinhSua);
        btnDangxuat = findViewById(R.id.btn_Logout);

        btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongTinActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        btn_Chinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongTinActivity.this,ChinhSuaTTAvtivity.class);
                startActivity(intent);
            }
        });
    }
}