package com.example.learningfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learningfun.Model.TT;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class ChinhSuaTTAvtivity extends AppCompatActivity {
    TextInputEditText edHoten,edSdt,edEmail,edNgaysinh;
    Button btnSaveTT;
    List<TT> ttList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chinh_sua_ttavtivity);
        edNgaysinh = findViewById(R.id.ed_ngaySinh);
        edEmail  = findViewById(R.id.ed_email);
        edSdt = findViewById(R.id.ed_sdt);
        edHoten = findViewById(R.id.ed_hoten);
        btnSaveTT = findViewById(R.id.btn_SaveTT);
        ttList = new ArrayList<>();


        btnSaveTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ngaySinh = edNgaysinh.getText().toString();
                String email = edEmail.getText().toString();
                String sdt = edSdt.getText().toString();
                String hoten = edHoten.getText().toString();
                ttList.add(new TT(ngaySinh,email,sdt,hoten));
            }
        });

    }
}