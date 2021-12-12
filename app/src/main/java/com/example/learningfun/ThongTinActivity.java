package com.example.learningfun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learningfun.Model.TT;
import com.example.learningfun.TVLV.TVLV5Activity;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class ThongTinActivity extends AppCompatActivity {
    Button btnCamonhoc,btnThongtin,btn_Chinhsua,btnDangxuat;
    TextView tvsdt,tvHoten,tvNgaysinh,tvemail;
    String ngaySinh,hoten,sdt,email;
    TextView tvHt;

    TextInputEditText edHoten,edSdt,edEmail,edNgaysinh;
    Button btnSaveTT;
    List<TT> ttList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin);

        btnThongtin = findViewById(R.id.btn_ThongTin);
        btn_Chinhsua = findViewById(R.id.btn_ChinhSua);
        btnDangxuat = findViewById(R.id.btn_Logout);
        tvHoten = findViewById(R.id.tv_ht);
        tvNgaysinh  =findViewById(R.id.tv_ngsinh);
        tvemail = findViewById(R.id.tv_email);
        tvsdt = findViewById(R.id.tv_sdt);

//
        btnDangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinActivity.this);
                LayoutInflater inflater = ThongTinActivity.this.getLayoutInflater();
                View view1   = inflater.inflate(R.layout.dialog_logout,null);
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();
                TextView btnCo = view1.findViewById(R.id.btn_Yes_logout);
                TextView btnKo = view1.findViewById(R.id.btn_No_logout);
                btnCo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ThongTinActivity.this,SignInActivity.class);
                        startActivity(intent);
                    }
                });
                btnKo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();

            }

        });

        btn_Chinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinActivity.this);
                LayoutInflater inflater = ThongTinActivity.this.getLayoutInflater();
                View view1   = inflater.inflate(R.layout.activity_chinh_sua_ttavtivity,null);
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();

                edNgaysinh = view1.findViewById(R.id.ed_ngaySinh);
                edEmail  = view1.findViewById(R.id.ed_email);
                edSdt = view1.findViewById(R.id.ed_sdt);
                edHoten = view1.findViewById(R.id.ed_hoten);
                btnSaveTT = view1.findViewById(R.id.btn_SaveTT);



                btnSaveTT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         ngaySinh = edNgaysinh.getText().toString();

                         email = edEmail.getText().toString();
                         sdt = edSdt.getText().toString();
                         hoten = edHoten.getText().toString();

                        tvHoten.setText(hoten);
                        tvemail.setText(email);
                        tvNgaysinh.setText(ngaySinh);
                        tvsdt.setText(sdt);
                        alertDialog.dismiss();


                    }
                });
                alertDialog.show();

            }
        });
        btnThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ThongTinActivity.this);
                LayoutInflater inflater = ThongTinActivity.this.getLayoutInflater();
                View view1   = inflater.inflate(R.layout.gt_layout,null);
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });



    }

}