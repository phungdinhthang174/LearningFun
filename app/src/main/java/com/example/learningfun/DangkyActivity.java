package com.example.learningfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learningfun.DAO.DAO_Login;
import com.example.learningfun.Model.LogIn;
import com.google.android.material.textfield.TextInputEditText;

public class DangkyActivity extends AppCompatActivity {
    TextInputEditText editText_user_dk,editText_pass_dk,editText_repass;
    Button btnSighup,btnnextSignin;
    DAO_Login dao_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        editText_user_dk = findViewById(R.id.ed_user_dk);
        editText_pass_dk = findViewById(R.id.ed_password_dk);
        editText_repass = findViewById(R.id.ed_repassword);
        btnnextSignin = findViewById(R.id.btn_Dangnhap);
        btnSighup = findViewById(R.id.btn_signUp);
        dao_login = new DAO_Login(this);
        btnnextSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangkyActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        DK();

    }
    public void DK(){
        btnSighup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText_pass_dk.getText().toString().isEmpty() &&
                editText_pass_dk.getText().toString().isEmpty() && editText_repass.getText().toString().isEmpty()){
                    Toast.makeText (DangkyActivity.this, "Vui lòng nhập đủ dữ liệu trước khi đăng kí", Toast.LENGTH_SHORT).show ();
                }
                String user_dk = editText_user_dk.getText().toString();
                String pass_dk = editText_pass_dk.getText().toString();
                String repasss_dk = editText_repass.getText().toString();
                if (repasss_dk.equals(pass_dk)){
                    LogIn logIn = new LogIn(user_dk,pass_dk);
                    dao_login.ThemTK(logIn);
                    Toast.makeText (DangkyActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show ();
                } else {
                    Toast.makeText (DangkyActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }
}