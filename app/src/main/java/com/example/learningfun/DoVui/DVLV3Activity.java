package com.example.learningfun.DoVui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.learningfun.Model.Answer;
import com.example.learningfun.Model.Question;
import com.example.learningfun.R;

import java.util.ArrayList;
import java.util.List;


public class DVLV3Activity extends AppCompatActivity implements View.OnClickListener{
    TextView tvQuestion, tvContent, tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4;
    private List<Question> mlist;
    private Question mquestion;
    private int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dvlv3);
        anhxa();


        mlist = getListQuestion();
        if (mlist.isEmpty()) {
            return;
        }
        setDataQuestion(mlist.get(currentQuestion));
    }

    private void setDataQuestion(Question question) {
        if (question == null) {
            return;
        }
        mquestion = question;
        tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
        tvAnswer4.setBackgroundResource(R.drawable.brow_conner);

        String titleQuestion = "Câu hỏi " + question.getNumber();
        tvQuestion.setText(titleQuestion);
        tvContent.setText(question.getContent());
        tvAnswer1.setText(question.getAnswerList().get(0).getContent());
        tvAnswer2.setText(question.getAnswerList().get(1).getContent());
        tvAnswer3.setText(question.getAnswerList().get(2).getContent());
        tvAnswer4.setText(question.getAnswerList().get(3).getContent());

        tvAnswer1.setOnClickListener(this);
        tvAnswer2.setOnClickListener(this);
        tvAnswer3.setOnClickListener(this);
        tvAnswer4.setOnClickListener(this);

    }




    public void anhxa(){
        tvQuestion = findViewById(R.id.tv_questionNumdv3);
        tvContent = findViewById(R.id.tv_cauhoi_dvLV3);
        tvAnswer1 = findViewById(R.id.btn_dapan1dv3);
        tvAnswer2 = findViewById(R.id.btn_dapan2dv3);
        tvAnswer3 = findViewById(R.id.btn_dapan3dv3);
        tvAnswer4 = findViewById(R.id.btn_dapan4dv3);



    }
    private List<Question> getListQuestion(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(new Answer("Sóc Trăng, Đồng Nai, Sơn La.",true));
        answerList.add(new Answer("Sơn La, Tây Ninh, Đồng Nai.",false));
        answerList.add(new Answer("Đồng Nai, Sóc Trăng, Thái Nguyên.",false));
        answerList.add(new Answer("Sóc Trăng, Sơn La, Phú Quốc",false));

        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("Sóc Trăng; Trà Vinh",false));
        answerList1.add(new Answer("Tiền Giang, Bạc Liêu",true));
        answerList1.add(new Answer("Cần Thơ; An Giang",false));
        answerList1.add(new Answer("Hà Giang; Kiên Giang",false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("Bình Định; Quảng Nam",false));
        answerList2.add(new Answer("Kiên Giang, Bình Phước",false));
        answerList2.add(new Answer("Cần Thơ, Sóc Trăng",true));
        answerList2.add(new Answer("Tây Ninh; Vũng Tàu",false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("Hà Nội",false));
        answerList3.add(new Answer("Cà Mau",false));
        answerList3.add(new Answer("Bến Tre",true));
        answerList3.add(new Answer("TP Hồ Chí Minh",false));
        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("Phú Thọ",false));
        answerList4.add(new Answer("Hà Nội",false));
        answerList4.add(new Answer("Huế",false));
        answerList4.add(new Answer("TP. Hồ Chí Minh",true));




        questionList.add(new Question(1,"Vừa học vừa vui\n" +
                "Ai biết giúp tui\n" +
                "Kể tên ba tỉnh\n" +
                "Có ba con vật hiện ra?",answerList));
        questionList.add(new Question(2,"Tỉnh nào: Có TIỀN, có BẠC ??",answerList1));
        questionList.add(new Question(3,"Tỉnh nào : Có THƠ, có TRĂNG ?",answerList2));
        questionList.add(new Question(4,"Trên trời có ông sao tua.\n" +
                "Ớ đâu lại có nhiều dừa bạn ơi?",answerList3));
        questionList.add(new Question(5,"Nơi nào biết mấy tự hào\n" +
                "Tên vàng chói lọi, thay vào tên xưa?",answerList4));
        return questionList;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dapan1dv3:
                tvAnswer1.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(0));
                break;
            case R.id.btn_dapan2dv3:
                tvAnswer2.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(1));
                break;
            case R.id.btn_dapan3dv3:
                tvAnswer3.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(2));
                break;
            case R.id.btn_dapan4dv3:
                tvAnswer4.setBackgroundResource(R.drawable.blue_conner3);
                checkAnswer(mquestion,mquestion.getAnswerList().get(3));
                break;
        }
    }
    public void checkAnswer(Question question,Answer answer){
        AlertDialog.Builder builder = new AlertDialog.Builder(DVLV3Activity.this);
        LayoutInflater inflater = DVLV3Activity.this.getLayoutInflater();
        View view1   = inflater.inflate(R.layout.dialog_answer,null);
        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        TextView btnCo = view1.findViewById(R.id.btn_Yes);
        TextView btnKo = view1.findViewById(R.id.btn_No);
        btnCo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answer.isCorrect()){

                    nextQuestion();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DVLV3Activity.this);
                    LayoutInflater inflater = DVLV3Activity.this.getLayoutInflater();
                    View view3   = inflater.inflate(R.layout.dialog_thatbai,null);
                    builder.setView(view3);
                    AlertDialog alertDialog1 = builder.create();
                    alertDialog1.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            alertDialog1.dismiss();
                        }
                    },1500);
                }
                alertDialog.dismiss();
                tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer4.setBackgroundResource(R.drawable.brow_conner);
            }
        });
        btnKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                tvAnswer1.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer2.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer3.setBackgroundResource(R.drawable.brow_conner);
                tvAnswer4.setBackgroundResource(R.drawable.brow_conner);
            }
        });

        alertDialog.show();

    }

    private void showAswerCorrecct() {
    }

    private void nextQuestion() {
        if (currentQuestion == mlist.size() - 1){
            AlertDialog.Builder builder3 = new AlertDialog.Builder(DVLV3Activity.this);
            LayoutInflater inflater3 = DVLV3Activity.this.getLayoutInflater();
            View view3   = inflater3.inflate(R.layout.dialog_win,null);
            builder3.setView(view3);
            AlertDialog alertDialog = builder3.create();
            alertDialog.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog.dismiss();
                    Intent intent = new Intent(DVLV3Activity.this, DVLV4Activity.class);
                    startActivity(intent);
                }
            },1400);


        } else{
            AlertDialog.Builder builder = new AlertDialog.Builder(DVLV3Activity.this);
            LayoutInflater inflater = DVLV3Activity.this.getLayoutInflater();
            View view2   = inflater.inflate(R.layout.dialog_chucmung,null);
            builder.setView(view2);
            AlertDialog alertDialog1 = builder.create();
            alertDialog1.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alertDialog1.dismiss();
                }
            },1500);
            currentQuestion++;
            setDataQuestion(mlist.get(currentQuestion));
        }

    }
}