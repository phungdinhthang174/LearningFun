package com.example.learningfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.learningfun.DAO.DAO_Login;
import com.google.android.material.textfield.TextInputEditText;

public class SignInActivity extends AppCompatActivity {
    TextInputEditText  editTextUser,editTextPassword;
    CheckBox checkBoxGhinho;
    Button buttonSignIn,buttonnextDk;
    DAO_Login dao_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editTextPassword = (TextInputEditText)findViewById(R.id.ed_password);
        editTextUser = (TextInputEditText)findViewById(R.id.ed_user);
        checkBoxGhinho = findViewById(R.id.ckb_ghinho);
        buttonnextDk = findViewById(R.id.btn_nextDk);
        buttonSignIn = findViewById(R.id.btn_signIn);
        dao_login = new DAO_Login(this);



        buttonnextDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this,DangkyActivity.class);
                startActivity(intent);
            }
        });

        DangNhap();

    }
    public void DangNhap(){
        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextUser.getText().toString().isEmpty() && editTextPassword.getText().toString().isEmpty()){
                    Toast.makeText(SignInActivity.this,"Vui lòng không để trống username và password !!",Toast.LENGTH_SHORT).show();
                }
                String user = editTextUser.getText().toString();
                String pass = editTextPassword.getText().toString();
                boolean kt = dao_login.testLogIn(user,pass);
                if (kt){
                    Toast.makeText (SignInActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show ();
                    Intent intent = new Intent (SignInActivity.this, MainActivity.class);
                    startActivity (intent);
                }else{
                    Toast.makeText (SignInActivity.this, "Tài khoản không tồn tại", Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }
}