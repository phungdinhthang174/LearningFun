package com.example.learningfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.learningfun.Activity2.WelcomScreenTv;
import com.example.learningfun.Activity2.WelcomeKhActivity;
import com.example.learningfun.Activity2.WelcomeMath;
import com.example.learningfun.Activity2.WelcomeSceenDovuiActivity;
import com.example.learningfun.Activity2.WelcomeTaActivity;
import com.example.learningfun.Adapter.GridView_Adapter;
import com.example.learningfun.Model.GridView1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout layout_main;
    RelativeLayout relativeLayout;
    GridView gridView;
    ArrayList<GridView1> gridView1ArrayList;
    GridView_Adapter gridView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout =  this.findViewById(R.id.re_layout);
        layout_main = this.findViewById(R.id.layout_ll_main);
        gridView = this.findViewById(R.id.grid_layout_main);
        gridView1ArrayList = new ArrayList<>();
        gridView1ArrayList.add(new GridView1(0,"Toán"));
        gridView1ArrayList.add(new GridView1(1,"Tiếng việt"));
        gridView1ArrayList.add(new GridView1(2,"Tiếng anh"));
        gridView1ArrayList.add(new GridView1(3,"Khoa học"));
        gridView1ArrayList.add(new GridView1(4,"Đố vui"));
        gridView1ArrayList.add(new GridView1(5,"Thông tin cá nhân"));
        gridView_adapter = new GridView_Adapter(this,gridView1ArrayList);
        gridView.setAdapter(gridView_adapter);
        Animation giayAni = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);
        gridView.startAnimation(giayAni);
        Animation giayAni1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lefttoright);
        relativeLayout.startAnimation(giayAni1);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent = new Intent(MainActivity.this, WelcomeMath.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainActivity.this, WelcomScreenTv.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainActivity.this, WelcomeTaActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this, WelcomeKhActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainActivity.this, WelcomeSceenDovuiActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(MainActivity.this, ThongTinActivity.class);
                        startActivity(intent5);
                        break;
                }
            }
        });

    }
}